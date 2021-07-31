package com.internship.QnAPlatform.Service;

import com.internship.QnAPlatform.DTO.CompanyDTO;
import com.internship.QnAPlatform.Entity.Company;

public interface CompanyService {

	public Long addCompany(CompanyDTO companyDTO);

	Company readCompany(Long id) throws Exception;

	CompanyDTO updateCompany(CompanyDTO company);

	String deleteCompany(Long id);

}
