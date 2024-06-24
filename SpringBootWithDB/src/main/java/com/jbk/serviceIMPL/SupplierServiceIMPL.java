package com.jbk.serviceIMPL;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jbk.dao.SupplierDao;
import com.jbk.entity.Supplier;
import com.jbk.service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService {

	@Autowired
	private SupplierDao dao;
	
	@Override
	public Boolean addSupplier(@RequestBody @Valid Supplier supplier) {
		String id=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		supplier.setSupplierId(Long.parseLong(id));
		
		return dao.addSupplier(supplier);
	}

	@Override
	public Supplier getSupplierById(Long supplierId) {
		
		return dao.getSupplierById(supplierId);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		
		return dao.getAllSupplier();
	}

	@Override
	public Boolean deleteSupplierById(Long supplierId) {
		
		return dao.deleteSupplierById(supplierId);
	}

	@Override
	public Boolean updateSupplier(Supplier supplier) {
	
		return dao.updateSupplier(supplier);
	}

	@Override
	public List<Supplier> sortSupplier(String sortBy, String fieldName) {
		
		return dao.sortSupplier(sortBy, fieldName);
	}

	@Override
	public List<Supplier> getMaxPriceSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double countSumOfSupplierPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getTotalCountOfSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier getSupplieryByName(String getSupplierByName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteSupplierByName(Supplier SuppliertName) {
		// TODO Auto-generated method stub
		return null;
	}

}
