package com.jbk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Category;
import com.jbk.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = "add-Category")
	public ResponseEntity<Boolean> addCategoryt(@RequestBody @Valid Category category) {
		Boolean isAdded = categoryService.addCategoryt(category);

		if (isAdded) {
			return new ResponseEntity<Boolean>(isAdded, HttpStatus.FOUND);
		} else {

			return new ResponseEntity<Boolean>(isAdded, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "get-Category-By-Id/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long categoryid) {
		Category category = categoryService.getCategoryById(categoryid);

		if (category != null) {
			return new ResponseEntity<Category>(category, HttpStatus.FOUND);
		} else {

			return new ResponseEntity<Category>(category, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "get-All-Category")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> list = categoryService.getAllCategory();
		if (list != null) {
			return new ResponseEntity<List<Category>>(list, HttpStatus.FOUND);
		} else {

			return new ResponseEntity<List<Category>>(list, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "delete-Category-By-Id/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long categoryid) {
		Boolean isDeleted = categoryService.deleteCategory(categoryid);

		if (isDeleted != null) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "update-Category")
	public ResponseEntity<Boolean> updateCategory(@RequestBody Category category) {
		Boolean isUpdated = categoryService.updateCategory(category);
		if (isUpdated != null) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "sort-Category")
	public ResponseEntity<List<Category>> sortCategory(@RequestParam String sortBy, String fieldName) {
		List<Category> list = categoryService.sortCategory(sortBy, fieldName);

		if (!list.isEmpty()) {
			return new ResponseEntity<List<Category>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Category>>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "get-Max-Category-Gst")
	public ResponseEntity<List<Category>> getMaxCategoryGst() {
		 List<Category> list = categoryService.getMaxCategoryGst();

		if (!list.isEmpty()) {
			return new ResponseEntity<List<Category>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Category>> (HttpStatus.NO_CONTENT);
		}
	}

}
