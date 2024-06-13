package com.ruby.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
