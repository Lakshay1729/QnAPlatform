package com.internship.QnAPlatform.Service;

import com.internship.QnAPlatform.Entity.Topic;

public interface TopicsService {
	void insertTopic(Topic topic);

	Topic readTopic(Long id);

	Topic updateTopic(Topic topic);

	void deleteTopic(Long id);
}
