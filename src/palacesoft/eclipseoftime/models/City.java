package palacesoft.eclipseoftime.models;

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
	private int population; // 1:20
	private ArrayList<Resource> resources;
	private int farmland;
	private int dam;
	private int economy;
	private int craftsmanship;
	private ArrayList<Characters> inhabitants;
	private int soldiers;
	private int normalClubs;
	private int spears;
	private int bows;
	private int atlatls;
	private int maquahuitls;
	private int relics;
	private int rubies;
	private int stone;
	private int plants;
	
	public City(){
		ruler = null;
		wall = null;
		pyramid = null;
		armory = null;
		market = null;
		temple = null;
		order = 1;
		population = 1;
		farmland = 1;
		dam = 1;
		economy = 1;
		craftsmanship = 1;
		resources = new ArrayList<Resource>();
		inhabitants = new ArrayList<Characters>();
		normalClubs = 0;
		bows = 0;
		atlatls = 0;
		maquahuitls = 0;
		soldiers = 1;
	}
	
	public void addNewResource(Resource res){
		resources.add(res);
	}
	
	public void removeResource(Resource res){
		resources.remove(res);
	}
	
	public void adjustOrder(int damage) {
		// TODO Auto-generated method stub
		
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

	public ArrayList<Characters> getInhabitants() {
		return inhabitants;
	}

	public void setInhabitants(ArrayList<Characters> inhabitants) {
		this.inhabitants = inhabitants;
	}

	public int getNormalClubs() {
		return normalClubs;
	}

	public void setNormalClubs(int normalClubs) {
		this.normalClubs = normalClubs;
	}

	public int getSpears() {
		return spears;
	}

	public void setSpears(int spears) {
		this.spears = spears;
	}

	public int getBows() {
		return bows;
	}

	public void setBows(int bows) {
		this.bows = bows;
	}

	public int getAtlatls() {
		return atlatls;
	}

	public void setAtlatls(int atlatls) {
		this.atlatls = atlatls;
	}

	public int getMaquahuitls() {
		return maquahuitls;
	}

	public void setMaquahuitls(int maquahuitls) {
		this.maquahuitls = maquahuitls;
	}

	public void burnWeapons(int damage) {
		// TODO Auto-generated method stub
		
	}

	public void destroyFood(int damage) {
		// TODO Auto-generated method stub
		
	}

	public int getRelics() {
		return relics;
	}

	public void setRelics(int relics) {
		this.relics = relics;
	}

	public int getRubies() {
		return rubies;
	}

	public void setRubies(int rubies) {
		this.rubies = rubies;
	}

	public int getStone() {
		return stone;
	}

	public void setStone(int stone) {
		this.stone = stone;
	}

	public int getPlants() {
		return plants;
	}

	public void setPlants(int plants) {
		this.plants = plants;
	}

	public int getSoldiers() {
		return soldiers;
	}

	public void setSoldiers(int soldiers) {
		this.soldiers = soldiers;
	}
	
	
	
	
}
