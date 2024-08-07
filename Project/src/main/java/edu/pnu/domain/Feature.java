package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Feature {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private Member user;
	
//	@Builder.Default
//	@Column(name = "request_date")
//	private LocalDateTime requestDate = LocalDateTime.now();
	
	private String fcYear;
	private Long fcMonth;
	private Long fcDay;
	private Long fcHour;
	private Long dh;
	private Long v01;
	private Long v02;
	private Long v03;
	private Long v04;
	private Long v05;
	private Long v06;
	private Long v07;
	private Long v08;
	private Long v09;
	
	private String stn4contest;
	private String efYear;
	private Long efMonth;
	private Long efDay;
	private Long efHour;
}
