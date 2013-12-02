package palacesoft.eclipseoftime.actions;

import java.util.HashMap;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.Item;
import palacesoft.eclipseoftime.models.Kingdom;
import palacesoft.eclipseoftime.models.Player;
import palacesoft.eclipseoftime.models.TurnController;

public class Politics extends Action{

	private HashMap<Kingdom, Integer> opponentStanding;
	private int WEALTHY_NATION = 1000;
	private int WORTHY_OFFER = 750;
	
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
	 * Method returns boolean whether the envoy has succesfully recruited the target champion.
	 * @param envoy
	 * @param target
	 * @param goldAmount
	 * @return
	 */
	public boolean hireChar(Characters envoy, Characters target, int goldAmount){
		int success = 0;
		if(envoy.getCharType() == target.getCharType()){
			success += 50;
		}
		
		if(envoy.getAuthority() > 90)
			success += 20;
		else if(envoy.getAuthority() > 80 && envoy.getAuthority() <=90)
			success +=15;
		else if(envoy.getAuthority() > 70 && envoy.getAuthority() <= 80)
			success +=10;
		else if(envoy.getAuthority() > 55 && envoy.getAuthority() <= 70)
			success += 5;
		else
			success += 1;
		
		if(kingdom.getTreasury().getFunds() > WEALTHY_NATION){
			success += (goldAmount/WEALTHY_NATION) * 10;
		}else{
			if(goldAmount > WORTHY_OFFER ) success += 10;
			else if(goldAmount > 500 && goldAmount <= WORTHY_OFFER) success += 7;
			else if(goldAmount > 200 && goldAmount <= 500) success += 5;
			else if(goldAmount > 0) success += 1;
		}
		
		success = (int) ((success * Math.random()) + (envoy.getFaction().getHomeCity().getOrder() * Math.random()) - (Math.random() * target.getLoyalty()));
		if(success > 65)
			return true;
		else return false;
	}
	/**
	 * Reward a character directly from the ruler with either gold or an item.
	 * @param target
	 * @param goldAmount
	 * @param item
	 */
	public Characters.Conversation rewardCharacter(Characters target, int goldAmount, Item item){
		int loyaltyIncrease = 0;
		if(item == null){
			if(goldAmount > 200){
				if(target.getLoyalty() < 40)	
					loyaltyIncrease += 20;
				if(target.getLoyalty() < 60 && target.getLoyalty() >= 40)
					loyaltyIncrease += 15;
				if(target.getLoyalty() < 85 && target.getLoyalty() >= 60)
					loyaltyIncrease += 10;
				else
					loyaltyIncrease += 5;
			}
			else {
				if(target.getLoyalty() < 40)	
					loyaltyIncrease += 10;
				if(target.getLoyalty() < 60 && target.getLoyalty() >= 40)
					loyaltyIncrease += 8;
				if(target.getLoyalty() < 85 && target.getLoyalty() >= 60)
					loyaltyIncrease += 6;
				else
					loyaltyIncrease += 4;
			}
				
		}
		else {
			if(target.getLoyalty() < 40)
				loyaltyIncrease += 40;
			else if(target.getLoyalty() < 50 && target.getLoyalty() >= 40)
				loyaltyIncrease += 35;
			else if(target.getLoyalty() < 60 && target.getLoyalty() >= 50)
				loyaltyIncrease += 30;
			else if(target.getLoyalty() < 80 && target.getLoyalty() >= 60)
				loyaltyIncrease += 20;
			else {
				loyaltyIncrease = 100 - target.getLoyalty();
			}
		}
			
		target.setLoyalty(loyaltyIncrease + target.getLoyalty()); 
		return Characters.Conversation.THANKFUL;
		
	}
	/**
	 * Marry two characters and unite their families which has an impact on their loyalties to a house
	 * @param husband
	 * @param wife
	 */
	public void marryCharactes(Characters husband, Characters wife){
		husband.getFamily().add(wife);
		
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
