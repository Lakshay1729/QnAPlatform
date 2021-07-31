package com.internship.QnAPlatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.internship.QnAPlatform.Entity.Tags;
import com.internship.QnAPlatform.Service.TagsService;

@RestController
@RequestMapping("/tag")
public class TagController {
	@Autowired
	TagsService tagService;
	
	@PostMapping("/insert")
	@ResponseBody
	public String insertTag(@RequestBody Tags tag)
	{
		tagService.insertTag(tag);
		return "Tag with ID: "+tag.getId()+" inserted successfully.";
	}
	
	@GetMapping("/get/{id}")
	public Tags getTag(@PathVariable Long id)
	{
		return tagService.readTag(id);
	}
	
	@PutMapping("/update")
	public Tags updateCompany(@RequestBody Tags tag)
	{
		return tagService.updateTag(tag);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteTag(@PathVariable Long id)
	{
		tagService.deleteTag(id);
		return "Tag with ID: "+id+" deleted successfully.";
		
	}

}

