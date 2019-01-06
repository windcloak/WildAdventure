/**
 * SuperWeapon is a superclass of all the weapons
 * @author May
 * @param name name of weapon
 * @param damage damage given from weapon
 *
 */

package package02;

public class SuperWeapon {
	
	private String name;
	private int damage;
	
	//Name of Weapon
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Damage given from weapon
	
	public void setDamage(double damage) {
		this.damage = (int) damage;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
}
