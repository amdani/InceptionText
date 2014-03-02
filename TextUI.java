package game;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class TextUI extends JFrame{	
	
	JLabel label;

	JLabel health;
	JTextField text;
	Actions ctrl;
	Player playa;
	
	public TextUI() throws FileNotFoundException {
		ctrl = new Actions(this);
		playa = new Player(ctrl, this);
	}
	
	
	
	public Player getPlayer() {
		return playa;
	}
	
	private void initialize() {
		
		// add layout
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// add JLabel
		JLabel response = new JLabel();
		label = response;
		response.setPreferredSize(new Dimension(800, 600));
		response.setSize(new Dimension(800, 600));
		response.setBorder(BorderFactory.createLoweredBevelBorder());
		response.setVerticalAlignment(JLabel.TOP);
		Font font = new Font("Times", Font.PLAIN, 30);
		response.setFont(font);
		response.setText("<html>" + ctrl.getGameRef().getDescription(ctrl.getGameRef().getCurrentLocation()) + "</html>");
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		pane.add(response, c);
		ctrl.addLabel(response);
		
		//add JLabel
		health = new JLabel();
		String textLbl = "HP: " + playa.getHealth();
		health.setText(textLbl);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(health, c);
		
		// add JTextField
		JTextField commandBox = new JTextField();
		text = commandBox;
		commandBox.setPreferredSize(new Dimension(300, 50));
		commandBox.setFont(font);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.5;
		pane.add(commandBox, c);
		ctrl.addTextField(commandBox);
		
	}
	
	public void updateHealth(){
		String textLbl = "HP: " + playa.getHealth();
		health.setText(textLbl);
	}
	
	public static void main(String[] args) throws FileNotFoundException {

		TextUI app = new TextUI();
		app.initialize();
		app.setSize(new Dimension(1200, 900));
		app.setMinimumSize(new Dimension(850,850));
		app.setLocation(200, 100);
		app.setDefaultCloseOperation(EXIT_ON_CLOSE);
		app.pack();
		app.setVisible(true);
	}

	
}
