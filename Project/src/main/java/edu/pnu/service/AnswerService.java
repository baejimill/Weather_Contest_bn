package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Answer;
import edu.pnu.domain.Member;
import edu.pnu.domain.Question;
import edu.pnu.persistence.AnswerRepository;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.persistence.QuestionRepository;

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
	        Member member = memberRepository.findById(authorId).orElseThrow(() -> new RuntimeException("User not found"));
	        
	        // Check if the user is an admin
		if (!"ADMIN".equals(member.getRole())) {
			throw new RuntimeException("관리자만 답변을 작성할 수 있습니다.");
		}
		answer.setQuestion(question);
		answer.setMember(member);
		return answerRepository.save(answer);
	}
	
	public Answer getAnswerById(Long id) { //ID를 통해 답변울 조회
		return answerRepository.findById(id).orElse(null);
	}
	public void deleteAnswer(Long id) { //ID를 통해 답변을 삭제
		answerRepository.deleteById(id);
	}
}
