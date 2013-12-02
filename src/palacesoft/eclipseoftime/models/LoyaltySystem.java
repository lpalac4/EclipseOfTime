package palacesoft.eclipseoftime.models;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Pair;

/**
 * The LoyaltySystem class will control how others players and city populations view your rule.
 * @author DaPalacios
 */
public class LoyaltySystem {
	
	private int fearMeter; // 0 : 100
	private int loveMeter; // 0 : 100
	private int honorMeter; // 0 : 50
	private Kingdom kingdom;
	
	

	public LoyaltySystem(){
		kingdom = null;
		fearMeter = 50;
		loveMeter = 50;
		honorMeter = 0;
		
	
	}
	
	public LoyaltySystem(Kingdom kingdomptr){
		kingdom = kingdomptr;
		fearMeter = 50;
		loveMeter = 50;
		honorMeter = 0;

	}
	
	public int populationsFeeling(Kingdom kingdompop){
		int cityOrder = kingdompop.getHomeCity().getOrder();
		int popfeel = ((cityOrder * fearMeter) + (cityOrder * loveMeter) + (cityOrder * honorMeter))/3;
		return popfeel;
	}
	
	public int rulerFeeling(Player player){
		int opponentAggression = player.getLoyaltysys().getFearMeter() - (player.getLoyaltysys().getHonorMeter() 
										+ player.getLoyaltysys().getLoveMeter());
		int opponentMilitary = player.getKingdom().getMilitary().getTotalStrength();
		
		int yourMilitary = kingdom.getMilitary().getTotalStrength(); //max : 30
		int yourAggression = fearMeter - (loveMeter + honorMeter);
		
		int feeling = (yourAggression/opponentAggression) * (yourMilitary - opponentMilitary); // 0 : 30
		
		if(player.getKingdom().getAllies().contains(this.kingdom))
			feeling += 5;
		if(player.getKingdom().getEnemies().contains(this.kingdom))
			feeling -= 10;
		
		if(feeling > 30) 
			feeling = 30;
		if(feeling < 0)
			feeling = 0;
		
		return feeling;
		
	}
	
	public int initiateSubordinateLoyalty(Characters character){
		int loyalty = 100;
		if(character.getHonor() - getHonorMeter() > 20)
			loyalty -= 5;
		if(character.getHonor() - getHonorMeter() > 40)
			loyalty -= 15;
		
		if(loveMeter < 50)
			loyalty -= 5;
		
		if(fearMeter > 70)
			loyalty -= 5;
			
		return loyalty;
	}
	
	public void meterChecks(){
		if(fearMeter > 100)
			fearMeter = 100;
		if(fearMeter < 0)
			fearMeter = 0;
		
		if(loveMeter > 100)
			loveMeter = 100;
		if(loveMeter < 0)
			loveMeter = 0;
		
		if(honorMeter > 50)
			honorMeter = 50;
		if(honorMeter < -50)
			honorMeter = -50;
		
	
	}
	
	public void adjustFear(int change){
		fearMeter += change;
		meterChecks();
	}
	
	public void adjustLove(int change){
		loveMeter += change;
		meterChecks();
	}
	
	public void adjustHonor(int change){
		honorMeter += change;
		meterChecks();
	}
	
	public int getFearMeter() {
		return fearMeter;
	}

	public void setFearMeter(int fearMeter) {
		this.fearMeter = fearMeter;
		meterChecks();
	}

	public int getLoveMeter() {
		return loveMeter;
	}

	public void setLoveMeter(int loveMeter) {
		this.loveMeter = loveMeter;
		meterChecks();
	}

	public int getHonorMeter() {
		return honorMeter;
	}

	public void setHonorMeter(int honorMeter) {
		this.honorMeter = honorMeter;
		meterChecks();
	}
	
	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

}
