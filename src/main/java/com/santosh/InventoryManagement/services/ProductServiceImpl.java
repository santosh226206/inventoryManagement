package com.santosh.InventoryManagement.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.InventoryManagement.Dao.CompanyDao;
import com.santosh.InventoryManagement.Dao.ProductDao;
import com.santosh.InventoryManagement.entities.Company;
import com.santosh.InventoryManagement.entities.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProduct(Integer productId) {
		// TODO Auto-generated method stub
		return productDao.findById(productId).get();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product,Integer productId,Integer companyId) {
		// TODO Auto-generated method stub
		/*Product entity=(Product)productDao.findById(productId).get();
		entity=product;
		
		/*List<Product> l=new ArrayList();
		l.add(entity);
		company.setP(l);*/
		Company company=(Company)this.companyDao.findById(companyId).get();
		List<Product> p=company.getP();
		for(int i=0;i<p.size();i++) {
			Product x=p.get(i);
			if(x.getpId()==productId) {
				x.setpDescription(product.getpDescription());
				x.setpName(product.getpName());
				x.setpPrice(product.getPrice());
				x.setpStock(product.getpStock());
				
				break;
				
			}
		}
		this.companyDao.save(company);
		
		return product;
	}

	@Override
	public void deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		Product entity=(Product)productDao.findById(productId).get();
		productDao.delete(entity);
		
	}

	@Override
	public List<Product> findByCompany(Integer companyId) {
		//Optional<Company> c=companyDao.findById(companyId);
		Company company=companyDao.findById(companyId).get();
		
		return company.getP();
		
	}


}
