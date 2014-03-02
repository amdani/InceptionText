package game;
import java.util.*;
/**
 * Creates object to keep track of players information
 * 
 * @author Alexis Dani
 * 
 */
public class Player {
	private String name;
	private HashMap<String, Integer> inventory;
	private int health;
	private Actions actions;

	/**
	 * Constructor for the player class
	 * 
	 * @param name - character name
	 */
	public Player(Actions act) {
		inventory = new HashMap<String, Integer>();
		inventory.put("ID(DHH)", 1);
		health = 10;
		actions = act;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void getInventory() {
		String invent = "<html>";
		for(String key: inventory.keySet()) {
			invent += key + "<br>";
		}
		invent += "</html>";


	}

	public void addInventory(String item, int quantity) {
		if(inventory.containsKey(item)) {
			quantity += inventory.get(item);
			inventory.put(item, quantity);
		}
		else {
			inventory.put(item, quantity);
		}
	}

	public int getHealth() {
		return this.health;
	}

	public void changeHealth(int mod) {
		this.health += mod;
	}
}
