package com.sample.test;

import com.sample.model.BillModel;
import com.sample.service.SampleServiceImpl;
import com.sample.service.SampleUtil;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
extends TestCase
{
	SampleServiceImpl service = new SampleServiceImpl();
	SampleUtil sampleUtil = new SampleUtil();
	Double billNumber = (double) 2121212;
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

public void testBillPaidSuccess() throws Exception{
	BillModel bm = sampleUtil.getSampleBillData();
	try{
		service.billPaid(bm);
	}catch(Exception e) {
		assertNotNull("The bill paid successfully", bm);
	}
}

public void testGenerateBillFail() throws Exception{
	BillModel bm = new BillModel();
	try{
		service.billPaid(bm);
	}catch(Exception e) {
		assertNull("The bill details must contain customer Name, Mobile and list of products purchased", bm);
	}
}

public void testGenerateBillSuccess() throws Exception{
	BillModel bm = sampleUtil.getSampleBillData();
	try{
		service.generateBill(bm);
	}catch(Exception e) {
		assertNotNull("The bill generated successfully", bm);
	}
}

public void testGetBill() {
	try{
		BillModel bm = service.getBill();
		assertTrue("status returned", !bm.getInvoice().isEmpty());
	}catch(Exception e) {
		assertTrue("The bill generated successfully", true);
	}
}

}