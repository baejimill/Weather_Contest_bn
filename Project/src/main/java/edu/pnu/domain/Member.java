package edu.pnu.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	
	@Column(unique = true)
	private String email;
	
	private String password;
//	@Enumerated(EnumType.STRING) //숫자가 아니라 글자로 인식
	private Role role;  //USER or ADMIN
	
	@Builder.Default
	@Column(name = "join_date")
	private LocalDateTime joinDate = LocalDateTime.now();

	 // 새로 추가된 부분: Member와 Question의 관계 정의  여기부분 때문에 로그인 오류 생김!!ㅜㅜ
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER) //member 로드 될떄? 같이 로드된다? 
    @JsonManagedReference //member객체룰 json으로 만들때 skip생략 
    private List<Question> questions;
    
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Result> results;

    


}
