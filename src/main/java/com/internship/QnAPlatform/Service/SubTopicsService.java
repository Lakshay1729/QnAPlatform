package com.internship.QnAPlatform.Service;

import com.internship.QnAPlatform.Entity.SubTopic;

public interface SubTopicsService {
	SubTopic insertSubTopic(SubTopic subTopic);

	SubTopic readSubTopic(Long id);

	SubTopic updateSubTopic(SubTopic SubTopic);

	String deleteSubTopic(Long id);
}
