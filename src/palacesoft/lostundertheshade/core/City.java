package palacesoft.lostundertheshade.core;

import java.util.ArrayList;

/**
 * City class represents a city in the Kingdom ruled by a player
 * @author DaPalacios
 */
public class City extends Building{
	
	private Player ruler;
	private Building wall;
	private Building pyramid;
	private Building armory;
	private Building market;
	private Building temple;
	private int order;
	private int population;
	private ArrayList<Resource> resources;
	private int farmland;
	private int dam;
	private int economy;
	private int craftsmanship;
	
	public City(){
		ruler = null;
		wall = null;
		pyramid = null;
		armory = null;
		market = null;
		temple = null;
		order = 50;
		population = 10;
		farmland = 1;
		dam = 1;
		economy = 1;
		craftsmanship = 1;
		resources = new ArrayList<Resource>();
	}
	
	public void addNewResource(Resource res){
		resources.add(res);
	}
	
	public void removeResource(Resource res){
		resources.remove(res);
	}
	
	/**
	 * Getters and setters ******************************************
	 */

	
	
	
	public Player getRuler() {
		return ruler;
	}
	public int getFarmland() {
		return farmland;
	}

	public void setFarmland(int farmland) {
		this.farmland = farmland;
	}

	public int getDam() {
		return dam;
	}

	public void setDam(int dam) {
		this.dam = dam;
	}

	public int getEconomy() {
		return economy;
	}

	public void setEconomy(int economy) {
		this.economy = economy;
	}

	public int getCraftsmanship() {
		return craftsmanship;
	}

	public void setCraftsmanship(int craftsmanship) {
		this.craftsmanship = craftsmanship;
	}

	public ArrayList<Resource> getResources() {
		return resources;
	}


	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}

	public void setRuler(Player ruler) {
		this.ruler = ruler;
	}
	public Building getWall() {
		return wall;
	}
	public void setWall(Building wall) {
		this.wall = wall;
	}
	public Building getPyramid() {
		return pyramid;
	}
	public void setPyramid(Building pyramid) {
		this.pyramid = pyramid;
	}
	public Building getArmory() {
		return armory;
	}
	public void setArmory(Building armory) {
		this.armory = armory;
	}
	public Building getMarket() {
		return market;
	}
	public void setMarket(Building market) {
		this.market = market;
	}
	public Building getTemple() {
		return temple;
	}
	public void setTemple(Building temple) {
		this.temple = temple;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	
	
}
