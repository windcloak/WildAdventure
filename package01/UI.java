/**
 * Styling and graphics
 */
package package01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import package01.Game.ChoiceHandler;

public class UI {
	
	JFrame window;
	JPanel creditsButtonPanel, titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel creditsLabel, titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JButton startButton, creditsButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	Font titleFont = new Font("Garamond", Font.PLAIN, 52);
	Font startFont = new Font("Garamond", Font.PLAIN, 35);
	Font creditsFont = new Font("Garamond", Font.PLAIN, 23);
	Font normalFont = new Font("Arial", Font.PLAIN, 28);

	public void createUI(ChoiceHandler cHandler) {

		// WINDOW
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		
		// TITLE SCREEN
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 150, 600, 150);	//padding size
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("MY WILD ADVENTURE");
		titleNameLabel.setForeground(Color.white); //text color
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		window.add(titleNamePanel);
		
		//START BUTTON
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.blue);
		startButton.setForeground(Color.white); 
		startButton.setFont(startFont);
		startButton.setFocusPainted(false); 	//delete border
		startButton.addActionListener(cHandler);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		window.add(startButtonPanel);
		
		//CREDITS BUTTON
		creditsButtonPanel = new JPanel();
		creditsButtonPanel.setBounds(550, 590, 200, 100);
		creditsButtonPanel.setBackground(Color.black);
		creditsButton = new JButton("CREDITS");
		creditsButton.setBackground(Color.black);
		creditsButton.setForeground(Color.white); 
		creditsButton.setFont(creditsFont);
		creditsButton.setFocusPainted(false);
		creditsButton.setBorder(null);
		creditsButton.addActionListener(cHandler);
		creditsButton.setActionCommand("credits");
		startButtonPanel.add(creditsButton);
		window.add(creditsButtonPanel);
		
		//LOAD GAME BUTTON

		
		window.setVisible(true);
		
		//GAME SCREEN
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea("");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4, 1)); //4 rows 1 col
		window.add(choiceButtonPanel);
		
		//BUTTONS FOR CHOICE SELECTION
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(cHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(cHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		//PLAYER STATUS
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1, 4));
		window.add(playerPanel);
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
	}
}
