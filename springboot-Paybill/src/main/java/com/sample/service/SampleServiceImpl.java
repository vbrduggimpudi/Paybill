package com.sample.service;

import com.sample.model.BillModel;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{

	public BillModel generateBill() {
		// TODO Auto-generated method stub
		BillModel bm = new BillModel();
		bm.setAmount(1000);
		bm.setBillNum(Math.random());
		bm.setName(bm.getName());
		return bm;
	}

	public String billPaid(BillModel bm) {
		// TODO Auto-generated method stub
		String status = (bm.getAmount()>0) ? "success" : "fail";
		return status;
	}
	
	public BillModel getBill(BillModel bm) {
		// TODO Auto-generated method stub
		String status = (bm.getAmount()>0) ? "success" : "fail";
		return bm;
	}

	@Override
	public BillModel addBill(BillModel bm) {
		return bm.add(bm);
		
		
	}

}