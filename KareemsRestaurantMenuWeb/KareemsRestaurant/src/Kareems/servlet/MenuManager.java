package Kareems.servlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to store and manage all items on the menu, implemented as a singleton
 * to prevent multiple instances being instantiated. 
 */

public class MenuManager {
	
	public static int orderNumber = 12000;
	private static MenuManager single_instance = null; 
	private List<MenuItem> menu;
	
	private MenuManager() {
		menu = new ArrayList();
		menu.add(new MenuItem("Egg Roll",1.20));
		menu.add(new MenuItem("WonTon Noodle Soup",5.00));
		menu.add(new MenuItem("Egg Drop Soup",3.00));
		menu.add(new MenuItem("Shrimp With Snow Pea",10.50));
		menu.add(new MenuItem("Boiled Rice",1.50));
		menu.add(new MenuItem("Vegtable Fried Rice",3.00));
		menu.add(new MenuItem("Shrimp with snow Pea",10.50));
		menu.add(new MenuItem("Beef with Brocoli",8.50));
		menu.add(new MenuItem("Beef Ginger",7.50));
		menu.add(new MenuItem("Sweet&Sour Chicken Balls",8.70));
		menu.add(new MenuItem("Roast Duck",16.20));
		menu.add(new MenuItem("Moo Goo Stir Fry",7.50));
		menu.add(new MenuItem("Crab & Sweetcorn Soup",3.50));
		menu.add(new MenuItem("Chop Suey",12.50));
	}
	
	public static MenuManager getInstance() {
		if(single_instance==null) {
			single_instance = new MenuManager();
		}
		return single_instance;
	}
	
	public List<MenuItem> getMenu(){
		return menu;
	}
	
	public void incrementOrderNo() {
		orderNumber++;
	}
	
	
	
}
