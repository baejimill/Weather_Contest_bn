package com.ruby.config;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Bean
//	SecurityFilterChain filerChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(auth-> auth
//				.anyRequest().permitAll());
//		http.cors(cors->cors.configurationSource(corsSource()));
//		return http.build();
//	}
//	@Bean
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
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
//}
