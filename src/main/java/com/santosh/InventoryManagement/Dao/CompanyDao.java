package com.santosh.InventoryManagement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosh.InventoryManagement.entities.Company;
@Repository
public interface CompanyDao extends JpaRepository<Company, Integer>{
	
}
