package palacesoft.eclipseoftime.utils;

import java.util.ArrayList;

import palacesoft.eclipseoftime.models.Player;

/**
 * TurnController class manages the turns for all players.
 * @author DaPalacios
 *
 */
public class TurnController {

	private Player currentPlayer;
	static int turnIndex = 1;
	
	public TurnController(){
		
	}
	
	public TurnController(ArrayList<Player> playersInGame){
		currentPlayer = determinePlayer();
		
	}

	public Player determinePlayer() {
		//tbd the order of turns		
		Player currentPlayer = Player.allPlayers.get(turnIndex);
		
		if(turnIndex <= Player.allPlayers.size())
			turnIndex++;
		else{
			turnIndex = 1;
		}
		return currentPlayer;
	}
	
	public void addPlayer(Player player_){
		Player.allPlayers.add(player_);
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
