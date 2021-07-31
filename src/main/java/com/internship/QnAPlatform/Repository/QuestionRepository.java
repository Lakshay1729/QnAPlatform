package com.internship.QnAPlatform.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.internship.QnAPlatform.Entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
//	@Query(value="select q from Question q where q.company in ")
//public List<Question> findAllByFiters();
}
