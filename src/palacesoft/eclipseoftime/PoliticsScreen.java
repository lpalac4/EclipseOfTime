package palacesoft.eclipseoftime;

import android.R.layout;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;

public class PoliticsScreen extends Fragment {
	
	private FrameLayout finalLayout;
	private GameScreen gameScreen;
	
	private ScrollView hiringCandidates;
	private EligibilityScreen listOfCandidates;
	private TextView hiringMessage;
	private LinearLayout hireView;
	private Button continueHiring;
	
	private TextView marryingMessage;
	private ScrollView housesList;
	private Button continueMarriage;
	private LinearLayout marryView;
	
	private TextView awardMessage;
	private TextView awardAmount;
	private int awardCount;
	private Button increaseAward; 
	private Button decreaseAward;
	private Button awardItemInstead;
	private Button continueAward;
	private LinearLayout awardView;
	
	private TextView tradeMessage;
	private ScrollView tradingPartner;
	private EligibilityScreen tradingPartnerList;
	private ScrollView tradeableItems;
	private EligibilityScreen tradeableItemsList;
	private Button continueTrade;
	private LinearLayout tradeView;
	
	
	public PoliticsScreen getFragment(){
		PoliticsScreen newFrag = new PoliticsScreen();
		return newFrag;
	}
	
	public void hideAllViews(){
		hireView.setVisibility(View.GONE);
		marryView.setVisibility(View.GONE);
		awardView.setVisibility(View.GONE);
		tradeView.setVisibility(View.GONE);
	}
	
	public void showHireView(){
		hideAllViews();
		hireView.setVisibility(View.VISIBLE);
	}
	
	public void showMarryView(){
		hideAllViews();
		marryView.setVisibility(View.VISIBLE);
	}
	
	public void showAwardView(){
		hideAllViews();
		awardView.setVisibility(View.VISIBLE);
	}
	
	public void showTradeView(){
		hideAllViews();
		tradeView.setVisibility(View.VISIBLE);
	}
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		gameScreen = (GameScreen)
				getActivity();
		finalLayout = new FrameLayout(getActivity());
		FragmentTransaction fTrans;
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParams.gravity = Gravity.CENTER;
		
		hiringCandidates = new ScrollView(getActivity());
		hireView = new LinearLayout(getActivity());
		hireView.setOrientation(LinearLayout.VERTICAL);
		LinearLayout sublayout1 = new LinearLayout(getActivity());
		sublayout1.setOrientation(LinearLayout.VERTICAL);
		sublayout1.setId(8);
		sublayout1.setLayoutParams(layoutParams);
		hiringMessage = new TextView(getActivity());
		hiringMessage.setText("Pick who to hire and who will present the offer");
		continueHiring = new Button(getActivity());
		continueHiring.setText("Continue");
		hireView.addView(hiringMessage);
		fTrans = getActivity().getSupportFragmentManager().beginTransaction(); 
		listOfCandidates = new EligibilityScreen();
		fTrans.add(sublayout1.getId(), listOfCandidates, "Hiring Candidates");
		fTrans.commit();
		hiringCandidates.addView(sublayout1);
		hireView.addView(hiringCandidates);
		hireView.addView(continueHiring);
		hireView.setLayoutParams(layoutParams);
		
		marryView = new LinearLayout(getActivity());
		marryView.setOrientation(LinearLayout.VERTICAL);
		marryingMessage = new TextView(getActivity());
		marryingMessage.setText("Choose the leader to offer the marriage to and the character who you wish to propose");	
		continueMarriage = new Button(getActivity());
		continueMarriage.setText("Continue");
		housesList = new ScrollView(getActivity());
		housesList.setId(7);
		marryView.addView(marryingMessage);
		fTrans = getActivity().getSupportFragmentManager().beginTransaction(); 
		EligibilityScreen foreignLeadersList = new EligibilityScreen();
		fTrans.add(housesList.getId(), foreignLeadersList, "Foreign Leaders");
		fTrans.commit();
		marryView.addView(housesList);
		marryView.addView(continueMarriage);
		marryView.setLayoutParams(layoutParams);
		
		awardMessage = new TextView(getActivity());
		awardMessage.setText("Choose the champion you wish to reward");
		awardCount = 0;
		awardAmount = new TextView(getActivity());
		awardAmount.setText(String.valueOf(awardCount));
		increaseAward = new Button(getActivity()); 
		increaseAward.setText("+");
		increaseAward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(awardCount < 9){
					awardCount++;
					awardAmount.setText(String.valueOf(awardCount));
				}
			}
		});
		decreaseAward = new Button(getActivity());
		decreaseAward.setText("-");
		decreaseAward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(awardCount > 1){
					awardCount--;
					awardAmount.setText(String.valueOf(awardCount));
				}
			}
		});
		awardItemInstead = new Button(getActivity());
		awardItemInstead.setText("Item");
		continueAward = new Button(getActivity());
		continueAward.setText("Continue");
		awardView = new LinearLayout(getActivity());
		awardView.setOrientation(LinearLayout.VERTICAL);
		awardView.addView(awardMessage);
		LinearLayout sublayout = new LinearLayout(getActivity());
		sublayout.addView(decreaseAward);
		sublayout.addView(awardAmount);
		sublayout.addView(increaseAward);
		awardView.addView(sublayout);
		awardView.addView(continueAward);
		awardView.setLayoutParams(layoutParams);
		
		tradeMessage = new TextView(getActivity());
		tradeMessage.setText("Select the leader to trade with");
		tradingPartner = new ScrollView(getActivity());
		tradingPartner.setId(6);
		fTrans = getActivity().getSupportFragmentManager().beginTransaction();
		tradingPartnerList = new EligibilityScreen();
		fTrans.add(tradingPartner.getId(), tradingPartnerList, "Trading Partners");
		fTrans.commit();
		continueTrade = new Button(getActivity());
		continueTrade.setText("Continue");
		tradeView = new LinearLayout(getActivity());
		tradeView.setOrientation(LinearLayout.VERTICAL);
		tradeView.addView(tradeMessage);
		tradeView.addView(tradingPartner);
		tradeView.addView(continueTrade);
		tradeView.setLayoutParams(layoutParams);
		
		continueAward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		continueHiring.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		
		continueMarriage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		
		continueTrade.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		
		finalLayout.addView(hireView);
		finalLayout.addView(marryView);
		finalLayout.addView(awardView);
		finalLayout.addView(tradeView);
		
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
