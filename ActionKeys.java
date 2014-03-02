
import java.util.*;
import java.awt.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class TextUI extends JFrame {
	
	private JTextField commandBox;
	private Actions actions;
	
	public TextUI() throws FileNotFoundException{
		actions = new Actions();
	}

	private void initialize() throws FileNotFoundException {


		// add layout
		Container pane = getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// add JLabel
		JLabel response = new JLabel();
		response.setPreferredSize(new Dimension(800, 600));
		response.setSize(new Dimension(800, 600));
		response.setBorder(BorderFactory.createLoweredBevelBorder());
		response.setVerticalAlignment(JLabel.TOP);
		Font font = new Font("Times", Font.PLAIN, 30);
		response.setFont(font);
		response.setText("Text Label");
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		pane.add(response, c);
		actions.addLabel(response);

		// add JTextField
		commandBox = new JTextField();
		commandBox.setPreferredSize(new Dimension(300, 50));
		commandBox.setFont(font);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.5;
		pane.add(commandBox, c);
		actions.addTextField(commandBox);

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
