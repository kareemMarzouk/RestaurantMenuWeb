package Kareems.servlet;

import java.util.ArrayList;

/**
 * Encapsulates behaviour of an order, comprised of multiple order items.
 */

public class Order {

	private ArrayList<OrderItem> orderItems;
	
	public Order() {
		orderItems = new ArrayList<OrderItem>();
	}
	
	public void addItemToOrder(MenuItem item, int count) {
		orderItems.add(new OrderItem(item,count));
	}
	
	public double getTotal() {
		double total = 0.0;
		for(OrderItem i : orderItems) {
			total += i.getTotal();
		}
		return total;
	}
	
	public ArrayList<OrderItem> getItems(){return orderItems;}
	
	
}
