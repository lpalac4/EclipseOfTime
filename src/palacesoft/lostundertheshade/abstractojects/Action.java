package palacesoft.lostundertheshade.abstractojects;

import java.util.ArrayList;

import palacesoft.lostundertheshade.core.Characters;


/**
 * Action is the base class for the actions a player can take including domestic, military etc...
 * @author DaPalacios
 *
 */
public abstract class Action {
	
	private int apUsed;
	private Characters whoWillCommit;
	public static ArrayList<Characters> alreadyCommittedChar = new ArrayList<Characters>();
	private int playerAP;
	
	public Action(){
		apUsed = 0;
		whoWillCommit = new Characters();
		playerAP = 0;
	}
	
	public void initiate(){
		//this should defer to subclasses
	}

	
	
	
	/**
	 * Getters and setters********************************
	 */
	
	
	
	public int getApUsed() {
		return apUsed;
	}

	public static ArrayList<Characters> getAlreadyCommittedChar() {
		return alreadyCommittedChar;
	}

	public static void setAlreadyCommittedChar(
			ArrayList<Characters> alreadyCommittedChar) {
		Action.alreadyCommittedChar = alreadyCommittedChar;
	}

	public int getPlayerAP() {
		return playerAP;
	}

	public void setPlayerAP(int playerAP) {
		this.playerAP = playerAP;
	}

	public void setApUsed(int apUsed) {
		this.apUsed = apUsed;
	}

	public Characters getWhoWillCommit() {
		return whoWillCommit;
	}

	public void setWhoWillCommit(Characters whoWillCommit) {
		this.whoWillCommit = whoWillCommit;
	}
	
	
	
}
