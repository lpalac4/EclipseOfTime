package palacesoft.eclipseoftime.actions;

import java.util.ArrayList;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.City;
import palacesoft.eclipseoftime.models.Kingdom;
import palacesoft.eclipseoftime.models.Player;

public class Plot extends Action {

	private ArrayList<Characters> charsPlotting;
	
	public Plot(){
		kingdom = null;
		charsPlotting = null;
		
	}
	
	
	public Plot(Kingdom k) {
		kingdom = k;
		charsPlotting = new ArrayList<Characters>();
	}
	
	@Override
	public void initiate(){
		
	}
	/**
	 * Starts assasination routine.
	 * @param plotter is the character committing the action.
	 * @param target is the recipient of the action.
	 */
	
	public void startAssassination(Characters plotter, Characters target){
		int plotterCunning = plotter.getCunning();
		int targetStrength = target.getStr();
		int chanceOfSuccess = plotterCunning/(targetStrength*2);
		
		double success = (Math.random() * chanceOfSuccess);
		if(success > 0.5){
			murder(target);
		}
		if(success < 0.15){
			spotted(plotter.getFaction().getPlayer(), target.getFaction().getPlayer(), ActionType.MALICIOUS);
		}
	}
	
	/**
	 * This method will adjust foreign relations between two kingdoms. 
	 * @param player
	 * @param player2
	 */
	private void spotted(Player player, Player player2, ActionType actionType) {
		player.getKingdom().getPolitics().adjustForeignStanding(player2.getKingdom(), actionType);		
	}

	/**
	 * Target gets murdered and depending on the role of that target the player may need to replace 
	 * that character from his/her position up to changing leader.  Changing leader will cause order issues
	 * and character loyalties to drop.
	 * @param target
	 */
	private void murder(Characters target) {
		target.murder();
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
				rumorsInCitySuccess(cityTarget, success);
			}
			if(success < 0.15){
				reportRumorSource(cityTarget.getRuler(), plotter.getFaction().getPlayer());
			}
				
			
		}
		if(cityTarget == null){
			int targetResilience = (charTarget.getAuthority() + charTarget.getWisdom())/2;
			double success = plotterCunning/(targetResilience * 2);
			if(success > 0.5){
				rumorsAgainstChar(charTarget, success);
			}
		}
	}
	
	/**
	 * Source of rumors have been discovered and foreign relations will take a hit between the two parties.
	 * @param ruler
	 * @param player
	 */
	private void reportRumorSource(Player ruler, Player player) {
		ruler.getKingdom().getPolitics().adjustForeignStanding(player.getKingdom(), ActionType.POLITICAL);
		
	}


	/**
	 * Rumors against a person have succeeded and have an effect on the relationship between said person
	 * and his/her leader.
	 * @param charTarget
	 */
	private void rumorsAgainstChar(Characters charTarget, double damage) {
		damage *= 5;
		charTarget.adjustLoyalty((int)damage);
		
	}

	/**
	 * Rumors against a leader have suceeded and have caused city order and loyalty of all characters in that city 
	 * to lower.
	 * @param cityTarget
	 */
	private void rumorsInCitySuccess(City cityTarget, double damage) {
		cityTarget.adjustOrder((int)damage);
		for(Characters c : cityTarget.getInhabitants()){
			c.adjustLoyalty((int)damage);
		}
	}

/**
 * Attempt to sabotage either the cityTarget's food supply or their weapon stash.
 * @param plotter
 * @param cityTarget
 * @param targetIsFood
 */
	public void startSabotage(Characters plotter, City cityTarget, boolean targetIsFood){
		int plotterCunning = plotter.getCunning();
		int cityDefenses = cityTarget.getOrder();
		
		if(targetIsFood){
			double success = plotterCunning/cityDefenses;
			if(success > 1.5){
				poisonFood(cityTarget, success);
			}
			if(success < 0.2){
				spotted(plotter.getFaction().getPlayer(), cityTarget.getRuler(), ActionType.POLITICAL);
			}
		}
		else{
			double success = plotterCunning/cityDefenses;
			if(success > 1.25){
				burnWeapons(cityTarget, success);
			}
			if(success < 0.2){
				spotted(plotter.getFaction().getPlayer(), cityTarget.getRuler(), ActionType.POLITICAL);
			}
		}
	}

	/**
	 * Lets the city object know to destroy some of their weapons based on the damage meter
	 * @param cityTarget
	 * @param damage
	 */
	private void burnWeapons(City cityTarget, double damage) {
		cityTarget.burnWeapons((int) damage);
		
	}

	/**
	 * Lets the city object know to destroy some of their food
	 * @param cityTarget
	 * @param damage
	 */
	private void poisonFood(City cityTarget, double damage) {
		cityTarget.destroyFood((int) damage);
		
	}

}
