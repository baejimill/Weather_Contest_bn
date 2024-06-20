package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Answer;
import edu.pnu.service.AnswerService;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	
	@PostMapping("/answer")
	public Answer createAnswer(@RequestBody Answer answer, @RequestParam Long questionId, @RequestParam Long authorId) {
		return answerService.createAnswer(answer, questionId, authorId);
	}
	@GetMapping("/id/{id}")
	public Answer getAnswerById(@PathVariable Long id) {
		return answerService.getAnswerById(id);
	}
	@DeleteMapping("/{id}")
	public void deleteAnswer(@PathVariable Long id) {
		answerService.deleteAnswer(id);
	}
}