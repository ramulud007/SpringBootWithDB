package com.jbk.model;

public class Charges {

	private Double gst;
	private Double gstAmount;
	private Double deliveryCharge;
	
	public Charges() {
		// TODO Auto-generated constructor stub
	}

	public Charges(Double gst, Double gstAmount, Double deliveryCharge) {
		super();
		this.gst = gst;
		this.gstAmount = gstAmount;
		this.deliveryCharge = deliveryCharge;
	}

	public Double getGst() {
		return gst;
	}

	public void setGst(Double gst) {
		this.gst = gst;
	}

	public Double getGstAmount() {
		return gstAmount;
	}

	public void setGstAmount(Double gstAmount) {
		this.gstAmount = gstAmount;
	}

	public Double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	@Override
	public String toString() {
		return "Charges [gst=" + gst + ", gstAmount=" + gstAmount + ", deliveryCharge=" + deliveryCharge + "]";
	}
	
	
}
