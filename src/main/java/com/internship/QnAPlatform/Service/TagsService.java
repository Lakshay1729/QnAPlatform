package com.internship.QnAPlatform.Service;

import com.internship.QnAPlatform.Entity.Tags;

public interface TagsService {
	void insertTag(Tags tag);

	Tags readTag(Long id);

	Tags updateTag(Tags tag);

	void deleteTag(Long id);
}
