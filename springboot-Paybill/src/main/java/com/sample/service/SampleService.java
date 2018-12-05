package com.sample.service;

import com.sample.model.BillModel;

public interface SampleService {

	
	public BillModel generateBill(BillModel bm) throws Exception;
	public String billPaid(BillModel bm);
	public BillModel getBill();
	 
}
