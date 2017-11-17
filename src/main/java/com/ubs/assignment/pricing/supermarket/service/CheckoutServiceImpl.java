package com.ubs.assignment.pricing.supermarket.service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckoutServiceImpl implements CheckoutService {

	public CheckoutServiceImpl() {
		checkedOutItems.clear();
	}

	@Override
	public void scanItem(String itemName) {
		if (availableStoreItems.containsKey(itemName)) {
			checkedOutItems.computeIfAbsent(itemName, (name) -> 0);
			checkedOutItems.compute(itemName, (name, count) -> count + 1);
		} else {
			Logger.getLogger("scanItem").log(Level.WARNING, itemName + " not found in store, will not be added in to the bill");
		}
	}

	@Override
	public int getTotalPrice() {
		AtomicInteger totalPrice = new AtomicInteger();
		checkedOutItems
				.entrySet()
				.stream()
				.forEach(
						s -> totalPrice.set(totalPrice.get()
								+ getComputedPrice(s.getKey(), new AtomicInteger(s.getValue()))));
		return totalPrice.get();
	}

	private int getComputedPrice(String itemName, AtomicInteger count) {

		AtomicInteger computedPrice = new AtomicInteger();
		Map<Integer, Integer> itemPrices = availableStoreItems.get(itemName);
		itemPrices.forEach((k, v) -> {
			if (count.get() != 0 && k <= count.get()) {
				computedPrice.set(computedPrice.get() + (v * (count.get() / k)));
				count.set(count.get() % k);
			}
		});
		return computedPrice.get();

	}
}
