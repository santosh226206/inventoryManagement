package com.santosh.InventoryManagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosh.InventoryManagement.entities.Product;
@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	
}
