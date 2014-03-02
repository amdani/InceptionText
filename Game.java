package game;
import java.util.*;
import java.io.*;
/**
 * This class controls the game mechanics
 * 
 * @author Steve Amatangelo
 * @author Alexis Dani
 * @author Trever Overbeck
 * @author Zach Hill
 *
 */
public class Game {
	private String currentLocation;
	private HashMap<String, ArrayList<String>> map;
	private HashMap<String, String> description;

	private HashMap<String, String> itemDescriptions;
	private Actions actions;

	public Game(Actions act) throws FileNotFoundException{
		currentLocation = "eercLobby";
		actions = act;
		//implement hashmaps here
		implementMap();
		implementDescription();
		implementItemDescriptions();
	}

	public Actions getActions(){
		return this.actions;
	}

	public void implementMap() throws FileNotFoundException {
		map = new HashMap<String, ArrayList<String>>();
		Scanner in = new Scanner(new File("Rooms"));

		while(in.hasNextLine()) {
			String key = in.next();
			int numElements = in.nextInt() + 6;
			ArrayList<String> info = new ArrayList<String>();
			for(int i = 0; i < numElements; i++) {
				info.add(in.next());
			}

			map.put(key,  info);
		}
		in.close();
	}

	public void implementDescription() throws FileNotFoundException {
		description = new HashMap<String, String>();

		Scanner in = new Scanner(new File("RoomDescriptions"));

		while(in.hasNextLine()) {
			String key = in.next();
			String value = in.nextLine();
			description.put(key, value);
		}
		in.close();
	}

	public void implementItemDescriptions() throws FileNotFoundException {
		itemDescriptions = new HashMap<String, String>();
		Scanner in = new Scanner(new File("ItemDescriptions"));

		while(in.hasNextLine()) {
			String key = in.next();
			String value = in.nextLine();

			itemDescriptions.put(key, value);
		}
		in.close();
	}

	public void setCurrentLocation(String loc) {
		currentLocation = loc;
		actions.setLabelText(description.get(loc));
	}

	public String getCurrentLocation() {
		return this.currentLocation;
	}

	public String getDescription(String key) {
		return description.get(key);
	}

	public void move(String dir) {
		if(canMove(dir)) {
			int arrayLocation = direction(dir);
			ArrayList<String> info = map.get(currentLocation);
			setCurrentLocation(info.get(arrayLocation));
			displayDiscription(currentLocation);
		}
		else {
			displayDiscription("null");
		}
	}

	/**
	 * Checks if the direction is a valid location
	 * 
	 * @param direction - use input for direction
	 * @return whether it is a valid location
	 */
	public boolean canMove(String dir) {
		int arrayLocation = direction(dir);
		ArrayList<String> info = map.get(currentLocation);

		//error handling
		if(arrayLocation < 0 || arrayLocation > info.size()) {
			return false;
		}

		System.out.println(currentLocation + " " + arrayLocation);
		//checks if there is something in that location value
		if(info.get(arrayLocation).equals("null")) {
			return false;
		}
		else {
			return true;
		}
	}

	public void displayDiscription(String str) {
		if(str.equals("null")) {
			actions.setLabelText("You can't go that way.");
		}
		else {
			actions.setLabelText(getDescription(str));
		}
	}

	public boolean randomEncounter(){
		double chance = Math.random();
		System.out.println(chance);
		if (chance >= .90){
			return true;
		}
		return false;
	}

	public void enemy(){
		if(randomEncounter()){
			double knightChance = Math.random();
			if (knightChance >= .75){
				actions.setLabelText((actions.getLabelText()).substring(0, (actions.getLabelText().length() - 7)) + "There is a cheese knight in here.</html>");
			}
			else {
				actions.setLabelText((actions.getLabelText()).substring(0, (actions.getLabelText().length() - 7)) + "There is a cheeseless in here.</html>");
			}
		}
	}


	public int direction(String direction) {
		direction = direction.toLowerCase();

		//set arrayLocation to corresponding value in the map String[]
		if(direction.contains("north")) {
			return 0;
		}
		else if(direction.contains("east")) {
			return 1;
		}
		else if(direction.contains("south")) {
			return 2;
		}
		else if(direction.contains("west")) {
			return 3;
		}
		else if(direction.contains("up")) {
			return 4;
		}
		else if(direction.contains("down")) {
			return 5;
		}
		else {
			return -1;
		}
	}

	/**
	 * Yall will need to do something in calling of this method so dat it sends just the name of 
	 * the item but I'm so fucking tired right now, I literally can't even think anymore. 
	 * Good Night!
	 * 
	 * @param item
	 */
	public void getItem(String item) {
		ArrayList<String> info = map.get(currentLocation);
		if(info.size() > 6 && isItemAvailable(item)) {
			actions.getApp().getPlayer().addInventory(item, 1);
			actions.setLabelText("You picked up " + item);
		}
		else {
			actions.setLabelText("Object unavailable.");
		}
	}

	public boolean isItemAvailable(String item) {
		ArrayList<String> info = map.get(currentLocation);
		for(String s: info) {
			if(item.contains(s)){
				return true;
			}
		}

		return false;
	}
}
