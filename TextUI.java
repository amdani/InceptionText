package game;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class TextUI extends JFrame{	
	
	JLabel label;
	JTextField text;
	Actions ctrl;
	
	public TextUI() throws FileNotFoundException {
		
		ctrl = new Actions();
		
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
		response.setText("<html>South Park<br>You enter a T-shaped hall, named South Park, which smells atrocious. Behind the closed doors you hear male voices making idiotic jokes, and decide it's best to avoide them. There is a slighty opened door and inside the room you can see 15 cans of beer, an empty liqour bottle, and a big black dildo, it appears that no one is in the room. To the east is another hallway, and there is a staircase that leads both up and down.</html>");
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		pane.add(response, c);
		ctrl.addLabel(response);
		
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
