package com.sample.service;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sample.model.BillModel;
import com.sample.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{
	//lgger statement
	private static final Log LOGGER = LogFactory.getLog(SampleServiceImpl.class);
	
	@Autowired
	private SampleUtil sampleUtil;


	@Override
	public BillModel getBill() {
		LOGGER.info("get bill method initiated");
		return sampleUtil.getSampleBillData();
		
	}
	
	@Override
	public BillModel generateBill(BillModel bm) throws Exception {
		LOGGER.info("generate bill method initiated");
		Double total = 0.0;
		Integer id = sampleUtil.sequenceGenerator().nextInt();
        if(bm.getCustomerName() != null && !bm.getCustomerName().isEmpty() 
        		&& bm.getMobile() != null && !bm.getMobile().toString().isEmpty() 
        		&& bm.getProductList() != null && bm.getProductList().size() !=0) {
        	//set the invoice id
        	bm.setInvoice(id.toString());
        	LOGGER.info("Bill will be generated with invoice number "+bm.getInvoice().replaceAll("[0-9]", "x"));
        	for(Product prd : bm.getProductList()) {
        		total = total+prd.getPrice();
        	}
        	bm.setPrice(total);
        	bm.setDate(new Date());
        	LOGGER.info("generate bill method completed fr customer : "+bm.getCustomerName()+" and mobile number :"+bm.getMobile().toString().replaceAll("[0-9]", "x"));
        	return bm;
        }else {
        	LOGGER.error("The bill details must contain customer Name, Mobile and list of products purchased");
        	throw new Exception("The bill details must contain customer Name, Mobile and list of products purchased");
        }
		
	}

	@Override
	public String billPaid(BillModel bm) {
		// TODO Auto-generated method stub
		String status = "Bill Payment failed";
		if(bm.getCustomerName() != null && !bm.getCustomerName().isEmpty() && 
				bm.getMobile() != null && !bm.getMobile().toString().isEmpty() 
				&& bm.getPrice() != null && !bm.getPrice().toString().isEmpty() 
				&& bm.getInvoice() != null && !bm.getInvoice().toString().isEmpty()) {
			status = "Bill Payment successfull";
		}
		LOGGER.info(status);
		return status;
	}

}