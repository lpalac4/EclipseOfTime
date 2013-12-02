package palacesoft.eclipseoftime.models;

import java.util.ArrayList;

/**
 * The CombatController evaluates two or more sides that fight
 * @author DaPalacios
 *
 */
public class CombatController {

	private int handicap;
	private ArrayList<ArrayList<Kingdom>> sidesInvolved; 
	
	public CombatController(){
		handicap = 0;
		sidesInvolved = new ArrayList<ArrayList<Kingdom>>();
	}
	
	public ArrayList<Force> initiateCombat(ArrayList<Force> sideA, ArrayList<Force> sideB){
		
		int totalStrengthA = 0;
		int totalStrengthB = 0;
		
		for(Force f : sideA){
			totalStrengthA += f.getForceStrength();
		}
		
		for(Force f: sideB){
			totalStrengthB += f.getForceStrength();
		}
		
		if(totalStrengthA > totalStrengthB)
			return sideA;
		if(totalStrengthA < totalStrengthB)
			return sideB;
		else{
			if((Math.random() * totalStrengthA) < (Math.random() * totalStrengthB))
				return sideB;
			else 
				return sideA;
		}
	}
	
	/**
	 * Getters and setters*********************************
	 */
	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	
	
	
	
}
