package palacesoft.eclipseoftime.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.Kingdom;
import palacesoft.eclipseoftime.models.Building.BuildingType;
import palacesoft.eclipseoftime.models.Weapon.WeaponType;

/**
 * The Domestic class inherits from Action and encapsulates all moves related to the domestic side of Kingdom management.  Domestic actions include
 * assigning characters to work the fields, or repair the dam, and build orders.
 * @author DaPalacios
 *
 */
public class Domestic extends Action {

	private Characters[] charsOnFarm = {null, null, null};
	private Characters[] charsOnDam = {null, null, null};
	private ArrayList<WeaponsmithTuple> charsBuildingWeapons;
	private ArrayList<MasonTuple> charsBuildingBuildings;
	
	/**
	 * Tuple classes as helper classes public to everyone
	 * @author DaPalacios
	 */
	public class WeaponsmithTuple{
		public Characters smith;
		public int count;
		public WeaponType typeOfWeapon;
		public int numberMade;
		
		public WeaponsmithTuple(Characters ch, int c, WeaponType type){
			smith = ch;
			count = c;
			typeOfWeapon = type;
			numberMade = 0;
		}
	}
	
	public class MasonTuple{
		public Characters mason;
		public BuildingType buildingType;
		public int progress;
		
		public MasonTuple(Characters ch, BuildingType type){
			mason = ch;
			buildingType = type;
			progress = 0;
		}
	}
	
	public Domestic(){
		kingdom = null;
		charsBuildingBuildings = new ArrayList<MasonTuple>();
		charsBuildingWeapons = new ArrayList<WeaponsmithTuple>();
	}
	
	public Domestic(Kingdom k) {
		kingdom = k;
		charsBuildingBuildings = new ArrayList<MasonTuple>();
		charsBuildingWeapons = new ArrayList<WeaponsmithTuple>();
		
	}
	
	@Override
	public void initiate(){
		//do something not sure
	}
	
	public void developFarmland(Characters[] chars){
		if(chars.length != 3)
			//we have a prob
		charsOnFarm = chars;
	}
	
	public void reinforceDam(Characters[] chars){
		if(chars.length != 3)
			//we have a prob
		charsOnDam = chars;
	}
	
	public void addWeaponBuilder(WeaponsmithTuple wsTuple){
		charsBuildingWeapons.add(wsTuple);
		wsTuple.smith.setCommited(true);
		
	}
	
	public void addBuildingBuilder(MasonTuple msTuple){
		charsBuildingBuildings.add(msTuple);
		msTuple.mason.setCommited(true);
	}
	
	/**
	 * After every turn the changes to a kingdoms statistics will go into effect
	 * Currently needs testing but the jist of it is that 
	 */
	public void calculateUpgrades(){
		int totalFarm = 0;
		int totalDam = 0;
		int totalWeaponBuild = 0;
		int totalBuildingProgress = 0;
		
		for(Characters x : charsOnFarm){
			if(x == null){
				continue;
			}
			totalFarm += ((int)(x.getWisdom() * 0.8) + x.getAuthority()) >> 1;
		}
		
		totalFarm /= 20;
		kingdom.getHomeCity().setFarmland(kingdom.getHomeCity().getFarmland() + totalFarm);
		
		for(Characters x : charsOnDam){
			if(x == null){
				continue;
			}
			
			totalDam += ((int)(x.getWisdom() * 0.8) + x.getAuthority()) >> 1;
		}
		
		totalDam /= 20;
		kingdom.getHomeCity().setDam(kingdom.getHomeCity().getDam() + totalDam);
		
		for(MasonTuple msT : charsBuildingBuildings){
			totalBuildingProgress += ((int)(msT.mason.getAuthority() * 0.8) + msT.mason.getWisdom()) >> 1;
			totalBuildingProgress *= 30;
			msT.progress += totalBuildingProgress;
			if(msT.progress >= 100)
				masonryCompleted(msT);
			totalBuildingProgress = 0;
		}
		
		for(WeaponsmithTuple wsT : charsBuildingWeapons){
			totalWeaponBuild += ((int)(wsT.smith.getAuthority() * 0.8) + wsT.smith.getWisdom()) >> 1;
			totalWeaponBuild /= 20;
			wsT.numberMade += totalWeaponBuild;
			if(wsT.numberMade >= wsT.count)
				weaponsmithFinished(wsT);
			totalWeaponBuild = 0;
		}
		
		
	}
	
	/**
	 * During calculateUpgrades if any weaponsmith projects are completed they are pooled for completion here.
	 * @param mst
	 */
	private void weaponsmithFinished(WeaponsmithTuple wsT) {
		wsT.smith.setCommited(false);
		
	}

	/**
	 * During calculateUpgrades if any masonry projects are completed they are pooled for completion here.
	 * @param mst
	 */
	public void masonryCompleted(MasonTuple mst){
		mst.mason.setCommited(false);
	}
	
	
	
	

}
