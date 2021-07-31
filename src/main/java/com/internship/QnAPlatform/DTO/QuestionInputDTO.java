package com.internship.QnAPlatform.DTO;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.internship.QnAPlatform.Entity.Tags;

public class QuestionInputDTO {
	
	@Size(min=50,max=500,message = "QuestionText should be bewteen 50 and 500 characters long.")
	private String questionText;
	private Long companyId;
	@NotNull
	private Long subTopicId;
	private List<Long> tags;
	private Long userId;
	
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public Long getSubTopicId() {
		return subTopicId;
	}
	public void setSubTopicId(Long subTopicId) {
		this.subTopicId = subTopicId;
	}
	public List<Long> getTags() {
		return tags;
	}
	public void setTags(List<Long> tags) {
		this.tags = tags;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
