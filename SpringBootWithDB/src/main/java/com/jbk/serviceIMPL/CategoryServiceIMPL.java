package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.CategoryDao;
import com.jbk.entity.Category;

import com.jbk.service.CategoryService;

@Service
public class CategoryServiceIMPL implements CategoryService {

	@Autowired
	private CategoryDao categorydao;

	@Override
	public Boolean addCategoryt(Category category) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		category.setCategoryId(Long.parseLong(id));
		Boolean isAdded = categorydao.addCategoryt(category);
		return isAdded;
	}

	@Override
	public Category getCategoryById(Long categoryid) {
		return categorydao.getCategoryById(categoryid);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> list = categorydao.getAllCategory();
		return list;
	}

	@Override
	public Boolean deleteCategory(Long categoryid) {
		return categorydao.deleteCategoryById(categoryid);
	}

	@Override
	public Boolean updateCategory(Category category) {
		return categorydao.updateCategory(category);
	}

	@Override
	public List<Category> sortCategory(String sortBy, String fieldName) {
		return categorydao.sortCategory(sortBy, fieldName);

	}

	@Override
	public List<Category> getMaxCategoryGst() {
		return categorydao.getMaxCategoryGst();

	}

	@Override
	public Double countSumOfCategoryPrice() {
		return categorydao.countSumOfCategoryPrice();

	}

	@Override
	public Long getTotalCountOfCategory() {

		return categorydao.getTotalCountOfCategory();
	}

	@Override
	public Category getCategoryByName(String getCategoryByName) {

		return categorydao.getCategoryByName(getCategoryByName);
	}

	@Override
	public Boolean deleteCategoryByName(Category CategorytName) {

		return categorydao.deleteCategoryByName(CategorytName);
	}

}
