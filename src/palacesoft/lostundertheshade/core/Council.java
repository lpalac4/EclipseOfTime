package palacesoft.lostundertheshade.core;

public class Council {
	
	private Character masterOfCoin;
	private Character warchief;
	private Character highPriest;
	private Character masterOfShadows;
	private Character rulersFist;
	
	public Council(){
		masterOfCoin = null;
		warchief = null;
		highPriest = null;
		masterOfShadows = null;
		rulersFist = null;
	}
	
	
	/**
	 * Getters and setters *****************************************
	 */
	
	public Character getMasterOfCoin() {
		return masterOfCoin;
	}



	public void setMasterOfCoin(Character masterOfCoin) {
		this.masterOfCoin = masterOfCoin;
	}



	public Character getWarchief() {
		return warchief;
	}



	public void setWarchief(Character warchief) {
		this.warchief = warchief;
	}



	public Character getHighPriest() {
		return highPriest;
	}



	public void setHighPriest(Character highPriest) {
		this.highPriest = highPriest;
	}



	public Character getMasterOfShadows() {
		return masterOfShadows;
	}



	public void setMasterOfShadows(Character masterOfShadows) {
		this.masterOfShadows = masterOfShadows;
	}



	public Character getRulersFist() {
		return rulersFist;
	}



	public void setRulersFist(Character rulersFist) {
		this.rulersFist = rulersFist;
	}
	
}
