package com.internship.QnAPlatform.Service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.QnAPlatform.Entity.Topic;
import com.internship.QnAPlatform.Repository.TopicsRepository;
import com.internship.QnAPlatform.Service.TopicsService;

@Service("topicsService")
@Transactional
public class TopicsServiceImpl implements TopicsService {

	@Autowired
	TopicsRepository topicRepo;

	@Override
	public void insertTopic(Topic topic) {

		topicRepo.save(topic);

	}

	@Override
	public Topic readTopic(Long id) {

		return topicRepo.findById(id).get();
	}

	@Override
	public Topic updateTopic(Topic topic) {

		return topicRepo.save(topic);
	}

	@Override
	public void deleteTopic(Long id) {

		topicRepo.deleteById(id);
	}

}
