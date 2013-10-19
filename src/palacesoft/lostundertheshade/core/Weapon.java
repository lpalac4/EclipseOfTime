package palacesoft.lostundertheshade.core;


/**
 * The Weapon class represents the equipment a Force can equip on their Person(s) and therefore boost their statistics.
 * @author DaPalacios
 *
 */
public class Weapon {


	public static enum WeaponType{
		Normal,
		Spear,
		Bow,
		Atlatl,
		Maquahuitl
	};
	
	private WeaponType weaponType;
	
	private int atkboost;
	private int defboost;
	private int rangeboost;
	private int movboost;
	
	public Weapon(){
		weaponType = WeaponType.Normal;
		calculateStats();
	}
	
	public Weapon(Weapon.WeaponType weapon){
		weaponType = weapon;
		calculateStats();
	}
	
	
	private void calculateStats() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Getters and setters **********************************
	 */

	
	public WeaponType getWeaponType() {
		return weaponType;
	}
	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}
	public int getAtkboost() {
		return atkboost;
	}
	public void setAtkboost(int atkboost) {
		this.atkboost = atkboost;
	}
	public int getDefboost() {
		return defboost;
	}
	public void setDefboost(int defboost) {
		this.defboost = defboost;
	}
	public int getRangeboost() {
		return rangeboost;
	}
	public void setRangeboost(int rangeboost) {
		this.rangeboost = rangeboost;
	}
	public int getMovboost() {
		return movboost;
	}
	public void setMovboost(int movboost) {
		this.movboost = movboost;
	}
	
}
