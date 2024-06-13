package com.ruby.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.domain.Question;
import com.ruby.persistence.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}
	public Question getQuestionById(Long id) {
		return questionRepository.findById(id).orElse(null);
	}
	
	public Question updateQuestion(Long id, Question updatedQuestion) {
		
//		return questionRepository.findById(id).map(question -> {
//			 question.setTitle(updatedQuestion.);
//	            question.setContent(updatedQuestion.getContent());
//	            return questionRepository.save(question);
//		}).orElseThrow(()-> new RuntimeException("질문을 찾을 수 없습니다."));
	}
	public void deletQuestion(Long id) {
		questionRepository.deleteById(id);
	}
}