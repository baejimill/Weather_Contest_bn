package com.ruby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.domain.Answer;
import com.ruby.domain.Member;
import com.ruby.persistence.AnswerRepository;
import com.ruby.persistence.MemberRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Answer createAnswer(Answer answer) {
		//답변 작성자가 관라자만 가능하게!
		Member author = memberRepository.findById(answer.getAuthor().getId()).orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));
		if (!"ADMIN".equals(author.getRole())) {
			throw new RuntimeException("관리자만 답변을 작성할 수 있습니다.");
		}
		return answerRepository.save(answer);
	}
	public Answer getAnswerById(Long id) {
		return answerRepository.findById(id).orElse(null);
	}
	public void deleteAnswer(Long id) {
		answerRepository.deleteById(id);
	}
}
