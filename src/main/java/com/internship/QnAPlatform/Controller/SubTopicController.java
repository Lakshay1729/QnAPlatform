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

import com.internship.QnAPlatform.DTO.SubTopicInputDTO;
import com.internship.QnAPlatform.Entity.SubTopic;
import com.internship.QnAPlatform.Entity.Topic;
import com.internship.QnAPlatform.Service.SubTopicsService;
import com.internship.QnAPlatform.Service.TopicsService;

@RestController
@RequestMapping("/subTopic")
public class SubTopicController {
	@Autowired
	SubTopicsService subTopicService;
	@Autowired
	TopicsService topicService;

	@PostMapping("/insert")

	public SubTopic insertSubTopic(@RequestBody SubTopicInputDTO subTopicDto) {
		SubTopic subTopic = new SubTopic();
		Topic topic = topicService.readTopic(subTopicDto.getTopicId());
		subTopic.setSubTopic(subTopicDto.getSubTopic());
		subTopic.setTopic(topic);
		return subTopicService.insertSubTopic(subTopic);
	}

	@GetMapping("/get/{id}")
	public SubTopic getSubTopic(@PathVariable Long id) {
		return subTopicService.readSubTopic(id);
	}

	@PutMapping("/update")
	public SubTopic updateSubTopic(@RequestBody SubTopic subTopic) {
		return subTopicService.updateSubTopic(subTopic);
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteSubTopic(@PathVariable Long id) {
		subTopicService.deleteSubTopic(id);
		return "SubTopic with ID: " + id + " deleted successfully.";
	}

}
