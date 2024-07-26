package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.pnu.DTO.FeatureDTO;
import edu.pnu.domain.Feature;
import edu.pnu.persistence.FeatureRepository;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository featureRepository;

    public String findFeatures(String stn4contest, String efYear, String efMonth, String efDay, String efHour) {
       
        List<Feature> list = featureRepository.findFeatures(stn4contest, efYear, efMonth, efDay, efHour);

        Feature f = list.get(0);
        
        FeatureDTO dto = FeatureDTO.of(f);
        
        //return dto.toString(); //test용 to string return!
        
        //플라스크로 데이터를 전송하고 응답을 받음
        System.out.println(dto);
        return sendFeaturesToFlask(dto);
    }
    public String sendFeaturesToFlask(FeatureDTO feature) {
        //헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
     // ObjectMapper를 이용해 List<FeatureDTO>를 JSON으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFeatures = "";
        try {
            jsonFeatures = objectMapper.writeValueAsString(feature);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(feature);
        }
        
        // 요청 엔티티 생성
        HttpEntity<String> request = new HttpEntity<>(jsonFeatures, headers);

        // RestTemplate으로 POST 요청 전송
        RestTemplate restTemplate = new RestTemplate();
        String flaskurl = "http://172.21.102.14:5000/predict";
        ResponseEntity<String> flaskResponse = restTemplate.postForEntity(flaskurl, request, String.class);

        // 플라스크 응답 처리
        System.out.println("Flask response: " + flaskResponse.getBody());

        return flaskResponse.getBody();
    }
	public List<FeatureDTO> getFeatures(String stn4contest, String year, String month, String day) {
		List<Feature> list = featureRepository.getFeatures(stn4contest, year, month, day);
		List<FeatureDTO> ret = new ArrayList<>();
		for(Feature f: list)
			ret.add(FeatureDTO.of(f));
		return ret;
	}
}


