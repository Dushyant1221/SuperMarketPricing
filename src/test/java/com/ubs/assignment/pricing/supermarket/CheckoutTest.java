package com.ubs.assignment.pricing.supermarket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.assignment.pricing.supermarket.service.CheckoutService;
import com.ubs.assignment.pricing.supermarket.service.CheckoutServiceImpl;

/**
 * Unit test for simple App.
 */
public class CheckoutTest {

	private CheckoutService checkoutService;
	
	@Before
	public void initialize() {
		checkoutService = new CheckoutServiceImpl();
	}

	/**
	 * Rigourous Test :-)
	 */
	@Test
	public void checkoutServiceTest() {
		checkoutService.scanItem("A");
		checkoutService.scanItem("A");
		checkoutService.scanItem("A");
		checkoutService.scanItem("A");
		checkoutService.scanItem("A");
		checkoutService.scanItem("A");
		checkoutService.scanItem("B");
		checkoutService.scanItem("B");
		checkoutService.scanItem("B");
		checkoutService.scanItem("B");
		checkoutService.scanItem("E");
		checkoutService.scanItem("E");
		checkoutService.scanItem("E");
		checkoutService.scanItem("F");
		Assert.assertNotNull(CheckoutService.checkedOutItems);
		Assert.assertTrue(CheckoutService.checkedOutItems.size() == 4);
		Assert.assertTrue(CheckoutService.checkedOutItems.get("A")==6);
		Assert.assertTrue(checkoutService.getTotalPrice()==223);
		
	}
}
