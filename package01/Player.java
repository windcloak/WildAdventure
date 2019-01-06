/**
 * Player setup
 * @param currentWeapon weapon that player is equipped with
 * @param hp health points
 * @param MAX_HP player's maximum health
 * @param alive true if player is alive, false if dead
 * 
 */

package package01;

import package02.SuperWeapon;

public class Player {
	
	public SuperWeapon currentWeapon;
	
	//Constants
	public static final int MAX_HP = 30;	//Player's max hp
	
	//Variables
	private int hp;
	private boolean alive;
	
	//Constructor
	public Player() {
		hp = 10;	//default hp
		alive = true; //player is alive
	}
	
	public boolean getAlive() {
		return this.alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	//Getter
	public int getHP() {
		return this.hp;
	}
	
	//Set HP
	public void setHP(double hp) {
		this.hp = (int) hp;
	}
	
	//Increase hp
	public void incHP(double hp) {
		if ((this.hp + hp) >= MAX_HP) {
			this.hp = (int) MAX_HP;
		}
		//General: increase hp
		else {
			this.hp += (int) hp;
		}
	}
	
	//Decrease hp
	public void decHP(double hp) {
		this.hp -= (int) hp;
		
		/* Negative hp = Player is dead */
		if (this.hp <= 0) {
			this.hp = 0;
			this.alive = false;
		}
	}
}
