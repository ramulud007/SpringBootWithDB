package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Supplier {

@Id
@Column(unique=true,nullable=false)
private Long supplierId;

@Column(nullable=false)
@NotEmpty
private String supplierName;

@Column(nullable=false)
private String supplierCity;

@Column(nullable=false)
@Min(6)
private Integer supplierPostalCode;

@Column(nullable=false)
@NotEmpty
private String supplierCountry;

@Column(unique=true,nullable=false)

@Min(10)
private Long supplierMobileNo;

public Supplier() {
	// TODO Auto-generated constructor stub
}

public Supplier(Long supplierId, String supplierName, String supplierCity, Integer supplierPostalCode,
		String supplierCountry, Long supplierMobileNo) {
	super();
	this.supplierId = supplierId;
	this.supplierName = supplierName;
	this.supplierCity = supplierCity;
	this.supplierPostalCode = supplierPostalCode;
	this.supplierCountry = supplierCountry;
	this.supplierMobileNo = supplierMobileNo;
}

public Long getSupplierId() {
	return supplierId;
}

public void setSupplierId(Long supplierId) {
	this.supplierId = supplierId;
}

public String getSupplierName() {
	return supplierName;
}

public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}

public String getSupplierCity() {
	return supplierCity;
}

public void setSupplierCity(String supplierCity) {
	this.supplierCity = supplierCity;
}

public Integer getSupplierPostalCode() {
	return supplierPostalCode;
}

public void setSupplierPostalCode(Integer supplierPostalCode) {
	this.supplierPostalCode = supplierPostalCode;
}

public String getSupplierCountry() {
	return supplierCountry;
}

public void setSupplierCountry(String supplierCountry) {
	this.supplierCountry = supplierCountry;
}

public Long getSupplierMobileNo() {
	return supplierMobileNo;
}

public void setSupplierMobileNo(Long supplierMobileNo) {
	this.supplierMobileNo = supplierMobileNo;
}


@Override
public String toString() {
	return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierCity=" + supplierCity
			+ ", supplierPostalCode=" + supplierPostalCode + ", supplierCountry=" + supplierCountry
			+ ", supplierMobileNo=" + supplierMobileNo + "]";
}


	
}
