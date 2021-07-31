package com.internship.QnAPlatform.Service.Impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.QnAPlatform.DTO.CompanyDTO;
import com.internship.QnAPlatform.Entity.Company;
import com.internship.QnAPlatform.Repository.CompanyRepository;
import com.internship.QnAPlatform.Service.CompanyService;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	public Long addCompany(CompanyDTO companyDTO) {
		Company company = modelMapper.map(companyDTO, Company.class);

		Company savedCompany = companyRepository.save(company);
		return savedCompany.getId();

	}

	@Override
	public Company readCompany(Long id) throws Exception {
		Optional<Company> companyOp = companyRepository.findById(id);
		Company company = companyOp.orElseThrow(()->new Exception("Company with given ID not found"));
		return company;
	}

	@Override
	public CompanyDTO updateCompany(CompanyDTO company) {
		Optional<Company> companyOp = companyRepository.findById(company.getCompanyId());
		companyOp.ifPresent((c)->companyRepository.save(modelMapper.map(c, Company.class)));
		return company;
	}

	@Override
	public String deleteCompany(Long id) {
		companyRepository.findById(id).ifPresent((d)->companyRepository.delete(d));
		return "Successfully Deleted";
	}

}
