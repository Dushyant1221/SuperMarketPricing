package com.ubs.assignment.pricing.supermarket;

import com.ubs.assignment.pricing.supermarket.service.CheckoutService;
import com.ubs.assignment.pricing.supermarket.service.CheckoutServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	CheckoutService service = new CheckoutServiceImpl();
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("A");
    	service.scanAndAddItem("B");
    	service.scanAndAddItem("B");
    	service.scanAndAddItem("B");
    	service.scanAndAddItem("B");
    	service.scanAndAddItem("E");
    	service.scanAndAddItem("E");
    	service.scanAndAddItem("E");
    	service.scanAndAddItem("F");
        System.out.println(service.getTotalPrice());
    }
}
