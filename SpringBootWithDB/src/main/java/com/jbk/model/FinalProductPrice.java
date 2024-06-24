package com.jbk.model;

import com.jbk.entity.Category;
import com.jbk.entity.Supplier;

public class FinalProductPrice {
	
	private Long productId;
	private String productName;
	private Supplier supplierId;
	private Category categoryId;
	private Integer productQTY;
	private Double productPrice;
	private Charges charges;
	private Double discountPercentage;
	private Double discountAmount;
	private Double productFinalPrice;
	
	public FinalProductPrice() {
		
	}

	public FinalProductPrice(Long productId, String productName, Supplier supplierId, Category categoryId,
			Integer productQTY, Double productPrice, Charges charges, Double discountPercentage, Double discountAmount,
			Double productFinalPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
		this.charges = charges;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.productFinalPrice = productFinalPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Supplier getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Supplier supplierId) {
		this.supplierId = supplierId;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getProductQTY() {
		return productQTY;
	}

	public void setProductQTY(Integer productQTY) {
		this.productQTY = productQTY;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Charges getCharges() {
		return charges;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
	}

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getProductFinalPrice() {
		return productFinalPrice;
	}

	public void setProductFinalPrice(Double productFinalPrice) {
		this.productFinalPrice = productFinalPrice;
	}

	
}
