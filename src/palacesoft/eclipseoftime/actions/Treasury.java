package palacesoft.eclipseoftime.actions;

import palacesoft.eclipseoftime.baseobjects.Action;
import palacesoft.eclipseoftime.models.City;
import palacesoft.eclipseoftime.models.Kingdom;
import palacesoft.eclipseoftime.models.Resource;

public class Treasury extends Action{

	private int treasuryCount;
	private Resource rubies;
	private Resource stone;
	private Resource plants;
	private Resource relics;
	private int income;
	private int costs;
	private int taxPayers;
	private float taxLevel;
	private float corruption;
	private int cityMaintenance;
	
	public Treasury(){
		rubies = new Resource(Resource.ResourceType.RUBIES, 0);
		stone = new Resource(Resource.ResourceType.STONE, 0);
		plants = new Resource(Resource.ResourceType.POISON_PLANT, 0);
		relics = new Resource(Resource.ResourceType.ANCIENT_RELIC, 0);
		treasuryCount = 0;
		income = 1;
		costs = 0;
		taxPayers = 1;
		corruption = 0;
		cityMaintenance = 0;
		
	}
	
	public Treasury(Kingdom kingdom) {
		City city = kingdom.getHomeCity();
		rubies = new Resource(Resource.ResourceType.RUBIES, city.getRelics());
		stone = new Resource(Resource.ResourceType.STONE, city.getStone());
		plants = new Resource(Resource.ResourceType.POISON_PLANT, city.getPlants());
		relics = new Resource(Resource.ResourceType.ANCIENT_RELIC, city.getRelics());
		treasuryCount = 10;
		taxLevel = 0.5f;
		taxPayers = city.getPopulation();
		corruption = 1.0f - city.getOrder()/taxPayers;
		cityMaintenance = city.getPopulation() - city.getEconomy();
		collect();
	}
	
	@Override
	public void initiate(){
		
	}

	public int getFunds() {
		return getTreasuryCount();
	}
	
	public void collect(){
		income = rubies.getSupply() + relics.getSupply() + (int)(taxLevel * taxPayers);
		costs = (int)(cityMaintenance * (1.0 + corruption));
		treasuryCount += income - costs;
	}

	/**
	 * Getters and setters ****************************
	 */
	public int getTreasuryCount() {
		return treasuryCount;
	}

	public void setTreasuryCount(int treasuryCount) {
		this.treasuryCount = treasuryCount;
	}

	public Resource getRubies() {
		return rubies;
	}

	public void setRubies(Resource rubies) {
		this.rubies = rubies;
	}

	public Resource getStone() {
		return stone;
	}

	public void setStone(Resource stone) {
		this.stone = stone;
	}

	public Resource getPlants() {
		return plants;
	}

	public void setPlants(Resource plants) {
		this.plants = plants;
	}

	public Resource getRelics() {
		return relics;
	}

	public void setRelics(Resource relics) {
		this.relics = relics;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getCosts() {
		return costs;
	}

	public void setCosts(int costs) {
		this.costs = costs;
	}

	public int getTaxPayers() {
		return taxPayers;
	}

	public void setTaxPayers(int taxPayers) {
		this.taxPayers = taxPayers;
	}

	public float getTaxLevel() {
		return taxLevel;
	}

	public void setTaxLevel(float taxLevel) {
		this.taxLevel = taxLevel;
	}

	public float getCorruption() {
		return corruption;
	}

	public void setCorruption(float corruption) {
		this.corruption = corruption;
	}

	public int getCityMaintenance() {
		return cityMaintenance;
	}

	public void setCityMaintenance(int cityMaintenance) {
		this.cityMaintenance = cityMaintenance;
	}

}
