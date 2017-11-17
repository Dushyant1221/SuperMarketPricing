# Supermarket items checkout assignment

#Requirements:

·         Design and implement supermarket checkout component with readable API that calculates the total price of a number of items.

·         Checkout mechanism can scan items and return actual price (is stateful)

·         Our goods are priced individually. In addition, some items are multi-priced: "buy n of them, and they’ll cost you y cents"
 
# Solution Approach

Available stock  Items are read from the json file for this assignment. A utility class method loadAvailableItems in
CommonUtil is responsible for the same. But for dynamic pricing we can load it through JMS. We can load price from 
kafka topic using Flink streaming API where it is stored by any external item cost maintaining source.

There is an Item class which contains all information like name, price and discounted price within it for each item.

Thers is CheckedoutItemsByType class which contains all the information of all checkedout items of particular type.

Checkout service is responsible for scanning items and computing price for all checked out items. Method scanAndAddItem adds the item in checkedoutout items whereas method scanAndRemoveItem removes the added item from the checkedoutout items object. getTotalPrice method calculates the sum of all checked out items.

Test method checkoutServiceTest within CheckoutTest class is responsible for testing of item scan and price calculation 

