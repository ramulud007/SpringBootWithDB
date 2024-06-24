package com.jbk.dao;

import java.util.List;
import com.jbk.entity.Product;
import com.jbk.model.FinalProductPrice;

public interface ProductDao {

	public Boolean addProduct(Product product);
	public Product getProductById(Long productId);
	public List<Product> getAllProducts();
	public Boolean deleteProductById(Long productId);
	public Boolean deleteProductByName(Product productName);
	public Boolean updateProduct(Product product);
	public List<Product> sortProducts(String sortBy,String fieldName);
	public List<Product> getMaxPriceProducts();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProducts();
	public Product getProductByName(String getProductByName);
	
	public String productUploadFile(List<Product> list);
	
	public FinalProductPrice getFinalProductPriceById(Long productId);
	
	
}
