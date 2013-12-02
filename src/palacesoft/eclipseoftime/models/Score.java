package palacesoft.eclipseoftime.models;


/**
 * The Score class encapsulates all calculations for a player's score
 * @author DaPalacios
 *
 */
public class Score {

	private Player player;
	private int militaryScore;
	private int socialScore;
	private int religiousScore;
	private int totalScore;
	private int cunningScore;
	
	
	public Score(){
		player = null;
		militaryScore = 0;
		socialScore = 0;
		religiousScore = 0;
		cunningScore = 0;
		totalScore = 0;
		
	}
	
	public Score(Player pl){
		player = pl;
		militaryScore = 0;
		socialScore = 0;
		religiousScore = 0;
		cunningScore = 0;
		totalScore = 0;
	}
	
	public void calculateTotalScore(){
		totalScore = militaryScore + socialScore + religiousScore + cunningScore;
		switch(player.getDifficulty()){
		case EASY:
			totalScore = (int) (totalScore * 0.5);
			break;
		case MEDIUM:
			totalScore = (int) (totalScore * 0.7);
			break;
		case HARD:
			totalScore = (int) (totalScore * 0.9);
			break;
			
		}
		
	}

	/**
	 * Getters and setters ***********************************************
	 */
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getMilitaryScore() {
		return militaryScore;
	}

	public void setMilitaryScore(int militaryScore) {
		this.militaryScore = militaryScore;
	}

	public int getSocialScore() {
		return socialScore;
	}

	public void setSocialScore(int socialScore) {
		this.socialScore = socialScore;
	}

	public int getReligiousScore() {
		return religiousScore;
	}

	public void setReligiousScore(int religiousScore) {
		this.religiousScore = religiousScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getCunningScore() {
		return cunningScore;
	}

	public void setCunningScore(int cunningScore) {
		this.cunningScore = cunningScore;
	}
	
	
	
	
}
