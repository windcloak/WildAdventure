/**
 * Shows what panels are visible
 */

package package01;

public class VisibilityManager {

	UI ui;
	
	public VisibilityManager(UI userInterface) {

		ui = userInterface;
	}
	
	public void showTitleScreen() {
		
		//Show title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		ui.creditsButtonPanel.setVisible(true);
		
		//Hide game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
	}
	
	
	public void titleToGame() {
		//Hide title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.creditsButtonPanel.setVisible(false);
		
		//Show game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}
	
	public void titleToCredits() {
		//Hide title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		ui.creditsButtonPanel.setVisible(false);
		
		//Show game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		
		//Hide player stats
		ui.playerPanel.setVisible(false);
	}
	
	
}
