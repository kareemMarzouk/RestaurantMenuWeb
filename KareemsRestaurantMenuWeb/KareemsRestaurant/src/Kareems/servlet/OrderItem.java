package Kareems.servlet;

/**
 * Encapsulates behaviour of a single order item on an Order,
 * primary difference between MenuItem is that it also contains details on quantity.
 */

public class OrderItem {

	private double total,unit;
	private String name;
	private int quantity;
	private MenuItem item;
	private int id;
	
	public OrderItem(MenuItem item,int quantity) {
		this.quantity = quantity;
		this.item = item;
		this.id = item.getId();
		this.name = item.getName();
		total = quantity*item.getPrice();
		unit = item.getPrice();
	}
	
	public int getQuantity() {return quantity;}
	public MenuItem getItem() {return item;}
	public String getName() {return name;}
	public int getId() {return id;}
	public double getTotal() {return total;}
	public double getUnit() {return unit;}
	
}
