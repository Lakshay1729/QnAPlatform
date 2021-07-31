package com.internship.QnAPlatform.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.QnAPlatform.DTO.CommentInputDTO;
import com.internship.QnAPlatform.Entity.AnswerComments;
import com.internship.QnAPlatform.Repository.AnswerRepository;
import com.internship.QnAPlatform.Repository.CommentRepository;
import com.internship.QnAPlatform.Repository.UserRepository;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	AnswerRepository answerRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CommentRepository commentRepo;
	
	@PostMapping("/insert")
	public Long insertComment(@Valid @RequestBody CommentInputDTO commentInput)
	{
		AnswerComments comment=new AnswerComments();
		comment.setAnswer(answerRepo.findById(commentInput.getAnswerId()).get());
		comment.setUser(userRepo.findById(commentInput.getUserId()).get());
		comment.setCommentText(commentInput.getCommentText());
		
		return commentRepo.save(comment).getId();
	}

}
