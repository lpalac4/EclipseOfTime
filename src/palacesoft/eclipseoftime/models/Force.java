package palacesoft.eclipseoftime.models;

import palacesoft.eclipseoftime.baseobjects.Person;

/**
 * The Force class represents a force with persons and weapons.
 * @author DaPalacios
 *
 */
public class Force {
	
	private Characters General;
	private Characters Liutenant;
	private Characters Captain;
	
	private int personCount;
	private Person personType;
	private Weapon weaponType;
	private int morale;
	private int forceStrength;
	
	
	public Force(){
		personCount = 1;
		personType = new Person();
		weaponType = new Weapon();
		morale = 100;
		forceStrength = 0;
	}
	
	public Force(Person personT, Weapon weaponT, int numbers){
		personCount = numbers;
		personType = personT;
		weaponType = weaponT;
		personCount = numbers;
		morale = 100;
		calculateForceStrength();
		
	}

	
	private void calculateForceStrength() {
		forceStrength = personCount * weaponType.getAtkboost() + personCount * weaponType.getDefboost();
	}
	
	

	/**w
	 * Getters and setters****************************************************
	 */

	public int getForceStrength() {
		calculateForceStrength();
		return forceStrength;
	}

	public void setForceStrength(int forceStrength) {
		this.forceStrength = forceStrength;
	}
	
	public int getPersonCount() {
		return personCount;
	}

	public void setPersonCount(int personCount) {
		this.personCount = personCount;
	}

	public Person getPersonType() {
		return personType;
	}

	public void setPersonType(Person personType) {
		this.personType = personType;
	}

	public Weapon getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(Weapon weaponType) {
		this.weaponType = weaponType;
	}

	public int getMorale() {
		return morale;
	}

	public void setMorale(int morale) {
		this.morale = morale;
	}

	public Characters getGeneral() {
		return General;
	}

	public void setGeneral(Characters general) {
		General = general;
	}

	public Characters getLiutenant() {
		return Liutenant;
	}

	public void setLiutenant(Characters liutenant) {
		Liutenant = liutenant;
	}

	public Characters getCaptain() {
		return Captain;
	}

	public void setCaptain(Characters captain) {
		Captain = captain;
	}

}
