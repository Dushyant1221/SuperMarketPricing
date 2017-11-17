package com.ubs.assignment.pricing.supermarket.dto;

import java.util.Map;

public class CheckedoutItemsByType {

	/** total scanned and added items of particular type*/
	private int totalCount;
	/** Map contains the price of each scanned item of particular type */
	private Map<Integer, Integer> itemsMap;

	public CheckedoutItemsByType(int totalCount, Map<Integer, Integer> itemsMap) {
		this.totalCount = totalCount;
		this.itemsMap = itemsMap;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public Map<Integer, Integer> getItemsMap() {
		return itemsMap;
	}

	public void setItemsMap(Map<Integer, Integer> itemsMap) {
		this.itemsMap = itemsMap;
	}

}
