package com.sample.model;

public class BillModel {

	private Double billNum;
	private Integer amount;
	private String name;

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public double getBillNum() {
		return billNum;
	}
	public void setBillNum(double billNum) {
		this.billNum = billNum;
	}
	public BillModel add(BillModel bm) {
		// TODO Auto-generated method stub
		return bm;
		
	}

}