package com.internship.QnAPlatform.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnswerInputDTO {
	
	private Long questionId;
	@NotNull
	@Size(min=50,max=500,message = "Answer Length should between 50 to 500.")
	private String answerText;
	private Long userId;
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	

}
