package palacesoft.eclipseoftime.baseobjects;

import palacesoft.eclipseoftime.models.Weapon;

/**
 * Person class is the base class for all individual units in the game including Characters.
 * @author DaPalacios
 *
 */
public class Person {

	/* hit points of every characters */
	private int hp;
	/* attack value */
	private int atk;
	/* defense value */
	private int def;
	/* how many spaces this unit can move */
	private int mov;
	/* how far away it can attack */
	private int range;
	/* named unit reserved for Characters */
	private String name;
	/* type of weapon used */
	private Weapon weapon;
	
	public Person(){
		hp = 100;
		atk = 1;
		def = 1;
		mov = 1;
		range = 1;
		name = "person";
		weapon = new Weapon();
		
	}
	

	/**
	 * Getters and setters
	 */
	
	public Weapon getWeapon() {
		return weapon;
	}



	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getMov() {
		return mov;
	}

	public void setMov(int mov) {
		this.mov = mov;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
