package com.internship.QnAPlatform.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	
	private String question;
	@OneToMany
	@JoinColumn(name="companyID")
	private List<Company> company;
	
	
	@OneToOne
	@JoinColumn(name="subTopicID")
	private SubTopic subTopic;
	
	@ManyToMany
	@JoinColumn(name="tagID")
	private List<Tags> tag;
	
	
	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answers;
	
	@OneToMany(mappedBy="question")
	private List<QuestionLikes> questionLikes;

}
