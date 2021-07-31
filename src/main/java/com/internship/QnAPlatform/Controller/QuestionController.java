package com.internship.QnAPlatform.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.internship.QnAPlatform.DTO.QuestionInputDTO;
import com.internship.QnAPlatform.DTO.QuestionLikesInputDTO;
import com.internship.QnAPlatform.Entity.Company;
import com.internship.QnAPlatform.Entity.Question;
import com.internship.QnAPlatform.Entity.QuestionLikes;
import com.internship.QnAPlatform.Entity.Tags;
import com.internship.QnAPlatform.Repository.QuestionLikesRepository;
import com.internship.QnAPlatform.Repository.QuestionRepository;
import com.internship.QnAPlatform.Repository.UserRepository;
import com.internship.QnAPlatform.Service.CompanyService;
import com.internship.QnAPlatform.Service.QuestionService;
import com.internship.QnAPlatform.Service.SubTopicsService;
import com.internship.QnAPlatform.Service.TagsService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	QuestionLikesRepository questionLikeRepo;
	@Autowired
	CompanyService companyService;
	@Autowired 
	SubTopicsService subTopicService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TagsService tagService;
	
	
	@PostMapping("/insert")
	public Long saveQuestion(@Valid @RequestBody QuestionInputDTO questionDTO) throws Exception
	{
		List<Tags> tags=new ArrayList<>();;
		
		Question question=new Question();
		question.setQuestion(questionDTO.getQuestionText());
		if(questionDTO.getCompanyId()!=0)
		{
			List<Company> list=new ArrayList<>();
			list.add(companyService.readCompany(questionDTO.getCompanyId()));
			question.setCompany(list);
		}
		
		
		question.setSubTopic(subTopicService.readSubTopic(questionDTO.getSubTopicId()));
		tags.clear();
		for(Long tag:questionDTO.getTags())
		{
			
			tags.add(tagService.readTag(tag));
			
		}
		question.setTag(tags);
		
		if(questionDTO.getUserId()!=0)
			question.setUser(userRepo.findById(questionDTO.getUserId()).get());
		
		return questionRepo.save(question).getId();
		
	}
	
	@PostMapping("/insertQuestionLike")
	@ResponseBody
	public String insertQuestionLike(@RequestBody QuestionLikesInputDTO questionLikeInput)
	{
		QuestionLikes questionLike=new QuestionLikes();
		questionLike.setQuestion(questionRepo.findById(questionLikeInput.getQuestionId()).get());
		questionLike.setUser(userRepo.findById(questionLikeInput.getUserId()).get());
		questionLikeRepo.save(questionLike);
		return "Success";
	}
	
	@GetMapping("/get/{id}")
	public Question getQuestion(@PathVariable Long id)
	{
		return questionRepo.findById(id).get();
	}


}
