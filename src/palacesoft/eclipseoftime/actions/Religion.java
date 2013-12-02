package palacesoft.eclipseoftime.actions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.Kingdom;

public class Religion extends Action{
	
	private int level; //0:100
	private float religiousEffect;
	private float religionProgress;

	public static enum God{
		WAR,
		HARVEST,
		WEALTH,
		FERTILITY,
		TRICKS,
		DEATH
	};
	
	private HashMap<Religion.God, Boolean> activeGodBonus;
	private HashMap<Religion.God, Integer> bonusDuration;
	
	/* Constructors */
	public Religion(){
		level = 0;
		religiousEffect = 0.0f;
		religionProgress = 0.0f;
		activeGodBonus = null;
	}
	
	public Religion(Kingdom kingdom) {
		level = 0;
		religiousEffect = 0.0f;
		religionProgress = 0.0f;
		for(Religion.God g : God.values()){
			activeGodBonus.put(g, false);
			bonusDuration.put(g, 0);
		}
	}
	
	@Override
	public void initiate(){
		
	}
	/**
	 * Have a Character use their religious talent to lower another kingdom's religious following
	 * and lowering its effects.
	 * @param initiate
	 * @param target
	 * @return how many points target religion lowers
	 */
	public int declareHeathens(Characters initiate, Kingdom target){
		float chance = (float) (Math.random() % 100);
		if(chance >=0 && chance <=initiate.getFaith()/2){
			int magnitude = (int)(initiate.getFaith()/100 * 8);
			return magnitude;
		}
		
		return 0;
	}
	
	/**
	 * Use a talented religious/authority character to use their following to raise your leaders divine
	 * right to rule his/her people.  Effectively raises order and lowers corruption.
	 * @param initiate
	 * @param kingdom
	 * @return how many points religion rises.
	 */
	public int raiseDivine(Characters initiate){
		float chance = (float) (Math.random() % 100);
		if(chance >=0 && chance <= initiate.getFaith()/2 + initiate.getAuthority()/2){
			int magnitude = (int)(initiate.getFaith()/2 + initiate.getAuthority()/2 * 5);
			return magnitude;
		}
		return 0;
	}
	
	/**
	 * A character person with the Sacrifice Talent will be able to sacrifice a number of
	 * followers to a god of their choice.  That choice will give a chance to get a bonus temporary
	 * effect.
	 * @param initiate
	 * @param number
	 * @param godOfChoice
	 */
	public void organizeSacrifice(Characters initiate, int number, Religion.God godOfChoice){
		float chance = (float) (Math.random() % 100);
		if(chance >= 0 && chance < initiate.getFaith()){
			boolean bonus = false;
			/* check for critical which will give temporary bonus to god */
			if(chance >= 0 && chance < 15)
				bonus = true;
			if(number >= 1000)
				religionProgress += 1.0f/level;
			if(number >= 500)
				religionProgress += 0.5f/level;
			if(number >= 200)
				religionProgress += 0.15f/level;
			else {
				religionProgress +=0.5f/level;
			}
			if(bonus){
				religionProgress += 0.25f/level;
				if(!activeGodBonus.get(godOfChoice)){
					activeGodBonus.put(godOfChoice, true);
					bonusDuration.put(godOfChoice, 5);
				}
				
			}
			if(religionProgress >= 1.0f){
				religionProgress = religionProgress % 1.0f;
				level += 1;
				if(level > 20)
					level = 20;
			}
			
			
		}
		
	}
	
	/**
	 * Update to a kingdoms religion state after their turn has ended, checks for current bonuses
	 * and reduces their duration until 0 in which case it removes the bonus completely.
	 */
	public void updateReligion(){
		Set<Map.Entry<Religion.God, Integer>> bonuses = bonusDuration.entrySet();
		Iterator<Map.Entry<Religion.God, Integer>> itr = bonuses.iterator();
		while(itr.hasNext()){
			Map.Entry<Religion.God, Integer> itrGod = itr.next();
			if(itrGod.getValue() > 0){
				itrGod.setValue(itrGod.getValue()-1);
				if(activeGodBonus.get(itrGod.getKey()) == true && itrGod.getValue() == 0)
					activeGodBonus.put(itrGod.getKey(), false); 
			}
		}
	}
}
