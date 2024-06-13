package com.ruby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.domain.Member;
import com.ruby.domain.Question;
import com.ruby.persistence.MemberRepository;
import com.ruby.persistence.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private MemberRepository memberRepository;
	
	public Question createQuestion(Question question, Long authorId) { //작성자(author)룰 설정 질문을 저장
		Member author = memberRepository.findById(authorId).orElseThrow(()-> new RuntimeException("회원을 찾을 수 없습니다."));
		question.setAuthor(author);
		return questionRepository.save(question);
	}
	
	public List<Question> getAllQuestions() { //모든 질문을 조회
		return questionRepository.findAll();
	}
	
	public Question getQuestionById(Long id) { //Id를 통해 질문을 조회
		return questionRepository.findById(id).orElse(null);
	}
	
	public Question updateQuestion(Long id, Question updatedQuestion) { //기존 질물을 업데이트
		return questionRepository.findById(id).map(question -> {
			 question.setTitle(updatedQuestion.getTitle());
	            question.setContent(updatedQuestion.getContent());
	            return questionRepository.save(question);
		}).orElseThrow(()-> new RuntimeException("질문을 찾을 수 없습니다."));
	}
	public void deletQuestion(Long id) { //ID를 통해 질문을 삭제
		questionRepository.deleteById(id);
	}
}