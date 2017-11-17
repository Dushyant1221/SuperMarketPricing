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
    	service.scanItem("A");
    	service.scanItem("A");
    	service.scanItem("A");
    	service.scanItem("A");
    	service.scanItem("A");
    	service.scanItem("A");
    	service.scanItem("B");
    	service.scanItem("B");
    	service.scanItem("B");
    	service.scanItem("B");
    	service.scanItem("E");
    	service.scanItem("E");
    	service.scanItem("E");
    	service.scanItem("F");
        System.out.println(service.getTotalPrice());
    }
}
