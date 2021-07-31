package com.internship.QnAPlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internship.QnAPlatform.Entity.AnswerComments;

public interface CommentRepository extends JpaRepository<AnswerComments, Integer>{

}
