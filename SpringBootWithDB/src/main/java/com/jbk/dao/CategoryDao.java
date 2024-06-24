package com.jbk.dao;

import java.util.List;
import com.jbk.entity.Category;

public interface CategoryDao {


	public Boolean addCategoryt(Category category);
	public Category getCategoryById(Long CategoryId);
	public List<Category> getAllCategory();
	public Boolean deleteCategoryById(Long CategoryId);
	public Boolean updateCategory(Category category);
	public List<Category> sortCategory(String sortBy,String fieldName);
	public List<Category> getMaxCategoryGst();
	public Double countSumOfCategoryPrice();
	public Long getTotalCountOfCategory();
	public Category getCategoryByName(String getCategoryByName);
	public Boolean deleteCategoryByName(Category CategorytName);


}
