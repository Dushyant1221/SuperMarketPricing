package com.ubs.assignment.pricing.supermarket.service;

import java.util.HashMap;
import java.util.Map;

import com.ubs.assignment.pricing.supermarket.util.CommonUtil;


public interface CheckoutService {
	Map<String, Map<Integer, Integer>> availableStoreItems = CommonUtil.loadAvailableItems();
	Map<String, Integer> checkedOutItems = new HashMap<>();
	
	void scanItem(String name);
	
	int getTotalPrice();
}
