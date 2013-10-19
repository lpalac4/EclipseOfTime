package palacesoft.lostundertheshade.core;

import android.widget.ImageView;

/**
 * The item class is the upgrade to Characters' statistics like Weapon is a boost to Persons.
 * @author DaPalacios
 *
 */
public class Item {
	
	private ImageView image;
	
	private int strengthboost;
	private int cunningboost;
	private int wisdomboost;
	private int authorityboost;
	private int honorboost;
	private int faithboost;
	
	public Item(){
		image = null;
		strengthboost = 0;
		cunningboost = 0;
		wisdomboost = 0;
		authorityboost = 0;
		honorboost = 0;
		faithboost = 0;
	}
	
	public Item(ImageView imageptr, int strboost, int cunnboost, int wisdboost, int authboost, int honboost, int faitboost){
		image = imageptr;
		strengthboost = strboost;
		cunningboost = cunnboost;
		wisdomboost = wisdboost;
		authorityboost = authboost;
		honorboost = honboost;
		faithboost = faitboost;
	}
	
	
	/**
	 * Getters and setters ********************************************************************
	 */
	public ImageView getImage() {
		return image;
	}

	public void setImage(ImageView image) {
		this.image = image;
	}

	public int getStrengthboost() {
		return strengthboost;
	}

	public void setStrengthboost(int strengthboost) {
		this.strengthboost = strengthboost;
	}

	public int getCunningboost() {
		return cunningboost;
	}

	public void setCunningboost(int cunningboost) {
		this.cunningboost = cunningboost;
	}

	public int getWisdomboost() {
		return wisdomboost;
	}

	public void setWisdomboost(int wisdomboost) {
		this.wisdomboost = wisdomboost;
	}

	public int getAuthorityboost() {
		return authorityboost;
	}

	public void setAuthorityboost(int authorityboost) {
		this.authorityboost = authorityboost;
	}

	public int getHonorboost() {
		return honorboost;
	}

	public void setHonorboost(int honorboost) {
		this.honorboost = honorboost;
	}

	public int getFaithboost() {
		return faithboost;
	}

	public void setFaithboost(int faithboost) {
		this.faithboost = faithboost;
	}

	
	
	
}
