package com.ruby.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ruby.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findByemail(String email);

}
