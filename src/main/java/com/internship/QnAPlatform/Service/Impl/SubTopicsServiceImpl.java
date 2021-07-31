package com.internship.QnAPlatform.Service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.QnAPlatform.Entity.SubTopic;
import com.internship.QnAPlatform.Repository.SubTopicsRepository;
import com.internship.QnAPlatform.Service.SubTopicsService;

@Service("subTopicsService")
@Transactional
public class SubTopicsServiceImpl implements SubTopicsService{
	
	@Autowired
	private SubTopicsRepository subTopicRepo;

	@Override
	public SubTopic insertSubTopic(SubTopic subTopic) {
		
		return subTopicRepo.save(subTopic);
	}

	@Override
	public SubTopic readSubTopic(Long id) {
		
		return subTopicRepo.findById(id).get();
	}

	@Override
	public SubTopic updateSubTopic(SubTopic subTopic) {
		return subTopicRepo.save(subTopic);
	}

	@Override
	public String deleteSubTopic(Long id) {
		// TODO Auto-generated method stub
		subTopicRepo.deleteById(id);
		return "Successfully Deleted";
	}

}
