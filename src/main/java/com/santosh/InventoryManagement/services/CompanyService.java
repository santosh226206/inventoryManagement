package com.santosh.InventoryManagement.services;

import java.util.List;

import com.santosh.InventoryManagement.entities.Company;

public interface CompanyService {

	public List<Company> getCompany();
	public Company getCompany(Integer companyId);
	public Company addCompany(Company company);
	public Company updateCompany(Company company);
	public void deleteCompany(Integer companyId);
}
