package com.ruby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class MemberTest {
	@Autowired
	private MemberRepository memberRepository;
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Test
	public void addMember() {
		
		Member mem = Member.builder()
					.username("33")
					.email("33@naver.com")
					.password(passwordEncoder.encode("33"))
					.role("USER")
					.build();
		
		memberRepository.save(mem);
	
	}
}

