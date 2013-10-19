package palacesoft.lostundertheshade.core;


/**
 * Player class is the base class for all players and their kingdoms.
 * @author DaPalacios
 *
 */
public class Player {
	
	private Kingdom kingdom;
	private int AP;
	private Score score;
	private LoyaltySystem loyaltysys;
	private Council council;
	private String name;
	private boolean isAI;
	public static enum Difficulty{
		EASY,
		MEDIUM,
		HARD
	};
	
	private Difficulty difficulty;

	public Player(){
		kingdom = new Kingdom();
		AP = 100;
		score = new Score();
		loyaltysys = new LoyaltySystem();
		council = new Council();
		name = "";
		isAI = false;
		difficulty = Difficulty.MEDIUM;
	}
	
	public Player(String name, Difficulty diff){
		this.name = name;
		difficulty = diff;
		kingdom = new Kingdom();
		AP = 100;
		score = new Score();
		loyaltysys = new LoyaltySystem();
		council = new Council();
		isAI = false;
		
	}
	
	/**
	 *Actions that a player can take. 
	 */

	public void initiateDomestic(){
		
	}
	
	public void initiateMilitary(){
		
	}
	
	public void initiatePlot(){
		
	}
	
	public void initiateReligion(){
		
	}
	
	public void initiateTreasury(){
		
	}

	/**
	 * Getters and setters *******************************************
	 *
	 */
	
	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAI() {
		return isAI;
	}

	public void setAI(boolean isAI) {
		this.isAI = isAI;
	}

	
	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public int getAP() {
		return AP;
	}

	public void setAP(int aP) {
		AP = aP;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public LoyaltySystem getLoyaltysys() {
		return loyaltysys;
	}

	public void setLoyaltysys(LoyaltySystem loyaltysys) {
		this.loyaltysys = loyaltysys;
	}

	public Council getCouncil() {
		return council;
	}

	public void setCouncil(Council council) {
		this.council = council;
	}
	
}
