package game;
import java.util.*;
import java.io.*;
/**
 * This class controls the game mechanics
 * 
 * @author Steve Amatangello
 * @author Alexis Dani
 * @author Trever Overbeck
 * @author Zach Hill
 *
 */
public class Game {
	private String currentLocation;
	private HashMap<String, ArrayList<String>> map;
	private HashMap<String, String> description;
	private Actions actions;

	public Game(Actions act) throws FileNotFoundException {
		//implement hashmaps here
	/*	implementMap();
		implementDescription();*/
		currentLocation = "misnomer";
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
	}
	
	public void implementDescription() throws FileNotFoundException {
		description = new HashMap<String, String>();
		Scanner in = new Scanner(new File("Descriptions"));
		
		while(in.hasNextLine()) {
			String key = in.next();
			String value = in.nextLine();
		}
	}

	public void setCurrentLocation(String loc) {
		currentLocation = loc;
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
		if(arrayLocation == -1) {
			return false;
		}

		//checks if there is something in that location value
		if(info.get(arrayLocation) == null) {
			return false;
		}
		else {
			return true;
		}
	}



	public int direction(String direction) {
		direction = direction.toLowerCase();

		//set arrayLocation to corresponding value in the map String[]
		if(direction.equals("north")) {
			return 1;
		}
		else if(direction.equals("east")) {
			return 2;
		}
		else if(direction.equals("south")) {
			return 3;
		}
		else if(direction.equals("west")) {
			return 4;
		}
		else if(direction.equals("up")) {
			return 5;
		}
		else if(direction.equals("down")) {
			return 6;
		}
		else {
			return -1;
		}

	}
}
