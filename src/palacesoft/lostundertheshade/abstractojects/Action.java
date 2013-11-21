package palacesoft.lostundertheshade.abstractojects;

import java.util.ArrayList;

import palacesoft.lostundertheshade.core.Characters;
import palacesoft.lostundertheshade.core.Kingdom;


/**
 * Action is the base class for the actions a player can take including domestic, military etc...
 * @author DaPalacios
 *
 */
public abstract class Action {
	
	protected int apUsed;
	protected Characters whoWillCommit;
	protected Kingdom kingdom;
	public static ArrayList<Characters> alreadyCommittedChar = new ArrayList<Characters>();
	protected int playerAP;
	
	public static enum ActionType{
		none,
		JUST,
		GOOD,
		POLITICAL,
		DAMAGING,
		MALICIOUS
	}
	
	public ActionType actionType = ActionType.none;
	
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
