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
import org.springframework.web.multipart.MultipartFile;
import com.jbk.GlobalException.ProductAddedSuccessfully;
import com.jbk.GlobalException.ProductAlreadyExistsException;
import com.jbk.GlobalException.ProductAlreadyUpdated;
import com.jbk.GlobalException.ProductNotExistsException;
import com.jbk.GlobalException.ProductUpdateDoneSuccessfully;
import com.jbk.GlobalException.TotalCountOfProducts;
import com.jbk.entity.Product;
import com.jbk.model.FinalProductPrice;
import com.jbk.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductRestController {

	@Autowired
	private ProductService service;

	@PostMapping(value = "/add-Product")
	public ResponseEntity<Object> addProduct(@RequestBody @Valid Product product) {
		Boolean isAdded = service.addProduct(product);
		if (isAdded) {
			throw new ProductAddedSuccessfully("Product Added Successfully..");
		} else {
			throw new ProductAlreadyExistsException(
					"Product Already Exists with This Name: " + product.getProductName());

		}

	}

	@GetMapping(value = "/get-All-Products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = service.getAllProducts();
		if (!productList.isEmpty()) {
			return new ResponseEntity<List<Product>>(productList, HttpStatus.FOUND);
		} else {
			throw new ProductAlreadyExistsException("Product Already Exists:");

		}

	}

	@PutMapping(value = "/update-Product")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		Boolean isUpdated = service.updateProduct(product);
		if (isUpdated) {
			throw new ProductUpdateDoneSuccessfully("Product Updated Successfully..");
		} else {
			throw new ProductAlreadyExistsException("Product Already Updated same details");

		}

	}

	@DeleteMapping(value = "/delete-Product/{id}")
	public ResponseEntity<Boolean> deleteProductById(@PathVariable("id") Long productId) {
		Boolean isDeleted = service.deleteProductById(productId);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			throw new ProductNotExistsException("Product not found..");
		}

	}

	@GetMapping(value = "/get-Product-By-Id/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long productId) {

		Product product = service.getProductById(productId);

		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} else {
			throw new ProductAlreadyUpdated("Product Not Exists with this Id: " + productId);
		}
	}

	@GetMapping(value = "/sortBy-fieldName")
	public ResponseEntity<List<Product>> sortProducts(@RequestParam String sortBy, String fieldName) {
		List<Product> listOfProducts = service.sortProducts(sortBy, fieldName);

		if (listOfProducts != null) {
			return new ResponseEntity<List<Product>>(listOfProducts, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(listOfProducts, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/get-Product-maxPrice")
	public ResponseEntity<List<Product>> getMaxPriceProducts() {
		List<Product> maxPrice = service.getMaxPriceProducts();
		if (maxPrice != null) {
			return new ResponseEntity<List<Product>>(maxPrice, HttpStatus.FOUND);
		} else {
			throw new ProductNotExistsException("Product Not Exists...");
		}
	}

	@GetMapping(value="/count-SumOf-ProductPrice")
	public ResponseEntity<Double> countSumOfProductPrice() {

		Double countSumOfProductPrice = service.countSumOfProductPrice();

		if (countSumOfProductPrice != null) {
			return new ResponseEntity<Double>(countSumOfProductPrice, HttpStatus.FOUND);
		} else {
			throw new ProductNotExistsException("Product Not Exists...");
		}
	}

	@GetMapping(value = "/get-TotalCount-Of-Products")
	public ResponseEntity<Long> getTotalCountOfProducts() {
		Long TotalCountOfProducts = service.getTotalCountOfProducts();

		if (TotalCountOfProducts != null) {
			throw new TotalCountOfProducts("Total Count Of Products is: "+TotalCountOfProducts);
		} else {
			throw new TotalCountOfProducts("Total Count Of Products is:0");
		}
	}

	@GetMapping(value = "/get-productBy-Name/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String producName) {
		Product getProductByName = service.getProductByName(producName);

		if (getProductByName != null) {
			return new ResponseEntity<Product>(getProductByName, HttpStatus.FOUND);
		} else {
			throw new ProductNotExistsException("Product Not Exists...");
		}
	}

	//Need to Check.
	@DeleteMapping(value="/delete-ProductBy-Name/{name}")
	public ResponseEntity<Boolean> deleteProductByName(@PathVariable("name") Product productName) {
		Boolean deleteProductByName=service.deleteProductByName(productName);

		if (deleteProductByName != null) {
			return new ResponseEntity<Boolean>(deleteProductByName, HttpStatus.FOUND);
		} else{
			return new ResponseEntity<Boolean>(deleteProductByName, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "upload-File")
	public ResponseEntity<String> uploadFile(@RequestBody MultipartFile file) {
		String msg = service.uploadFile(file);
		return ResponseEntity.ok(msg);
	}

	@GetMapping(value = "/getFinal-ProductPrice-ById/{id}")
	public ResponseEntity<FinalProductPrice> getFinalProductPriceById(@PathVariable("id") Long productId) {
		FinalProductPrice finalProductPrice = service.getFinalProductPriceById(productId);

		if (finalProductPrice != null) {
			return new ResponseEntity<FinalProductPrice>(finalProductPrice, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<FinalProductPrice>(finalProductPrice, HttpStatus.NOT_FOUND);
		}
	}

}
