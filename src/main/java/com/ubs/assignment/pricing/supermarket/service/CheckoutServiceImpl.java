package com.ubs.assignment.pricing.supermarket.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ubs.assignment.pricing.supermarket.dto.CheckedoutItemsByType;

public class CheckoutServiceImpl implements CheckoutService {

	private Map<String, CheckedoutItemsByType> checkedOutItems = new HashMap<>();

	@Override
	public Map<String, CheckedoutItemsByType> getCheckedOutItems() {
		return checkedOutItems;
	}

	@Override
	public void scanAndAddItem(String itemName) {
		if (availableStoreItems.containsKey(itemName)) {
			checkedOutItems.computeIfAbsent(itemName, (name) -> new CheckedoutItemsByType(0, new HashMap<>()));
			CheckedoutItemsByType itemsByType = checkedOutItems.get(itemName);
			int calculatedTotalPrice = getComputedPrice(itemName, new AtomicInteger(itemsByType.getTotalCount() + 1));
			int itemPrice = calculatedTotalPrice
					- itemsByType.getItemsMap().values().stream().mapToInt(Number::intValue).sum();
			itemsByType.setTotalCount(itemsByType.getTotalCount() + 1);
			itemsByType.getItemsMap().put(itemsByType.getTotalCount(), itemPrice);
		} else {
			Logger.getLogger("scanItem").log(Level.WARNING,
					itemName + " not found in store, will not be added in to the bill");
		}
	}

	@Override
	public int getTotalPrice() {
		return checkedOutItems.values().stream()
				.mapToInt((k) -> k.getItemsMap().values().stream().mapToInt(Number::intValue).sum()).sum();
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

	@Override
	public void scanAndRemoveItem(String itemName) {
		if (checkedOutItems.containsKey(itemName)) {
			CheckedoutItemsByType itemsByType = checkedOutItems.get(itemName);
			itemsByType.getItemsMap().remove(itemsByType.getTotalCount());
			itemsByType.setTotalCount(itemsByType.getTotalCount() - 1);
		} else {
			Logger.getLogger("scanItem").log(Level.WARNING,
					itemName + " not found in already scanned items, will not be removed from the bill");
		}

	}
}
