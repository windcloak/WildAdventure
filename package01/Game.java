/**
 * @author May Guo
 * @since 1/1/19
 * This is a text adventure game with RPG elements.
 * Player must defeat the monsters and go home to win the game.
 * The game is playable by clicking buttons.
 * This game was made following a tutorial by Ryisnow on Youtube.
 *
 */

package package01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	
	ChoiceHandler cHandler = new ChoiceHandler();
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	Story story = new Story(this, ui, vm);
	String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
	
	public static void main(String[] args) {
		new Game();
	}
	
	public Game() {
		ui.createUI(cHandler);
		story.defaultSetup();
		vm.showTitleScreen();
	}
	
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			case "start": vm.titleToGame(); story.field(); break;
			case "credits": vm.titleToCredits(); story.credits(); break;
			case "c1": story.selectPosition(nextPosition1); break;
			case "c2": story.selectPosition(nextPosition2); break;
			case "c3": story.selectPosition(nextPosition3); break;
			case "c4": story.selectPosition(nextPosition4); break;
			}
		}
	}
}
