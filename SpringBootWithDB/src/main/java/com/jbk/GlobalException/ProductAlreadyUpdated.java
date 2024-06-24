package com.jbk.GlobalException;

public class ProductAlreadyUpdated extends RuntimeException {

	public ProductAlreadyUpdated(String msg) {
		super(msg);
	}
}
