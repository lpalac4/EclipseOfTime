package palacesoft.lostundertheshade.actions;

import java.util.ArrayList;

import palacesoft.lostundertheshade.abstractojects.Action;
import palacesoft.lostundertheshade.core.Characters;
import palacesoft.lostundertheshade.core.City;
import palacesoft.lostundertheshade.core.Kingdom;
import palacesoft.lostundertheshade.core.Player;

public class Plot extends Action {

	private Kingdom kingdom;
	private ArrayList<Characters> charsPlotting;
	
	
	public Plot(){
		
		
	}
	
	
	public Plot(Kingdom k) {
		kingdom = k;
		charsPlotting = new ArrayList<Characters>();
	}
	
	@Override
	public void initiate(){
		
	}
	
	public void startAssassination(Characters plotter, Characters target){
		int plotterCunning = plotter.getCunning();
		int targetStrength = target.getStr();
		int chanceOfSuccess = plotterCunning/(targetStrength*2);
		
		double success = (Math.random() * chanceOfSuccess);
		if(success > 0.5){
			murder(target);
		}
		if(success < 0.15){
			spotted(plotter.getFaction().getPlayer(), target.getFaction().getPlayer());
		}
	}
	
	/**
	 * This method will adjust foreign relations between two kingdoms. 
	 * @param player
	 * @param player2
	 */
	private void spotted(Player player, Player player2) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Target gets murdered and depending on the role of that target the player may need to replace 
	 * that character from his/her position up to changing leader.  Changing leader will cause order issues
	 * and character loyalties to drop.
	 * @param target
	 */
	private void murder(Characters target) {
		
		
	}

	/**
	 * Rumors can be spread about a character or about the rulers of a particular city.
	 * @param plotter
	 * @param charTarget
	 * @param cityTarget
	 */
	public void startRumor(Characters plotter, Characters charTarget, City cityTarget){
		int plotterCunning = plotter.getCunning();
		if(charTarget == null){
			int cityTargetDefense = cityTarget.getOrder();
			double success = plotterCunning/(cityTargetDefense * 2);
			if(success > 0.5){
				rumorsInCitySuccess(cityTarget);
			}
			if(success < 0.15){
				reportRumorSource(cityTarget.getRuler(), plotter.getFaction().getPlayer());
			}
				
			
		}
		if(cityTarget == null){
			int targetResilience = (charTarget.getAuthority() + charTarget.getWisdom())/2;
			double success = plotterCunning/(targetResilience * 2);
			if(success > 0.5){
				rumorsAgainstChar(charTarget);
			}
		}
	}
	
	/**
	 * Source of rumors have been discovered and foreign relations will take a hit between the two parties.
	 * @param ruler
	 * @param player
	 */
	private void reportRumorSource(Player ruler, Player player) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * Rumors against a person have succeeded and have an effect on the relationship between said person
	 * and his/her leader.
	 * @param charTarget
	 */
	private void rumorsAgainstChar(Characters charTarget) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Rumors against a leader have suceeded and have caused city order and loyalty of all characters in that city 
	 * to lower.
	 * @param cityTarget
	 */
	private void rumorsInCitySuccess(City cityTarget) {
		// TODO Auto-generated method stub
		
	}


	public void startSabotage(Characters plotter, City cityTarget, boolean targetIsFood){
		int plotterCunning = plotter.getCunning();
		int cityDefenses = cityTarget.getOrder();
		
		if(targetIsFood){
			double success = plotterCunning/cityDefenses;
			if(success > 1.5){
				poisonFood(cityTarget);
			}
			if(success < 0.2){
				spotted(plotter.getFaction().getPlayer(), cityTarget.getRuler());
			}
		}
		else{
			double success = plotterCunning/cityDefenses;
			if(success > 1.25){
				burnWeapons(cityTarget);
			}
			if(success < 0.2){
				spotted(plotter.getFaction().getPlayer(), cityTarget.getRuler());
			}
		}
	}


	private void burnWeapons(City cityTarget) {
		// TODO Auto-generated method stub
		
	}


	private void poisonFood(City cityTarget) {
		// TODO Auto-generated method stub
		
	}

}
