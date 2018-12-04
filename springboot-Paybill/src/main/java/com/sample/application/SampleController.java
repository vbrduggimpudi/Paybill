package com.sample.application;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


import com.sample.model.BillModel;
import com.sample.service.SampleService;

@RestController
@RequestMapping("/api")
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/generateBill", method=RequestMethod.GET)
	public BillModel generateBill(){
		return sampleService.generateBill();
	}

	@RequestMapping(value="/getBill", method=RequestMethod.GET)
	public BillModel getBill(@RequestParam(name="billNum", required=true) String billNum,@RequestParam(name="amount", required=true) String amount,String name){
		BillModel bm = new BillModel();
		bm.setAmount(Integer.parseInt(amount));
		bm.setBillNum(Integer.parseInt(billNum));
		bm.setName(name);
		return sampleService.getBill(bm);
		
	}
	
	@RequestMapping(value="/billStatus", method=RequestMethod.GET)
	public String billPaid(@RequestParam(name="billNum", required=true) String billNum,@RequestParam(name="amount", required=true) String amount,String name){
		BillModel bm = new BillModel();
		bm.setAmount(Integer.parseInt(amount));
		bm.setBillNum(Integer.parseInt(billNum));
		bm.setName(name);
		return sampleService.billPaid(bm);
	}
	
	@RequestMapping(value="/PostBill", method=RequestMethod.POST)
	public void addbill(@RequestBody BillModel bm){
		sampleService.addBill(bm);
	}
	
}