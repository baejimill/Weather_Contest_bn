package com.ruby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.domain.Answer;
import com.ruby.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@PostMapping
	public Answer createAnswer(@RequestBody Answer answer) {
		return answerService.createAnswer(answer);
	}
	@GetMapping("/{id}")
	public Answer getAnswerById(@PathVariable Long id) {
		return answerService.getAnswerById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteAnswer(@PathVariable Long id) {
		answerService.deleteAnswer(id);
	}
}
