package com.jbk.service;

import java.util.List;


import com.jbk.entity.Supplier;

public interface SupplierService {

	public Boolean addSupplier(Supplier supplier);
	public Supplier getSupplierById(Long supplierId);
	public List<Supplier> getAllSupplier();
	public Boolean deleteSupplierById(Long supplierId);
	public Boolean updateSupplier(Supplier supplier);
	public List<Supplier> sortSupplier(String sortBy,String fieldName);
	public List<Supplier> getMaxPriceSupplier();
	public Double countSumOfSupplierPrice();
	public Long getTotalCountOfSupplier();
	public Supplier getSupplieryByName(String getSupplierByName);
	public Boolean deleteSupplierByName(Supplier SuppliertName);
}
