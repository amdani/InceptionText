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
	private HashMap<String, Integer> keys;
	private Game gameref;
	
	public Actions() throws FileNotFoundException{
		
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
	
	public void addTextField(JTextField text){
		this.text = text;
		text.addKeyListener(this);
	}
	
	public void addLabel(JLabel labelRef){
		label = labelRef;
	}
	
	public void getAction(){
		
		for(String command : keys.keySet()){
			if (input.contains(command)){
				action = command;
			}
		}
		
	}
	
	public boolean isDirection(){
		if (keys.get(action) == 1){
			return true;
		}
		return false;
	}
	
	public boolean isClimb(){
		if (keys.get(action) == 2){
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
			input = text.getText();
			input.toLowerCase();
			label.setText(input);
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
