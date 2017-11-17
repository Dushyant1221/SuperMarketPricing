package com.ubs.assignment.pricing.supermarket.dto;

import java.util.Map;

public class Item {
	private String name;
	private int price;
	private Map<Integer, Integer> discountedPrice;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Map<Integer, Integer> getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Map<Integer, Integer> discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
