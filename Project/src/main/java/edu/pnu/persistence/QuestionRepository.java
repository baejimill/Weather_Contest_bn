package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
