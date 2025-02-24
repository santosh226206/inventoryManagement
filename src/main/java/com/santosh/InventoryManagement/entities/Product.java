package com.santosh.InventoryManagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;

	private String pName;
	private String pDescription;
	private int pStock;
	private int pPrice;

	@ManyToOne
	@JoinColumn(name = "cId", nullable = false)
	@JsonIgnore  // Prevent infinite recursion in JSON response
	private Company c;

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
