package com.sample.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.sample.model.BillModel;
import com.sample.service.SampleService;
import com.sample.service.SampleServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
extends TestCase
{
	SampleServiceImpl service = new SampleServiceImpl();
	double billNumber = 2121212;
	int billAmount = 100;
/**
 * Create the test case
 *
 * @param testName name of the test case
 */
public AppTest( String testName )
{
    super( testName );
}

/**
 * @return the suite of tests being tested
 */
public static Test suite()
{
    return new TestSuite( AppTest.class );
}

/**
 * Rigourous Test :-)
 */
public void testApp()
{
    assertTrue( true );
}

public void testBillPaidFail() throws Exception{
	BillModel bm = new BillModel();
	bm.setBillNum(billNumber);
	try{
		service.billPaid(bm);
	}catch(Exception e) {
		assertNull("bill amount cannot be null", bm.getAmount());
	}
}
public void testBillPaidFailByNumber() throws Exception{
	BillModel bm = new BillModel();
	bm.setAmount(billAmount);
	try{
		service.billPaid(bm);
	}catch(Exception e) {
		assertNull("bill amount cannot be null", bm.getBillNum());
	}
}

public void testBillPaidSuccess() {
	BillModel bm = new BillModel();
	bm.setAmount(billAmount);
	bm.setBillNum(billNumber);
	try{
		String status = service.billPaid(bm);
		assertTrue("status returned", status.equalsIgnoreCase("success"));
	}catch(Exception e) {
		e.printStackTrace();
	}
}

}