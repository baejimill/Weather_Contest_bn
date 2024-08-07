package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;


import edu.pnu.config.filter.JWTAuthenticationFilter;
import edu.pnu.config.filter.JWTAuthorizationFilter;
import edu.pnu.persistence.MemberRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	 private AuthenticationConfiguration authenticationConfiguration;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
		http.csrf(cf->cf.disable());
		
        http.authorizeHttpRequests(auth -> auth
//        		.requestMatchers("/api/members","/api/login").hasAnyRole("USER", "ADMIN")
                .anyRequest().permitAll());
  
        
        http.formLogin(frmLogin->frmLogin.disable());  // Form을 이용한 로그인을 사용하지 않겠다는 설정
        
        http.httpBasic(basic->basic.disable());        //// Http Basic인증 방식을 사용하지 않겠다는 설정
        // 세션을 유지하지 않겠다고 설정 ➔ Url 호출 뒤 응답할 때 까지는 유지되지만 응답 후 삭제된다는 의미.
        http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        
        http.addFilter(new JWTAuthenticationFilter(authenticationConfiguration.getAuthenticationManager(), memberRepository));
        
        // 스프링 시큐리티가 등록한 필터들 중에서 AuthorizationFilter 앞에 앞에서 작성한 필터를 삽입한다.
        http.addFilterBefore(new JWTAuthorizationFilter(memberRepository), AuthorizationFilter.class);
        
//		http.cors(cors->cors.configurationSource(corsSource()));
		return http.build();
	}
	

	
//	private CorsConfigurationSource corsSource() {
//		 CorsConfiguration config = new CorsConfiguration();
//		 config.addAllowedOriginPattern(CorsConfiguration.ALL) ;
//		 config.addAllowedMethod(CorsConfiguration.ALL) ;
//		 config.addAllowedHeader(CorsConfiguration.ALL);
//		 config.setAllowCredentials(true);
//		 config.addExposedHeader(CorsConfiguration.ALL);
//		 // 요청을 허용할 서버
//		// 요청을 허용할 Method
//		 // 요청을 허용할 Header
//		 // 요청/응답에 자격증명정보 포함을 허용
//		// true인 경우 addAllowedOrigin(“*”)는 사용 불가 ➔ Pattern으로 변경
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		 source.registerCorsConfiguration("/**", config);
//		 return source;
//	}
}