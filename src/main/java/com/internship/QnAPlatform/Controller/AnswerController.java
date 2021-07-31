package com.internship.QnAPlatform.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.internship.QnAPlatform.DTO.AnswerInputDTO;
import com.internship.QnAPlatform.DTO.AnswerLikesInputDTO;
import com.internship.QnAPlatform.Entity.Answer;
import com.internship.QnAPlatform.Entity.AnswerLikes;
import com.internship.QnAPlatform.Repository.AnswerLikesRepository;
import com.internship.QnAPlatform.Repository.AnswerRepository;
import com.internship.QnAPlatform.Repository.QuestionRepository;
import com.internship.QnAPlatform.Repository.UserRepository;

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	AnswerRepository answerRepo;
	@Autowired
	AnswerLikesRepository answerLikeRepo;

	@PostMapping("/insert")
	public Long insertAnswer(@Valid @RequestBody AnswerInputDTO answerInput) {
		Answer answer = new Answer();
		if (answerInput.getUserId() != 0) {
			answer.setUser(userRepo.findById(answerInput.getUserId()).get());
		}
		if (answerInput.getQuestionId() != 0) {
			answer.setQuestion(questionRepo.findById(answerInput.getQuestionId()).get());
		}
		answer.setAnswerText(answerInput.getAnswerText());
		return answerRepo.save(answer).getId();
	}

	@PostMapping("/inserAnswerLike")
	@ResponseBody
	public String insertAnswerLike(@RequestBody AnswerLikesInputDTO answerLikeInput) {
		AnswerLikes answerLike = new AnswerLikes();
		answerLike.setAnswer(answerRepo.findById(answerLikeInput.getAnswerId()).get());
		answerLike.setUser(userRepo.findById(answerLikeInput.getUserId()).get());
		answerLikeRepo.save(answerLike);
		return "Success";
	}

}
