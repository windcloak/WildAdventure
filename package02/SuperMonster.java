/**
 * SuperMonster is a superclass of all the monster
 * @author May
 * @param name name of monster
 * @param attackMessage message monster says when they attack
 * @param hp health of monster
 * @param attack attack power of monster
 * @param alive true if monster is alive, false if dead
 *
 */

package package02;

public class SuperMonster {
	private String name, attackMessage;
	private int hp, attack;
	boolean alive = true;
	
	//HP
	public int getHP() {
		return this.hp;
	}
	
	public void setHP(double hp) {
		this.hp = (int) hp;
	}
	
	public void decHP(double hp) {
		this.hp -= (int) hp;
		if (this.hp <= 0) {
			this.alive = false;
		}
	}
	
	//Attack
	public int getAtk() {
		return this.attack;
	}
	
	public void setAtk(double attack) {
		this.attack = (int) attack;
	}
	
	//Name
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//Attack Message
	public String getAtkMsg() {
		return this.attackMessage;
	}
	
	public void setAtkMsg(String attackMessage) {
		this.attackMessage = attackMessage;
	}
	
	//Alive or Not
	public boolean getAlive() {
		return this.alive;
	}
}
