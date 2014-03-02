package game;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Actions implements KeyListener {

	private JTextField text;
	private String input;
	private String action;
	private JLabel label;
	private JLabel health;
	private HashMap<String, Integer> keys;
	private Game gameref;

	private TextUI app;
	
	public Actions(TextUI text) throws FileNotFoundException{
		app = text;
		gameref = new Game(this);
		
		keys = new HashMap<String, Integer>();
		
		Scanner in = new Scanner(new File("ActionKeys"));
		while (in.hasNextLine()){
			String temp = in.next();
			int tempInt = in.nextInt();
			keys.put(temp, tempInt);
		}
		in.close();
		
	}
	
	public Game getGameRef() {
		return this.gameref;
	}
	
	public void addTextField(JTextField text){
		this.text = text;
		text.addKeyListener(this);
	}
	
	public void addLabel(JLabel labelRef){
		label = labelRef;
	}
	
	public void addHeaalthLabel(JLabel labelRef){
		health = labelRef;
	}
	
	/**
	 * I added this in, make sure it's in other methods.
	 * @param text
	 */
	public void setLabelText(String text) {
		String tempText = "<html>" + text + "</html>";
		label.setText(tempText);
	}
	
	public void clearTextBox() {
		text.setText("");
	}
	
	public void getAction(){
		action = "";
		for(String command : keys.keySet()){
			if (input.contains(command)){
				input = command;
				action = command;
			}
		}
		
	}
	
	public boolean isDirection(){
		if (keys.get(action) == 1){
			input = action;
			return true;
		}
		return false;
	}
	
	public boolean isClimb(){
		if (keys.get(action) == 2){
			input = action;
			return true;
		}
		return false;
	}
	
	public boolean isSearch(){
		if (keys.get(action) == 3){
			return true;
		}
		return false;
	}
	
	public boolean isItemCollection(){
		if (keys.get(action) == 4){
			return true;
		}
		return false;
	}
	
	public boolean isFight(){
		if (keys.get(action) == 5){
			return true;
		}
		return false;
	}
	
	public boolean isSpeedModifier(){
		if (keys.get(action) == 6){
			return true;
		}
		return false;
	}
	
	public boolean isInventory(){
		if (keys.get(action) == 7){
			return true;
		}
		return false;
	}
	
	public boolean isDrink(){
		if (keys.get(action) == 8){
			return true;
		}
		return false;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar() == KeyEvent.VK_ENTER){
			input = text.getText().toLowerCase();
			input.toLowerCase();
			handleInput(input);
			updateUI();
			//include deleting text in text box
		}
		
	}
	
	public void updateUI() {
		clearTextBox();
		app.updateHealth();
	}
	
	public void handleInput(String input) {
		getAction();
		
		if(input.contains("use")) { 
			
		}
		else if(keys.containsKey(action)) { 
			if(isDirection() || isClimb()) {
				gameref.move(input);
			}
			else if(isSearch()) {
				
			}
			else if(isItemCollection()) {
				
			}
			else if(isFight()) {
				
			}
			else if(isInventory()) {
				app.getPlayer().getInventory();
			}
			else if(isDrink()) {
				
			}
		}
		else {
			setLabelText("Command Not Recognized");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
