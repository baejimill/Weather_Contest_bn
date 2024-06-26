package edu.pnu.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "question")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String content;
	
	@ManyToOne //한명의 작성자가 여러 질문 가능
	@JoinColumn(name = "member_id")
	@JsonBackReference
	private Member member; //필드 이름에 _id가 없어도 @JoinColumn 을 이용해서 'author_id' 컬럼과 연결!
	
	@Builder.Default
	@Column(name = "question_date")
	private LocalDateTime questionDate = LocalDateTime.now();
	
	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL) //@OneTOOne은 하나의 질문에 하나의 답변만
	private Answer answer; //엔티티 내에서 해당 질문과 연결된 답변(Answer)을 참조하는 필드를 정의한 것
}
