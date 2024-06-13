package com.ruby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.domain.Member;
import com.ruby.persistence.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
//	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Member createMember(Member member) {
		System.out.println(member);
		//보안을 위해 비밀번호 해쉬 처리
//		member.setPassword(passwordEncoder.encode(member.getPassword()));
		return memberRepository.save(member);
	}
	
	public Member getMemberById(Long id) {
		return memberRepository.findById(id).orElse(null);
	}
}