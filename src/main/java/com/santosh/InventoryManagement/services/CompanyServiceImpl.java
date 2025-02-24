package com.santosh.InventoryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.InventoryManagement.Dao.CompanyDao;
import com.santosh.InventoryManagement.entities.Company;
import com.santosh.InventoryManagement.exception.CompanyNotFoundException;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;

	public CompanyServiceImpl() {
		System.out.println("comapany-serviceimpl-created");
	}

	@Override
	public List<Company> getCompany() {
		 
		return companyDao.findAll();
	}

	@Override
	public Company getCompany(Integer companyId) {
	        return companyDao.findById(companyId).get();
		//return companyDao.getOne(companyId);
	}

	@Override
	public Company addCompany(Company company) {
		companyDao.save(company);
		//company.setcName("hello world");
		
		return companyDao.save(company);
		
	}

	@Override
	public Company updateCompany(Company company) {
		return companyDao.save(company); 
	}

	@Override
	public void deleteCompany(Integer companyId) {
		// TODO Auto-generated method stub
		Company entity=(Company)companyDao.findById(companyId).get();
		companyDao.delete(entity);
		
	}



}
