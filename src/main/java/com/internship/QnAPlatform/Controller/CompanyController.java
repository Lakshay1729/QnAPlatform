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

import com.internship.QnAPlatform.DTO.CompanyDTO;
import com.internship.QnAPlatform.Entity.Company;
import com.internship.QnAPlatform.Service.CompanyService;


@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	
	@PostMapping("/insert")
	@ResponseBody
	public String insertCompany(@RequestBody CompanyDTO company)
	{
		companyService.addCompany(company);
		return "Company with Name: "+company.getCompanyName()+" inserted successfully.";
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public Company getCompany(@PathVariable("id") Long id) throws Exception
	{

		return companyService.readCompany(id);
	}
	
	@PutMapping("/update")
	public CompanyDTO updateCompany(@RequestBody CompanyDTO company)
	{
		return companyService.updateCompany(company);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteCompany(@PathVariable Long id)
	{
		companyService.deleteCompany(id);
		return "Company with ID: "+id+" deleted successfully.";
	}

}
