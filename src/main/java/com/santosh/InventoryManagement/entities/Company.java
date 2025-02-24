package com.santosh.InventoryManagement.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name="cmpystem")
@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String cName;
	private int cCapacity;
	private String cLocation;
	private String cEmailid;
	private String cPassword;
	private String cTemp;

	//Mapping to another table
	 /*@OneToMany(cascade=CascadeType.PERSIST,fetch = FetchType.LAZY, orphanRemoval = true,targetEntity=Product.class)
	 */
	
	@OneToMany(mappedBy="c" ,fetch =FetchType.EAGER,cascade=CascadeType.ALL)
	@JsonProperty("p")
	@OrderBy("pStock")
	private List<Product> p;
	public Company() {
		super();
		System.out.println("company-created");
	
	}

	public Company(int cId, String cName, int cCapacity, String cLocation, String cEmailid, String cPassword) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cCapacity = cCapacity;
		this.cLocation = cLocation;
		this.cEmailid = cEmailid;
		this.cPassword = cPassword;
	}

	public Company(int cId, String cName, int cCapacity, String cLocation, String cEmailid, String cPassword, String cTemp, List<Product> p) {
		this.cId = cId;
		this.cName = cName;
		this.cCapacity = cCapacity;
		this.cLocation = cLocation;
		this.cEmailid = cEmailid;
		this.cPassword = cPassword;
		this.cTemp = cTemp;
		this.p = p;
	}

	public List<Product> getP() {
		return p;
	}

	public void setP(List<Product> p) {
		this.p = p;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcCapacity() {
		return cCapacity;
	}

	public void setcCapacity(int cCapacity) {
		this.cCapacity = cCapacity;
	}

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getcEmailid() {
		return cEmailid;
	}

	public void setcEmailid(String cEmailid) {
		this.cEmailid = cEmailid;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	@Override
	public String toString() {
		return "Company [cId=" + cId + ", cName=" + cName + ", cCapacity=" + cCapacity + ", cLocation=" + cLocation
				+ ", cEmailid=" + cEmailid + ", cPassword=" + cPassword + "]";
	}


	
	
	}
