package com.sample.service;

import com.sample.model.BillModel;

public interface SampleService<Bill> {

	public BillModel generateBill();
	public String billPaid(BillModel bm);
	public BillModel getBill(BillModel bm);
	public BillModel addBill(BillModel bm);
	 
}
