package com.ruby.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
