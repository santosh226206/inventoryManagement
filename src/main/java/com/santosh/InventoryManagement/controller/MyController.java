package com.santosh.InventoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.InventoryManagement.entities.Company;
import com.santosh.InventoryManagement.services.CompanyService;

@RestController
@CrossOrigin(allowedHeaders="*",origins="*")
public class MyController {
	public MyController() {
		System.out.println("controllerr-created");
	}

	@Autowired
	private CompanyService companyService;
	@GetMapping("/company")
	public List<Company> getCompany(){
		return this.companyService.getCompany();
	}
	
	@GetMapping("/company/{companyId}")
	public Company getCompany(@PathVariable String companyId) {
		return this.companyService.getCompany(Integer.parseInt(companyId));
	}
	@PostMapping("/company")
	public Company addCompany(@RequestBody Company company) {
		return this.companyService.addCompany(company);
	}
	
}
