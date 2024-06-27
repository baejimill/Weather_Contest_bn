package edu.pnu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.service.FeatureService;

@RestController
@RequestMapping("/api")
public class FeatureController {
	
	@Autowired
	private FeatureService featureService;
	
	// 프런트 그래프를 그리기 위한 데이터
	@GetMapping("/features")
	// localhost:8080/features?stn4contest=STN001&year=A&month=5&day=1
	public ResponseEntity<?> getFeatures(String stn4contest, String year, String month, String day) {
		
		return ResponseEntity.ok(featureService.getFeatures(stn4contest, year, month, day));
	}
	
	
	
	// 예측 데이터 생성 및 전달
	@PostMapping("/features") 
	 public ResponseEntity<?> findFeatures(@RequestBody Map<String, String> params) {
        String stn4contest = params.get("stn4contest");
        String efYear = params.get("efYear");
        String efMonth = params.get("efMonth");
        String efDay = params.get("efDay");
        String efHour = params.get("efHour");

        String ret = featureService.findFeatures(stn4contest, efYear, efMonth, efDay, efHour);
        
        return ResponseEntity.ok(ret);
	}
}
