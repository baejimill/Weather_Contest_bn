package com.ruby.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.domain.Answer;
import com.ruby.domain.Member;
import com.ruby.domain.Question;
import com.ruby.persistence.AnswerRepository;
import com.ruby.persistence.MemberRepository;
import com.ruby.persistence.QuestionRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Answer createAnswer(Answer answer, Long questionId, Long authorId) { //답변울 생성 작성자가 관리자인지 확인
		//답변 작성자가 관라자만 가능하게!
		 Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
	        Member author = memberRepository.findById(authorId).orElseThrow(() -> new RuntimeException("User not found"));
	        
	        // Check if the user is an admin
		if (!"ADMIN".equals(author.getRole())) {
			throw new RuntimeException("관리자만 답변을 작성할 수 있습니다.");
		}
		answer.setQuestion(question);
		answer.setAuthor(author);
		return answerRepository.save(answer);
	}
	
	public Answer getAnswerById(Long id) { //ID를 통해 답변울 조회
		return answerRepository.findById(id).orElse(null);
	}
	public void deleteAnswer(Long id) { //ID를 통해 답변을 삭제
		answerRepository.deleteById(id);
	}
}
