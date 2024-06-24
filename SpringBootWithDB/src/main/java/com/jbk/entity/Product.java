package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {
	
	@Id
	@Column(unique = true, nullable = false)
	private Long productId;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String productName;

	@OneToOne
	@JoinColumn(name="supplierId")
	private Supplier supplierId;

	@OneToOne
	@JoinColumn(name="categoryId")
	private Category categoryId;

	@Column(nullable = false)
	@Min(1)
	private Integer productQTY;

	@Column(nullable = false)
	@Min(1)
	private Double productPrice;

	public Product() {
	}

	public Product(Long productId, String productName, Supplier supplierId, Category categoryId, Integer productQTY,
			Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", categoryId=" + categoryId + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}

}
