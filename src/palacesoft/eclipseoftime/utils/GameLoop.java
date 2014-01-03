package palacesoft.eclipseoftime.utils;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;

import palacesoft.eclipseoftime.models.Player;
import palacesoft.eclipseoftime.models.Player.Difficulty;

public class GameLoop {

	private TurnController turnController;
	private boolean testing;
	public GameLoop(int numPlayers, Difficulty diff, File gameData, Context context){
		/* testing flag */
		testing = true;
		
		ArrayList<Player> newPlayers = new ArrayList<Player>();
		for(int i = 0; i < numPlayers; i++){
			newPlayers.add(new Player("Player".concat(String.valueOf(i+1)), diff));
		}
		turnController = new TurnController(newPlayers);
		initiateGameState(gameData);

	}

	public TurnController getTurnController() {
		return turnController;
	}

	public void setTurnController(TurnController turnController) {
		this.turnController = turnController;
	}
	
	public void initiateGameState(File nameData){
		
		/* test data */
		if(testing){
			TestData testData = new TestData(this);
			testData.initializeData();
		}
		
		/* parse kingdom data */
		
	}
	
	public void addKingdom(){
		
	}
	
	public void addCharacter(){
		
	}
	
	public void addItem(){
		
	}
	
	public void resetPlayerAP(){
		
	}
	
	
}
