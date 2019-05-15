package Kareems.servlet;

/**
 * Class encapsulating a single item on the menu
 */

public class MenuItem {

	public static int ID =0; // ID incremented automatically to ensure unique ID
	private double price;
	private  int id;
	private String name;
	
	public MenuItem(String name,double price) {
		this.price = price;
		this.id = ID;
		this.name = name;
		ID++;
	}
	
	public String getName() {return name;}
	public double getPrice() {return price;}
	public int getId() {return id;}

}
