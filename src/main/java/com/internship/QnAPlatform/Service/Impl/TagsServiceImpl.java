package com.internship.QnAPlatform.Service.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.QnAPlatform.Entity.Tags;
import com.internship.QnAPlatform.Repository.TagsRepository;
import com.internship.QnAPlatform.Service.TagsService;

@Service("tagsService")
@Transactional
public class TagsServiceImpl implements TagsService
{
	@Autowired
	TagsRepository tagRepo;

	@Override
	public void insertTag(Tags tag) {
		
		tagRepo.save(tag);
		
	}

	@Override
	public Tags readTag(Long id) {
		
		return tagRepo.findById(id).get();
	}

	@Override
	public Tags updateTag(Tags tag) {
		
		return tagRepo.save(tag);
	}

	@Override
	public void deleteTag(Long id) {
		
		tagRepo.deleteById(id);
	}


}
