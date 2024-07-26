package edu.pnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Feature;
import edu.pnu.domain.Member;
import edu.pnu.domain.Result;
import edu.pnu.persistence.FeatureRepository;
import edu.pnu.persistence.MemberRepository;
import edu.pnu.persistence.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Result saveResult(Result result) {
		// feature와 member를 DB에서 조회하여 설정
		Feature feature = featureRepository.findById(result.getFeature().getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid feature ID: " + result.getFeature().getId()));
		Member member = memberRepository.findById(result.getMember().getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + result.getMember().getId()));
		
		result.setFeature(feature);
		result.setMember(member);
		
		// Result 객체 저장
		return resultRepository.save(result);
	}
}
