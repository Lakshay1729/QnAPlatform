package com.internship.QnAPlatform.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.internship.QnAPlatform.DTO.FilterQuestionsRequest;
import com.internship.QnAPlatform.Entity.Question;
import com.internship.QnAPlatform.Repository.QuestionRepository;
import com.internship.QnAPlatform.Service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
//
//	@Override
//	public List<Question> filterQuestions(FilterQuestionsRequest filters) {
//		// TODO Auto-generated method stub
//		questionRepository.findAll(, null);
//		return null;
//	}

}
