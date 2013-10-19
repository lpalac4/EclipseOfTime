package palacesoft.lostundertheshade.actions;

import java.util.HashMap;

import palacesoft.lostundertheshade.abstractojects.Action;
import palacesoft.lostundertheshade.core.Kingdom;
import palacesoft.lostundertheshade.core.Player;
import palacesoft.lostundertheshade.core.TurnController;

public class Politics extends Action{

	private HashMap<Kingdom, Integer> opponentStanding;
	
	public Politics(){
		opponentStanding = new HashMap<Kingdom, Integer>();
	}
	
	public Politics(Kingdom kingdom) {
		opponentStanding = new HashMap<Kingdom, Integer>();
		//initialize all standing with players
		updateForeignStandings();
	}
	
	@Override
	public void initiate(){
		
	}
	
	public int getForeignStanding(Kingdom k){
		return opponentStanding.get(k);
	}
	
	public void updateForeignStandings(){
		for(Player p : TurnController.allPlayers){
			opponentStanding.put(p.getKingdom(), p.getLoyaltysys().rulerFeeling(p));
		}
	}
	
	public void updateSingleRuler(Kingdom k){
		opponentStanding.put(k, k.getPlayer().getLoyaltysys().rulerFeeling(k.getPlayer()));
	}
	
	public void adjustForeignStanding(Kingdom k, ActionType actionType){
		int newStanding = opponentStanding.get(k);
		switch(actionType){
			case none:{
			return;
			}
			case JUST: {
				newStanding += 5;
				break;
			}
			case GOOD: {
				newStanding += 3;
				break;
			}
			case POLITICAL: {
				newStanding += -2;
				break;
			}
			case DAMAGING: {
				newStanding += -3;
				break;
			}
			case MALICIOUS: {
				newStanding += -5;
				break;
			}		
		}
		opponentStanding.put(k, newStanding);
		
	}
	
	
	
	/**
	 * Getters and setters
	 */
	

	public HashMap<Kingdom, Integer> getOpponentStanding() {
		return opponentStanding;
	}

	public void setOpponentStanding(HashMap<Kingdom, Integer> opponentStanding) {
		this.opponentStanding = opponentStanding;
	}

	


}
