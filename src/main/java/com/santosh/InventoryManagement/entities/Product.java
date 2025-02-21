package com.santosh.InventoryManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name="pystem")
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	private String pName;
	private String pDescription;
	private int pStock;
	private int pPrice;
	//Mapping the column of this table
	/*
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="cId",referencedColumnName="cId",nullable=true)
	@JsonIgnoreProperties({"hibernateLazyInitializer"})*/
	@ManyToOne(fetch=FetchType.EAGER, optional=true,cascade= CascadeType.ALL)
	@JoinColumn(name="cId",referencedColumnName="cId",nullable=true)
//	@JsonIgnore
	private Company c;
	Product(){}
	
	public Product(int pId, String pName, String pDescription, int pStock, int price) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pStock = pStock;
		this.pPrice = price;
	}

	public Product(String pName, String pDescription, int pStock, int pPrice) {
		this.pName = pName;
		this.pDescription = pDescription;
		this.pStock = pStock;
		this.pPrice = pPrice;
	}

	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public int getpStock() {
		return pStock;
	}
	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	public int getPrice() {
		return pPrice;
	}
	public void setPrice(int price) {
		this.pPrice = price;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public Company getC() {
		return c;
	}

	public void setC(Company c) {
		this.c = c;
	}


	
}
