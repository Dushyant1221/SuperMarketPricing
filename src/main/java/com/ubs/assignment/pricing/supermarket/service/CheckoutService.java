package com.ubs.assignment.pricing.supermarket.service;

import java.util.Map;

import com.ubs.assignment.pricing.supermarket.dto.CheckedoutItemsByType;
import com.ubs.assignment.pricing.supermarket.util.CommonUtil;


public interface CheckoutService {
	
	Map<String, Map<Integer, Integer>> availableStoreItems = CommonUtil.loadAvailableItems();

	/**
	 * Method to scan and add the item in checked out items data structure.
	 * @param name
	 */
	void scanAndAddItem(String name);
	
	/**
	 * 
	 * Method to scan and remove the item from checked out items data structure.
	 * @param name
	 */
	void scanAndRemoveItem(String name);
	
	/**
	 * Calculate total price of all checked out items
	 * @return
	 */
	int getTotalPrice();
	
	/**
	 * Structure to collect all checked out items
	 * @return
	 */
	Map<String, CheckedoutItemsByType> getCheckedOutItems();
}
 