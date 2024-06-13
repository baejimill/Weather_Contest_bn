package com.ruby.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.domain.Question;
import com.ruby.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping
	public Question cresteQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	@GetMapping
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		return questionService.getQuestionById(id);
	}
	@PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id, updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deletQuestion(id);
    }

}
