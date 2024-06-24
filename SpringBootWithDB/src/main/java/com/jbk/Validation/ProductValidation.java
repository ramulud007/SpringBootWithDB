package com.jbk.Validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbk.entity.Category;
import com.jbk.entity.Product;
import com.jbk.entity.Supplier;
import com.jbk.service.CategoryService;
import com.jbk.service.SupplierService;

@Component
public class ProductValidation {

	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	private CategoryService categoryService;
	
	Supplier supplier=null;
	Category category=null;
	
	public Map<String, String> ValidateProduct(Product product){
		
		Map<String, String> errorMap=new HashMap<String, String>();
		
		if(product.getProductId()<0) {
			errorMap.put("Product  Id", "Invalid Product Id");
		}
		
		if(product.getProductName()==null || product.getProductName().equals("")) {
			errorMap.put("Product Name", "Product Not valid..");
		}
		
		if(product.getProductPrice()<0) {
			errorMap.put("Product  Price", "Invalid Product Price");
		}
		
		if(product.getProductQTY()<0) {
			errorMap.put("Product  QTY", "Invalid Product Quantity");
		}
		
		
		
		supplier = supplierService.getSupplierById(product.getSupplierId().getSupplierId());
		
		if(supplier==null){
			errorMap.put("Supplier", "Please Enter Valid Supplier Id");
		}
		
		
		category = categoryService.getCategoryById(product.getCategoryId().getCategoryId());
		
		if(category==null) {
			errorMap.put("Category id", "Please Enter valid Catagory id ");
		}
		
		
		return null;
	}
	
	
	
	
	
}
