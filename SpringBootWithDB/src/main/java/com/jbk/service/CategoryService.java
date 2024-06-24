package com.jbk.service;

import java.util.List;

import com.jbk.entity.Category;

public interface CategoryService {


	public Boolean addCategoryt(Category category);
	public Category getCategoryById(Long id);
	public List<Category> getAllCategory();
	public Boolean deleteCategory(Long id);
	public Boolean updateCategory(Category category);
	public List<Category> sortCategory(String sortBy,String fieldName);
	public List<Category> getMaxCategoryGst();
	public Double countSumOfCategoryPrice();
	public Long getTotalCountOfCategory();
	public Category getCategoryByName(String getCategoryByName);
	public Boolean deleteCategoryByName(Category CategorytName);



}
