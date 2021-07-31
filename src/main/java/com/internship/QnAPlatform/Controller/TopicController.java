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

import com.internship.QnAPlatform.Entity.Topic;
import com.internship.QnAPlatform.Service.TopicsService;

@RestController
@RequestMapping("/topic")
public class TopicController {
	@Autowired
	TopicsService topicService;
	
	@PostMapping("/insert")
	@ResponseBody
	public String insertTopic(@RequestBody Topic topic)
	{
		topicService.insertTopic(topic);
		return "Topic with ID: "+topic.getId()+" inserted successfully.";
		
	}
	
	@GetMapping("/get/{id}")
	public Topic getTopic(@PathVariable Long id)
	{
		return topicService.readTopic(id);
	}
	
	@PutMapping("/update")
	public Topic updateTopic(@RequestBody Topic topic)
	{
		return topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteTopic(@PathVariable Long id)
	{
		topicService.deleteTopic(id);
		return "Topic with ID: "+id+" deleted successfully.";
	}

}
