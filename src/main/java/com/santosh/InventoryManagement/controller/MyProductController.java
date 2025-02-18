package com.santosh.InventoryManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.InventoryManagement.Dao.ProductDao;
import com.santosh.InventoryManagement.entities.Company;
import com.santosh.InventoryManagement.entities.Product;
import com.santosh.InventoryManagement.services.CompanyService;
import com.santosh.InventoryManagement.services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MyProductController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private ProductService productService;
	@GetMapping("/product")
	public List<Product> getCompany(){
		return this.productService.getProduct();
	}
	
	@GetMapping("/product/{companyId}")
	public List<Product> findByCompany(@PathVariable String companyId) {
		return (List<Product>) this.productService.findByCompany(Integer.parseInt(companyId));
	}
	@PostMapping("/product/{companyId}")
	public Product addCompany(@PathVariable String companyId,@RequestBody Product product) {
	
		Company company=(Company)this.companyService.getCompany(Integer.parseInt(companyId));
		product.setC(company);
		
		return this.productService.addProduct(product);
	}
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable String productId) {
		this.productService.deleteProduct(Integer.parseInt(productId));
	}
	@PutMapping("/product/{productId}/{companyId}")
	private Product updateProduct(@RequestBody Product product,@PathVariable Integer productId,@PathVariable Integer companyId ) {
		
		return this.productService.updateProduct(product, productId,companyId);
	}
}
