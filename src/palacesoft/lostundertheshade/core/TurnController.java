package palacesoft.lostundertheshade.core;

import java.util.ArrayList;

/**
 * TurnController class manages the turns for all players.
 * @author DaPalacios
 *
 */
public class TurnController {

	private Player currentPlayer;
	private ArrayList<Player> allPlayers;
	
	public TurnController(){
		
	}
	
	public TurnController(ArrayList<Player> playersInGame){
		allPlayers = playersInGame;
		currentPlayer = determinePlayer();
		
	}

	public Player determinePlayer() {
		//tbd the order of turns
				
		return currentPlayer;
	}
	
	/**
	 * At the end of each complete turn every player will have their non-military actions committed and 
	 * their effects will go into place.
	 */
	public void cashInAllPlayerActions(){
		
	}

	/**
	 * Getters and setters **********************************************************************
	 */

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public ArrayList<Player> getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(ArrayList<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}
	

	
	
	
}
