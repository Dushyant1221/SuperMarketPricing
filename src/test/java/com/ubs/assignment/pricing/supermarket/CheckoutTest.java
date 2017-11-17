package com.ubs.assignment.pricing.supermarket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.assignment.pricing.supermarket.service.CheckoutService;
import com.ubs.assignment.pricing.supermarket.service.CheckoutServiceImpl;

/**
 * Unit test for CheckoutTest app
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
		checkoutService.scanAndAddItem("A");
		Assert.assertTrue(checkoutService.getCheckedOutItems().get("A").getItemsMap().get(1) ==20);
		checkoutService.scanAndAddItem("A");
		Assert.assertTrue(checkoutService.getCheckedOutItems().get("A").getItemsMap().get(2) ==10);
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("B");
		checkoutService.scanAndAddItem("E");
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("A");
		checkoutService.scanAndAddItem("E");
		checkoutService.scanAndAddItem("E");
		checkoutService.scanAndAddItem("F");
		checkoutService.scanAndRemoveItem("A");
		checkoutService.scanAndRemoveItem("B");
		checkoutService.scanAndRemoveItem("F");
		Assert.assertNotNull(checkoutService.getCheckedOutItems());
		Assert.assertTrue(checkoutService.getCheckedOutItems().get("A").getTotalCount() == 7);
		Assert.assertTrue(checkoutService.getTotalPrice()==270);
	}
}
