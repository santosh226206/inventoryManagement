package com.santosh.InventoryManagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;

	private String cName;
	private int cCapacity;
	private String cLocation;
	private String cEmailid;
	private String cPassword;
	private String cTemp;

	@OneToMany(mappedBy = "c", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonProperty("p")  // Ensure JSON property is mapped correctly
	private List<Product> p;

	public Company(String cName, int cCapacity, String cLocation, String cEmailid, String cPassword, String cTemp, List<Product> p) {
		this.cName = cName;
		this.cCapacity = cCapacity;
		this.cLocation = cLocation;
		this.cEmailid = cEmailid;
		this.cPassword = cPassword;
		this.cTemp = cTemp;
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

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public int getcCapacity() {
		return cCapacity;
	}

	public void setcCapacity(int cCapacity) {
		this.cCapacity = cCapacity;
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

	public String getcTemp() {
		return cTemp;
	}

	public void setcTemp(String cTemp) {
		this.cTemp = cTemp;
	}

	public List<Product> getP() {
		return p;
	}

	public void setP(List<Product> p) {
		this.p = p;
	}
}
