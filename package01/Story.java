package package01;

import package02.Monster_Gator;
import package02.Monster_Goblin;
import package02.SuperMonster;
import package02.Weapon_Fist;
import package02.Weapon_Sword;
import java.util.Random;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster, gator;
	boolean sticks, boat, goblinCaveAlive, gatorRiverAlive;
	String location;
	int monsterDmg;
	
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	//Default Player Setup
	public void defaultSetup() {
		
		player.setHP(10);
		player.setAlive(true);
		ui.hpLabelNumber.setText(""+ player.getHP());
		goblinCaveAlive = true;
		gatorRiverAlive = true;
		sticks = false;
		boat = false;
		
		//Default weapon
		player.currentWeapon = new Weapon_Fist();
		ui.weaponLabelName.setText(player.currentWeapon.getName());
	}
	
	public void selectPosition(String nextPosition) {
		switch(nextPosition) {
		case "field": field(); break;
		case "cave": cave(); break;
		case "forest": forest(); break;
		case "meadow": meadow(); break;
		case "river": river(); break;
		case "fight": fight(); break;
		case "run": run(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "winRiver": winRiver(); break;
		case "winCave": winCave(); break;
		case "lose": lose(); break;
		case "ending": ending(); break;
		case "toTitle": toTitle(); break;
		case "credits": credits(); break;
		}
	}
	
	/**
	 * Field: starting point
	 */
	
	public void field() {
		
		ui.choice2.setVisible(true);
		ui.choice3.setVisible(true);
		ui.choice4.setVisible(true);
		
		ui.mainTextArea.setText("You are in a grassy field. \n\nWhere do you want to go?");
		ui.choice1.setText("Cave");
		ui.choice2.setText("Meadow");
		ui.choice3.setText("Forest");
		ui.choice4.setText("River");
		
		game.nextPosition1 = "cave";
		game.nextPosition2 = "meadow";
		game.nextPosition3 = "forest";
		game.nextPosition4 = "river";
	}
	
	/**
	 * Forest: player can pick up a sword as a weapon and use it to fight
	 * 
	 */
	public void forest() {
		if (sticks == false) {
			//Player gets new weapon (sword)
			ui.mainTextArea.setText("You are in a forest. You find a sword hidden behind a tree.\n\n(You obtained a sword!)");
			sticks = true;
			player.currentWeapon = new Weapon_Sword();
			ui.weaponLabelName.setText(player.currentWeapon.getName());
		} 
		else {
			ui.mainTextArea.setText("You are in a forest. There is not much here.\n\nWhere do you want to go?");
		}
		ui.choice1.setText("Cave");
		ui.choice2.setText("Meadow");
		ui.choice3.setText("Field");
		ui.choice4.setText("River");
		
		game.nextPosition1 = "cave";
		game.nextPosition2 = "meadow";
		game.nextPosition3 = "field";
		game.nextPosition4 = "river";
	}
	
	/**
	 * Meadow: player can regain health
	 */
	
	public void meadow() {	
		//Player gains HP
		player.incHP(2);
		ui.hpLabelNumber.setText("" + player.getHP());
		
		ui.mainTextArea.setText("You are at a meadow.\n\nYou take a nap and gain some HP.");
		ui.choice1.setText("< Go back");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "field";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}

	
	/** 
	 * Cave: possible goblin fight
	 */
	
	public void cave() {
		if (goblinCaveAlive == true) {
			cave1();
		}
		else {
			cave2();
		}
	}
	
	/**
	 * Cave1: Player must fight the goblin.
	 * Easier if player gets the Sword from the Forest
	 */
	
	public void cave1() {
		monster = new Monster_Goblin();
		location = "cave";
	
		ui.mainTextArea.setText("You are in a cave.\nYou encounter a "+ monster.getName() +"!");
		ui.choice1.setText("Fight");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "field";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	/**
	 * Cave2: Player has defeated the goblin so doesn't need to rebattle
	 */
	
	public void cave2() {
		ui.mainTextArea.setText("You are in a cave. \n\nThe remains of the dead goblin are still lying around.");
		ui.choice1.setText("Field");
		ui.choice2.setText("Meadow");
		ui.choice3.setText("Forest");
		ui.choice4.setText("River");
		
		game.nextPosition1 = "field";
		game.nextPosition2 = "meadow";
		game.nextPosition3 = "forest";
		game.nextPosition4 = "river";
	}
	
	
	/**
	 * River: Player cannot cross until they get a boat
	 */
	public void river() {
		//No boat yet
		if (boat==false) {
		ui.mainTextArea.setText("You come to a river.\n\nIt is too big to cross, and something is bubbling in the water.");
		ui.choice1.setText("< Go back");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "field";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		}
		//If you have a boat, you can cross it
		else {
			river2();
		}
	}
	
	
	/**
	 * Player can put the boat in the river to cross it.
	 * Player should go to meadow to recover health if their hp is low
	 */
	
	public void river2() {
		if (gatorRiverAlive == true) {
			monster = new Monster_Gator();
		}
		location = "river";
	
		ui.mainTextArea.setText("You come to the river.\n\nYou put your boat in the water.");
		ui.choice1.setText("Cross the River");
		ui.choice2.setText("Cave");
		ui.choice3.setText("Forest");
		ui.choice4.setText("Meadow");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "cave";
		game.nextPosition3 = "forest";
		game.nextPosition4 = "meadow";
	}
	
	/**
	 * Fight: Player fights current monster
	 * Can either attack or run
	 * Player should run if hp is low
	 */
	
	public void fight() {
		ui.mainTextArea.setText(monster.getName() + ": "+ monster.getHP() +"\n\nWhat do you do?");
		ui.choice1.setText("Attack");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "run";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	/**
	 * Run options depending on player's current location
	 */
	
	public void run() {
		if (location.equals("cave")) {
			field();
		}
		else if (location.equals("river")) {
			river2();
		}
	}
	
	/** 
	 * Player attacking the monster
	 * If monster is alive, battle continues
	 * If monster is dead, player wins the battle
	 */
	
	public void playerAttack() {
		int playerDamage = new Random().nextInt(player.currentWeapon.getDamage());
		ui.mainTextArea.setText("You attacked the " + monster.getName() + " and gave " + playerDamage + " damage!");
		monster.decHP(playerDamage);
		
		ui.choice1.setText("Attack");
		ui.choice2.setText("Run");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if (monster.getAlive() == true) {
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "run";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	/**
	 * Monster attacks player
	 * If player is alive, battle continues
	 * If player is dead, he loses (GAME OVER)
	 */
	
	public void monsterAttack() {
		monsterDmg = new Random().nextInt(monster.getAtk());
		ui.mainTextArea.setText(monster.getAtkMsg() + "\nYou received " + monsterDmg + " damage!");
		player.decHP(monsterDmg);
		ui.hpLabelNumber.setText(""+ player.getHP());
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if (player.getAlive()==true) {
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else {
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	/**
	 * Win options depending on player location 
	 * Player can win in cave or river
	 * Monster is dead if player wins
	 */
	
	public void win() {
		if (location.equals("cave")) {
			goblinCaveAlive = false;
			winCave();
		}
		else if (location.equals("river")) {
			gatorRiverAlive = false;
			winRiver();
		}
	}
	
	/**
	 * Player defeats the monster and attains a boat 
	 * Boat can be used to cross river
	 */
	
	public void winCave() {
		ui.mainTextArea.setText("You defeated the " + monster.getName() + "!\n\nYou explore the cave and find a boat.\n\n(You obtained a boat!)");
		boat = true;	//player received boat
		
		ui.choice1.setText("Field");
		ui.choice2.setText("Cave");
		ui.choice3.setText("Meadow");
		ui.choice4.setText("River");
		
		game.nextPosition1 = "field";
		game.nextPosition2 = "cave";
		game.nextPosition3 = "meadow";
		game.nextPosition4 = "river";
	}

	/**
	 * Player defeats the monster and crosses the river
	 */
	
	public void winRiver() {
		ui.mainTextArea.setText("You defeated the " + monster.getName() + "!\n\nYou finish crossing the river and see a person in the distance.");
		
		ui.choice1.setText("Go to person");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "ending";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	/**
	 * Player's hp drops to 0
	 * Player loses and must restart game
	 */
	
	public void lose() {
		ui.mainTextArea.setText("You are dead!\n\n GAME OVER");
		
		ui.choice1.setText("Replay");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	/**
	 * Ending: Player wins the game
	 */
	
	public void ending() {
		ui.mainTextArea.setText("You get off your boat and your friend approaches you.\n\n Friend: Welcome home!\n\nTHE END");
		
		ui.choice1.setText("Replay");
		game.nextPosition1 = "toTitle";
		
		//Make buttons be invisible
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
	}
	
	/** 
	 * Brings player to title
	 */
	
	public void toTitle() {
		defaultSetup();
		vm.showTitleScreen();
	}
	
	/**
	 * Credits section
	 */
	
	public void credits() {
		ui.mainTextArea.setText("Made By: May Guo (@windcloak)\n\nBased on RyiSnow's Youtube tutorial\nCoded in Java on Eclipse");
		
		ui.choice1.setText("< Go Back");
		game.nextPosition1 = "toTitle";
		
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);

	}
	
}
