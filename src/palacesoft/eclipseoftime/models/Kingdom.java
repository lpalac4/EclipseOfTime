package palacesoft.eclipseoftime.models;

import java.util.ArrayList;

import palacesoft.eclipseoftime.actions.Domestic;
import palacesoft.eclipseoftime.actions.Military;
import palacesoft.eclipseoftime.actions.Plot;
import palacesoft.eclipseoftime.actions.Politics;
import palacesoft.eclipseoftime.actions.Religion;
import palacesoft.eclipseoftime.actions.Treasury;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

/**
 * The Kingdom class is an abstract faction within the game.  A player will control one faction within the game.
 * @author DaPalacios
 *
 */
public class Kingdom {

	private Player player;
	private Characters Ruler;
	private String kingdomName;
	private ArrayList<Kingdom> allies;
	private ArrayList<Kingdom> enemies;
	private ArrayList<Kingdom> capitulatedEnemies;
	private ArrayList<Characters> characterRoster;
	private ImageView sigil;
	private Activity activity;

	private City homeCity;
	private Treasury treasury;
	private Domestic domestic;
	private Military military;
	private Religion religion;
	private Plot plot;
	private Politics politics;
	
	/**
	 * Default constructor
	 */
	public Kingdom(){
		player = new Player();
		Ruler = new Characters();
		kingdomName = "";
		allies = new ArrayList<Kingdom>();
		enemies = new ArrayList<Kingdom>();
		capitulatedEnemies = new ArrayList<Kingdom>();
		characterRoster = new ArrayList<Characters>();
		sigil = new ImageView(null);
		
		treasury = new Treasury();
		domestic = new Domestic();
		military = new Military();
		religion = new Religion();
		plot = new Plot();
		politics = new Politics();
		homeCity = new City();
	}
	
	/**
	 * Standard constructor with parameters for key member variables
	 * @param rulerName
	 * @param rulerImage
	 * @param kingdomName
	 * @param sigilImage
	 * @param activityContext
	 */
	public Kingdom(Context context, Player playerName, String rulerName, ImageView rulerImage, String kingdomName, ImageView sigilImage, Activity activityContext){
		player = playerName;
		Ruler = new Characters(rulerName, rulerImage, this, context);
		this.kingdomName = kingdomName;
		sigil = sigilImage;
		allies = new ArrayList<Kingdom>();
		enemies = new ArrayList<Kingdom>();
		capitulatedEnemies = new ArrayList<Kingdom>();
		characterRoster = new ArrayList<Characters>();
		activity = activityContext;
		
		treasury = new Treasury(this);
		domestic = new Domestic(this);
		military = new Military(this);
		religion = new Religion(this);
		plot = new Plot(this);
		politics = new Politics(this);
		homeCity = null;
	}
	
	
	/*
	 * Getters and Setters********************************************************************************************
	 */
	public Characters getRuler() {
		return Ruler;
	}
	public void setRuler(Characters ruler) {
		Ruler = ruler;
	}
	public String getKingdomName() {
		return kingdomName;
	}
	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
	}
	public ArrayList<Kingdom> getAllies() {
		return allies;
	}
	public void setAllies(ArrayList<Kingdom> allies) {
		this.allies = allies;
	}
	public ArrayList<Kingdom> getEnemies() {
		return enemies;
	}
	public void setEnemies(ArrayList<Kingdom> enemies) {
		this.enemies = enemies;
	}
	public ArrayList<Kingdom> getCapitulatedEnemies() {
		return capitulatedEnemies;
	}
	public void setCapitulatedEnemies(ArrayList<Kingdom> capitulatedEnemies) {
		this.capitulatedEnemies = capitulatedEnemies;
	}
	public ArrayList<Characters> getCharacterRoster() {
		return characterRoster;
	}
	public void setCharacters(ArrayList<Characters> characterRoster) {
		this.characterRoster = characterRoster;
	}
	public ImageView getSigil() {
		return sigil;
	}
	public void setSigil(ImageView sigil) {
		this.sigil = sigil;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public City getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(City homeCity) {
		this.homeCity = homeCity;
	}

	public Treasury getTreasury() {
		return treasury;
	}

	public void setTreasury(Treasury treasury) {
		this.treasury = treasury;
	}

	public Domestic getDomestic() {
		return domestic;
	}

	public void setDomestic(Domestic domestic) {
		this.domestic = domestic;
	}

	public Military getMilitary() {
		return military;
	}

	public void setMilitary(Military military) {
		this.military = military;
	}

	public Religion getReligion() {
		return religion;
	}

	public void setReligion(Religion religion) {
		this.religion = religion;
	}

	public Plot getPlot() {
		return plot;
	}

	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	public Politics getPolitics() {
		return politics;
	}

	public void setPolitics(Politics politics) {
		this.politics = politics;
	}

	public void setCharacterRoster(ArrayList<Characters> characterRoster) {
		this.characterRoster = characterRoster;
	}

	
	
}
