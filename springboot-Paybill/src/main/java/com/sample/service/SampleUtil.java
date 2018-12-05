package com.sample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sample.model.BillModel;
import com.sample.model.Product;
@Service
public class SampleUtil {
	private Random random;

	// sample method to get default data
	public BillModel getSampleBillData() {
		Double total = 0.0;
		Integer id = sequenceGenerator().nextInt();
	    BillModel bm = new BillModel();
		bm.setCustomerName("TestUser");
		bm.setInvoice(id.toString());
		bm.setMobile(1234567898);
		bm.setDate(new Date());
		bm.setProductList(getSampleProdcuts());
		for(Product p:bm.getProductList()) {
			total = total+p.getPrice();
		}
		bm.setPrice(total);
	    return bm;
	}
	
    //sample method to get default data for products
	public List<Product> getSampleProdcuts() {
		List<Product> productList = new ArrayList<>();
		Product product = null;
		for(int i=0; i<2; i++) {
			Double d  = (Math.random()*1000);
			product = new Product();
			product.setProductName("product_"+i);
			product.setModelNumber("M_N_"+d/10);
			product.setPrice(100.00);
			productList.add(product);
		}
		return productList;
	}
	
	//Random sequence generator used as invoice id
	
	public Random sequenceGenerator() {
		random = new Random(); // a known constant
		return random;
	}
}
