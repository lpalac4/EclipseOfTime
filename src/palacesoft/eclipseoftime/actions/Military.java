package palacesoft.eclipseoftime.actions;

import java.util.ArrayList;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.City;
import palacesoft.eclipseoftime.models.Force;
import palacesoft.eclipseoftime.models.Kingdom;

public class Military extends Action{
	
	ArrayList<Force> forcesActive;
	
	
	public Military(){
		
	}

	public Military(Kingdom kingdom) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initiate(){
		
		
	}
	/** 
	 * Calculates an empirical measure of a kingdom strength based on many factors including
	 * the number of talented generals, their draft potential, their armaments, the city's order 
	 * and fortifications and lastly the number of allies held by the kingdom.
	 * @return an integer value representing the strength of the kingdom
	 */
	public int getTotalStrength() {
		int totalStrength = 0;
		City city = kingdom.getHomeCity();
		for(Characters c : kingdom.getCharacterRoster()){
			if(c.getStr() > 60)
				totalStrength += 4;
			if(c.getStr() > 80) 
				totalStrength += 1;
			if(c.getStr() > 90)
				totalStrength += 1;
			
		}
		totalStrength += city.getPopulation();
		totalStrength += city.getAtlatls() + city.getBows() + city.getMaquahuitls() + city.getNormalClubs();
		if(city.getWall() != null)
			totalStrength += 50;
		if(city.getOrder() < 30)
			totalStrength -= 25;
		totalStrength += kingdom.getAllies().size() * 100;
		
		return totalStrength;
	}
	/**
	 * Calls your banners and forces your subjects to declare war on another kingdom, dependent 
	 * on their allegiance towards you and the target this may negatively effect their loyalty.
	 * @param target
	 * @param ally
	 */
	public void rallyBannermen(Kingdom target, Kingdom ally){
		
	}
	
	/**
	 * Attack a single target kingdom with combined forces of your troops and your allies', the 
	 * agreement is void after 3 turns.
	 * @param taget
	 * @param allies
	 */
	public void coordinateAttack(Kingdom taget, ArrayList<Kingdom> allies){
		
	}

}
