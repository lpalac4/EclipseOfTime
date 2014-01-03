package palacesoft.eclipseoftime;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class PlotScreen extends Fragment {
	
	private FrameLayout finalLayout;
	private GameScreen gameScreen;
	
	private LinearLayout riotView;
	private ScrollView riotTargetCityScroll;
	private LinearLayout riotTargetCityLinear;
	private EligibilityScreen riotTargetList;
	private Button continueRiot;
	private TextView riotMsg;
	
	private LinearLayout scandalView;
	private TextView scandalMsg;
	private ScrollView scandalTargetScroll;
	private LinearLayout scandalTargetLinear;
	private EligibilityScreen scandalTargetList;
	private Button continueScandal;
	
	private LinearLayout assassinateView;
	private TextView assassinateMsg;
	private ScrollView assassinateTargetScroll;
	private LinearLayout assassinateTargetLinear;
	private EligibilityScreen assassinateTargetList;
	private Button continueAssassinate;
	
	private LinearLayout sabotageView;
	private TextView sabotageMsg;
	private ScrollView sabotageTargetScroll;
	private LinearLayout sabotageTargetLinear;
	private EligibilityScreen sabotageTargetList;
	private Button continueSabotage;
	
	private LinearLayout arsonView;
	private TextView arsonMsg;
	private ScrollView arsonTargetScroll;
	private LinearLayout arsonTargetLinear;
	private EligibilityScreen arsonTargetList;
	private Button continueArson;
	
	public PlotScreen getFragment(){
		PlotScreen newFrag = new PlotScreen();
		return newFrag;
	}
	
	public void hideAllViews(){
		riotView.setVisibility(View.GONE);
		scandalView.setVisibility(View.GONE);
		assassinateView.setVisibility(View.GONE);
		sabotageView.setVisibility(View.GONE);
		arsonView.setVisibility(View.GONE);		
	}
	
	public void showArsonView(){
		hideAllViews();
		arsonView.setVisibility(View.VISIBLE);
	}
	
	public void showSabotageView(){
		hideAllViews();
		sabotageView.setVisibility(View.VISIBLE);
	}
	
	public void showAssassinateView(){
		hideAllViews();
		assassinateView.setVisibility(View.VISIBLE);
	}
	
	public void showScandalView(){
		hideAllViews();
		scandalView.setVisibility(View.VISIBLE);
	}
	
	public void showRiotView(){
		hideAllViews();
		riotView.setVisibility(View.VISIBLE);
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		gameScreen = (GameScreen)getActivity();
		finalLayout = new FrameLayout(gameScreen);
		FragmentTransaction fTrans;
		
		scandalView = new LinearLayout(gameScreen);
		scandalView.setOrientation(LinearLayout.VERTICAL);
		scandalMsg = new TextView(gameScreen);
		scandalMsg.setText("Choose the leader to target");
		scandalTargetLinear = new LinearLayout(gameScreen);
		scandalTargetLinear.setOrientation(LinearLayout.VERTICAL);
		scandalTargetLinear.setId(14);
		scandalTargetScroll = new ScrollView(gameScreen);
		continueScandal = new Button(gameScreen);
		continueScandal.setText("Continue");
		continueScandal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		fTrans = gameScreen.getSupportFragmentManager().beginTransaction();
		scandalTargetList = new EligibilityScreen();
		fTrans.add(scandalTargetLinear.getId(), scandalTargetList, "Scandal Target List");
		fTrans.commit();
		scandalTargetScroll.addView(scandalTargetLinear);
		scandalView.addView(scandalMsg);
		scandalView.addView(scandalTargetScroll);
		scandalView.addView(continueScandal);
		
		
		riotView = new LinearLayout(gameScreen);
		riotView.setOrientation(LinearLayout.VERTICAL);
		riotMsg = new TextView(gameScreen);
		riotMsg.setText("In what city will you spread violence in");
		riotTargetCityLinear = new LinearLayout(gameScreen);
		riotTargetCityLinear.setOrientation(LinearLayout.VERTICAL);
		riotTargetCityLinear.setId(13);
		riotTargetCityScroll = new ScrollView(gameScreen);
		continueRiot = new Button(gameScreen);
		continueRiot.setText("Continue");
		continueRiot.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				gameScreen.showEligibilityScreen();				
			}
		});
		fTrans = gameScreen.getSupportFragmentManager().beginTransaction();
		riotTargetList = new EligibilityScreen();
		fTrans.add(riotTargetCityLinear.getId(), riotTargetList, "Riot Target List");
		fTrans.commit();
		riotTargetCityScroll.addView(riotTargetCityLinear);
		riotView.addView(riotMsg);
		riotView.addView(riotTargetCityScroll);
		riotView.addView(continueRiot);   

		assassinateView = new LinearLayout(gameScreen);
		assassinateView.setOrientation(LinearLayout.VERTICAL);
		assassinateMsg = new TextView(gameScreen);
		assassinateMsg.setText("Choose the leader to assassinate");
		assassinateTargetLinear = new LinearLayout(gameScreen);
		assassinateTargetLinear.setOrientation(LinearLayout.VERTICAL);
		assassinateTargetLinear.setId(10);
		assassinateTargetScroll = new ScrollView(gameScreen);
		continueAssassinate = new Button(gameScreen);
		continueAssassinate.setText("Continue");
		continueAssassinate.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				gameScreen.showEligibilityScreen();				
			}
		});
		fTrans = gameScreen.getSupportFragmentManager().beginTransaction();
		assassinateTargetList = new EligibilityScreen();
		fTrans.add(assassinateTargetLinear.getId(), assassinateTargetList, "Assassinate Target List");
		fTrans.commit();
		assassinateTargetScroll.addView(assassinateTargetLinear);
		assassinateView.addView(assassinateMsg);
		assassinateView.addView(assassinateTargetScroll);
		assassinateView.addView(continueAssassinate);
		
		sabotageView = new LinearLayout(gameScreen);
		sabotageView.setOrientation(LinearLayout.VERTICAL);
		sabotageMsg = new TextView(gameScreen);
		sabotageMsg.setText("Choose the city whose production to sabotage");
		sabotageTargetLinear = new LinearLayout(gameScreen);
		sabotageTargetLinear.setOrientation(LinearLayout.VERTICAL);
		sabotageTargetLinear.setId(11);
		sabotageTargetScroll = new ScrollView(gameScreen);
		continueSabotage = new Button(gameScreen);
		continueSabotage.setText("Continue");
		continueSabotage.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				gameScreen.showEligibilityScreen();				
			}
		});
		fTrans = gameScreen.getSupportFragmentManager().beginTransaction();
		sabotageTargetList = new EligibilityScreen();
		fTrans.add(sabotageTargetLinear.getId(), sabotageTargetList, "Sabotage Target List");
		fTrans.commit();
		sabotageTargetScroll.addView(sabotageTargetLinear);
		sabotageView.addView(sabotageMsg);
		sabotageView.addView(sabotageTargetScroll);
		sabotageView.addView(continueSabotage);
		
		arsonView = new LinearLayout(gameScreen);
		arsonView.setOrientation(LinearLayout.VERTICAL);
		arsonMsg = new TextView(gameScreen);
		arsonMsg.setText("Choose the city and the arson target");
		LinearLayout arsonChoice = new LinearLayout(gameScreen);
		Button arsonFoodButton = new Button(gameScreen);
		arsonFoodButton.setText("Food");
		Button arsonWeaponButton = new Button(gameScreen);
		arsonWeaponButton.setText("Weapons");
		arsonChoice.addView(arsonFoodButton);
		arsonChoice.addView(arsonWeaponButton);
		arsonTargetLinear = new LinearLayout(gameScreen);
		arsonTargetLinear.setOrientation(LinearLayout.VERTICAL);
		arsonTargetLinear.setId(12);
		arsonTargetScroll = new ScrollView(gameScreen);
		continueArson= new Button(gameScreen);
		continueArson.setText("Continue");
		continueArson.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				gameScreen.showEligibilityScreen();				
			}
		});
		fTrans = gameScreen.getSupportFragmentManager().beginTransaction();
		arsonTargetList = new EligibilityScreen();
		fTrans.add(arsonTargetLinear.getId(), arsonTargetList, "Arson Target List");
		fTrans.commit();
		arsonTargetScroll.addView(arsonTargetLinear);
		arsonView.addView(arsonMsg);
		arsonView.addView(arsonChoice);
		arsonView.addView(arsonTargetScroll);
		arsonView.addView(continueArson);
		
		finalLayout.addView(scandalView);
		finalLayout.addView(riotView);
		finalLayout.addView(sabotageView);
		finalLayout.addView(assassinateView);
		finalLayout.addView(arsonView);
		
		hideAllViews();
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
