package com.internship.QnAPlatform.DTO;

import java.util.List;

import com.internship.QnAPlatform.Entity.Question;

import lombok.Data;

@Data
public class CompanyDTO {
	private Long companyId;
	private String companyName;
	private List<Question> question;
}
