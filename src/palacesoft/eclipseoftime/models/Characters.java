package palacesoft.eclipseoftime.models;

import java.util.ArrayList;

import palacesoft.eclipseoftime.baseobjects.Person;
import android.content.Context;
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
	
	private ArrayList<Item> items;
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
		
	public Characters(int str_, int cunning_ , int wisdom_, int auth_, int honor_, int faith_, int loyalty_, Rank rank_, CharacterType charType_, 
			ArrayList<Item> items_, ImageView portrait_, ArrayList<Characters> family_, Kingdom faction_){
		str = str_;
		cunning =cunning_;
		wisdom = wisdom_;
		authority = auth_;
		honor = honor_;
		faith = faith_;
		loyalty = loyalty_;
		rank = rank_;
		charType = charType_;
		items = items_;
		portrait = portrait_;
		family = family_;
		faction = faction_;
	}
	
	public Characters(String rulerName, ImageView rulerImage, Kingdom kingdom_, Context context) {
		str =  50;
		cunning = 50;
		wisdom = 50;
		authority = 50;
		honor = 50;
		faith = 50;
		loyalty = 100;
		rank = Rank.RULER;
		items = new ArrayList<Item>();
		portrait = new ImageView(context);
		family = new ArrayList<Characters>();
		faction = kingdom_;

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

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
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
