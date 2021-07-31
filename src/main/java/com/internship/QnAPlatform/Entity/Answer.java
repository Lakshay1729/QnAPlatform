package com.internship.QnAPlatform.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String answerText;
	
	@ManyToOne
	@JoinColumn(name="questionID")
	@JsonIgnore
	private Question question;
	
	@OneToOne
	@JoinColumn(name="userID")
	private User user;
	
	@OneToMany(mappedBy = "answer")
	private List<AnswerLikes> answerLikes;
	
	@OneToMany(mappedBy = "answer")
	
	private List<AnswerComments> comment;

}
