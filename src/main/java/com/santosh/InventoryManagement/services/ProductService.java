package com.santosh.InventoryManagement.services;

import java.util.List;
import java.util.Optional;

import com.santosh.InventoryManagement.entities.Company;
import com.santosh.InventoryManagement.entities.Product;

public interface ProductService {

	public List<Product> getProduct();
	public Product getProduct(Integer productId);
	public Product addProduct(Product product);
	public Product updateProduct(Product product,Integer productId,Integer companyId);
	public void deleteProduct(Integer productId);
	public List<Product> findByCompany(Integer companyId);
}
