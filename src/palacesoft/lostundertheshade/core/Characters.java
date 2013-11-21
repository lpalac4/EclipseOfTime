package palacesoft.lostundertheshade.core;

import java.util.ArrayList;

import palacesoft.lostundertheshade.abstractojects.Person;
import android.widget.ImageView;


/**
 * Characters class inherits from Person and is reserved for persons who have a larger role to play.
 * @author DaPalacios
 *
 */
public class Characters extends Person {

	private int str;
	private int cunning;
	private int wisdom;
	private int authority;
	private int honor;
	private int faith;
	private int loyalty;
	private boolean commited;
	private boolean isAlive;
	
	private Item items;
	private String name;
	private ImageView portrait;
	private ArrayList<Characters> family;
	private Kingdom faction;
	
	public static enum Rank {
		FREE,
		OFFICER,
		COUNCIL,
		RULER
	};
	
	private Rank rank;
	
	public static enum CharacterType {
		FIERCE,
		RIGHTEOUS,
		FAITHFUL,
		TRICKSTER,
		ROMANTIC
	};
	
	private CharacterType charType;
	
	public static enum Conversation {
		RUDE,
		CHALLENGING,
		APOLOGETIC,
		THANKFUL,
		SHOCKED,
		DISMISSIVE
	};
	private Conversation convoType;
		
	
	public Characters(String rulerName, ImageView rulerImage) {
		// TODO Auto-generated constructor stub
	}

	public Characters() {
		// TODO Auto-generated constructor stub
	}
	
	public void murder() {
		isAlive = false;
		
	}
	
	
	/**
	 * Getters and setters*********************************
	 */

	

	
	public int getStr() {
		return str;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	private void dealWithDeaths() {
		// TODO Auto-generated method stub
		
	}

	public Kingdom getFaction() {
		return faction;
	}

	public void setFaction(Kingdom faction) {
		this.faction = faction;
	}

	public boolean isCommited() {
		return commited;
	}

	public void setCommited(boolean commited) {
		this.commited = commited;
	}

	public int getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getCunning() {
		return cunning;
	}

	public void setCunning(int cunning) {
		this.cunning = cunning;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public int getHonor() {
		return honor;
	}

	public void setHonor(int honor) {
		this.honor = honor;
	}

	public int getFaith() {
		return faith;
	}

	public void setFaith(int faith) {
		this.faith = faith;
	}

	public Item getItems() {
		return items;
	}

	public void setItems(Item items) {
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImageView getPortrait() {
		return portrait;
	}

	public void setPortrait(ImageView portrait) {
		this.portrait = portrait;
	}

	public ArrayList<Characters> getFamily() {
		return family;
	}

	public void setFamily(ArrayList<Characters> family) {
		this.family = family;
	}

	public void adjustLoyalty(int delta) {
		// TODO Auto-generated method stub
		
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public CharacterType getCharType() {
		return charType;
	}

	public void setCharType(CharacterType charType) {
		this.charType = charType;
	}
	
	

	
	
	

}
