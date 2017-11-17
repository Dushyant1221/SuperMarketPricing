package com.ubs.assignment.pricing.supermarket.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




import com.ubs.assignment.pricing.supermarket.dto.Item;

public class CommonUtil {

	private static ObjectMapper MAPPER = new ObjectMapper();

	private CommonUtil() {
		
	}
	public static Map<String, Map<Integer, Integer>> loadAvailableItems() {
		List<Item> items = new ArrayList<Item>();
		Map<String, Map<Integer, Integer>> storeItemMap = new HashMap<String, Map<Integer,Integer>>();
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader("Items.json"));
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject obj = (JSONObject) jsonArray.get(i);
				items.add(MAPPER.readValue(obj.toString(), Item.class));
			}
			items.stream().forEach(item -> {
				Map<Integer, Integer> discountedPrice = new TreeMap<>(Collections.reverseOrder());
				discountedPrice.put(1, item.getPrice());
				if (item.getDiscountedPrice() !=null) {
					discountedPrice.putAll(item.getDiscountedPrice());
				}
				storeItemMap.put(item.getName(), discountedPrice);
			});
		} catch (IOException | ParseException e) {
			Logger.getLogger("loadAvailableItems").log(Level.WARNING, e.getMessage());
		}
		return storeItemMap;
	}
}
