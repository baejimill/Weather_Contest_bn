package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Result;
import edu.pnu.service.ResultService;

@RestController
@RequestMapping("/api")
public class ResultController {
	@Autowired
	private ResultService resultService;
	
	@PostMapping("/save_results")
	public ResponseEntity<Result> createResult(@RequestBody Result result) {
		Result savedResult = resultService.saveResult(result);
		
		return ResponseEntity.ok(savedResult);
	}

}
