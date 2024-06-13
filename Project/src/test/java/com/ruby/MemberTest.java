package com.ruby;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ruby.domain.Member;
import com.ruby.persistence.MemberRepository;

@SpringBootTest
public class MemberTest {
	@Autowired
	private MemberRepository memberRepository;
//	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Test
	public void addMember() {
		Member mem = Member.builder()
					.name("11")
					.email("11@naver.com")
//					.password(passwordEncoder.encode("11"))
					.role("USER")
					.build();
		
		memberRepository.save(mem);
	}
}
