package palacesoft.eclipseoftime;

import java.util.ArrayList;

import palacesoft.eclipseoftime.actions.Domestic;
import palacesoft.eclipseoftime.actions.Military;
import palacesoft.eclipseoftime.actions.Plot;
import palacesoft.eclipseoftime.actions.Politics;
import palacesoft.eclipseoftime.actions.Religion;
import palacesoft.eclipseoftime.actions.Treasury;
import palacesoft.eclipseoftime.baseobjects.AbstractFragment;
import palacesoft.eclipseoftime.customViews.CustomListView;
import palacesoft.eclipseoftime.models.Building;
import palacesoft.eclipseoftime.models.Characters;
import palacesoft.eclipseoftime.models.City;
import palacesoft.eclipseoftime.models.Kingdom;
import palacesoft.eclipseoftime.models.Player;
import palacesoft.eclipseoftime.models.Resource;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoScreen extends AbstractFragment{

	private FrameLayout finalLayout;
	private GameScreen gameScreen;
	/* military info ui */
	private LinearLayout militaryView;
	private LinearLayout soldiersHolder;
	private TextView soldierMsg;
	private TextView spearMsg;
	private TextView alquatlMsg;
	private TextView mahaquatlMsg;
	private TextView bowMsg;
	
	/* kingdom info ui */
	private LinearLayout kingdomView;
	private LinearLayout cityInfo1;
	private LinearLayout cityInfo2;
	private ImageView pyramidIcon;
	private ImageView wallIcon;
	private ImageView armoryIcon;
	private ImageView marketIcon;
	private ImageView templeIcon;
	
	private TextView goldMsg;
	private TextView orderMsg;
	private TextView popMsg;
	private TextView relicMsg;
	private TextView rubyMsg;
	private TextView stoneMsg;
	private TextView plantMsg;	
	
	/* roster info ui */
	private LinearLayout rosterView;
	private CustomListView rosterList;
	private ArrayList<Characters> charRoster;
	
	/* foreign info ui */
	private LinearLayout foreignView;
	private CustomListView foreignList;
	private ArrayList<Characters> leaderRoster;
	private ArrayList<Player> allPlayers;
	private ArrayList<Characters> allChars;
	
	/* disasters info ui */
	/* not yet implemented */
	
	public void hideAllViews(){
		militaryView.setVisibility(View.GONE);
		kingdomView.setVisibility(View.GONE);
		rosterView.setVisibility(View.GONE);
		foreignView.setVisibility(View.GONE);
		
	}
	
	public void showMilitaryInfo(){
		hideAllViews();
		militaryView.setVisibility(View.VISIBLE);
	}
	
	public void showKingdomInfo(){
		hideAllViews();
		kingdomView.setVisibility(View.VISIBLE);
	}
	
	public void showRosterInfo(){
		hideAllViews();
		rosterView.setVisibility(View.VISIBLE);
		fillRosterList();
	}
	
	public void showForeignInfo(){
		hideAllViews();
		foreignView.setVisibility(View.VISIBLE);
		fillForeignList();
	}
	
	public void showDisastersInfo(){
		
	}
	
	public InfoScreen getFragment(){
		InfoScreen newFrag = new InfoScreen();
		return newFrag;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		gameScreen = (GameScreen)getActivity();
		finalLayout = new FrameLayout(gameScreen);
		
		/* military info ui */
		militaryView = new LinearLayout(gameScreen);
		militaryView.setOrientation(LinearLayout.VERTICAL);
		soldierMsg = new TextView(gameScreen);
		soldierMsg.setText("Soldiers : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getSoldiers());
		spearMsg = new TextView(gameScreen);
		spearMsg.setText("Spears : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getSpears());
		alquatlMsg = new TextView(gameScreen);
		alquatlMsg.setText("Atlatls : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getAtlatls());
		mahaquatlMsg = new TextView(gameScreen);
		mahaquatlMsg.setText("Maquahuitls : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getMaquahuitls());
		bowMsg = new TextView(gameScreen);
		bowMsg.setText("Bows : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getBows());
		militaryView.addView(soldierMsg);
		militaryView.addView(spearMsg);
		militaryView.addView(alquatlMsg);
		militaryView.addView(mahaquatlMsg);
		militaryView.addView(bowMsg);
		finalLayout.addView(militaryView);
		
		/* kingdom info ui */
		kingdomView = new LinearLayout(gameScreen);
		kingdomView.setOrientation(LinearLayout.VERTICAL);
		cityInfo1 = new LinearLayout(gameScreen);
		cityInfo2 = new LinearLayout(gameScreen);
		pyramidIcon = new ImageView(gameScreen);
		wallIcon = new ImageView(gameScreen);
		armoryIcon = new ImageView(gameScreen);
		marketIcon = new ImageView(gameScreen);
		templeIcon = new ImageView(gameScreen);
		cityInfo1.addView(pyramidIcon);
		cityInfo1.addView(wallIcon);
		cityInfo2.addView(armoryIcon);
		cityInfo2.addView(templeIcon);
		
		goldMsg = new TextView(gameScreen);
		goldMsg.setText("Gold : " + + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getTreasury().getFunds());
		orderMsg = new TextView(gameScreen);
		orderMsg.setText("Order : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getOrder());
		popMsg = new TextView(gameScreen);
		popMsg.setText("Population : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getPopulation());
		relicMsg = new TextView(gameScreen);
		relicMsg.setText("Relics : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getRelics());
		rubyMsg = new TextView(gameScreen);
		rubyMsg.setText("Rubies : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getRubies());
		stoneMsg = new TextView(gameScreen);
		stoneMsg.setText("Stone : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getStone());
		plantMsg = new TextView(gameScreen);
		plantMsg.setText("Herbs : " + gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getHomeCity().getPlants());
		
		kingdomView.addView(cityInfo1);
		kingdomView.addView(cityInfo2);
		kingdomView.addView(goldMsg);
		kingdomView.addView(orderMsg);
		kingdomView.addView(popMsg);
		kingdomView.addView(relicMsg);
		kingdomView.addView(rubyMsg);
		kingdomView.addView(stoneMsg);
		kingdomView.addView(plantMsg);
		finalLayout.addView(kingdomView);
		
		/* roster info ui */
		rosterView = new LinearLayout(gameScreen);
		rosterView.setOrientation(LinearLayout.VERTICAL);
		charRoster = new ArrayList<Characters>();
		rosterList = new CustomListView(gameScreen, this, null);	
		rosterView.addView(rosterList.getView());
		finalLayout.addView(rosterView);
		
		/* foreign info ui */
		foreignView = new LinearLayout(gameScreen);
		foreignView.setOrientation(LinearLayout.VERTICAL);
		foreignList = new CustomListView(gameScreen, this, null);
		foreignView.addView(foreignList);
		finalLayout.addView(foreignView);
		
		hideAllViews();
		
	}

	@Override
	public void eligibilityScreenClick(int indexClicked) {
		if(foreignView.getVisibility() == View.VISIBLE){
			;
		}
		else if(rosterView.getVisibility() == View.VISIBLE){
			
		}
		
	}
	
	public void fillRosterList(){
		allChars = gameScreen.gameLoop.getTurnController().getCurrentPlayer().getKingdom().getCharacterRoster();
		Player currPlayer = gameScreen.gameLoop.getTurnController().getCurrentPlayer();
		ArrayList<ArrayList<String>> charString = new ArrayList<ArrayList<String>>();
		for(Characters x : allChars){
				ArrayList<String> rowString = new ArrayList<String>();
				rowString.add(x.getName());
				rowString.add(String.valueOf(x.getLoyalty()));
				rowString.add(String.valueOf(x.getStr()));
				rowString.add(String.valueOf(x.getAuthority()));
				rowString.add(String.valueOf(x.getCunning()));
				rowString.add(String.valueOf(x.getFaith()));
				rowString.add(String.valueOf(x.getWisdom()));
				charString.add(rowString);
		}
		foreignList.addContent(charString);
	}
	
	public void fillForeignList(){
		allPlayers = gameScreen.gameLoop.getTurnController().getAllPlayers();
		Player currPlayer = gameScreen.gameLoop.getTurnController().getCurrentPlayer();
		ArrayList<ArrayList<String>> playerString = new ArrayList<ArrayList<String>>();
		for(Player x : allPlayers){
			if(x != currPlayer){
				ArrayList<String> rowString = new ArrayList<String>();
				rowString.add(x.getName());
				rowString.add(x.getKingdom().getKingdomName());
				rowString.add(x.getKingdom().getRuler().getName());
				rowString.add(String.valueOf(x.getKingdom().getPolitics().getForeignStanding(currPlayer.getKingdom())));
				playerString.add(rowString);
			}
		}
		foreignList.addContent(playerString);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return finalLayout;
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	
	
}
