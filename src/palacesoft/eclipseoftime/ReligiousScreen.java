package palacesoft.eclipseoftime;

import android.app.FragmentManager;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;

public class ReligiousScreen extends Fragment {

	private GameScreen gameScreen;
	private FrameLayout finalLayout;
	private LinearLayout sacrificeLayout;
	private LinearLayout heathenLayout;
	private LinearLayout raiseOrderLayout;
	
	/* sacrificing civilians ui */
	private TextView sacrificeMessage;
	private Button increaseSacrificeCount;
	private Button decreaseSacrificeCount;
	private int sacrificeCount;
	
	/* declaring opponents heathens ui elements */
	private TextView declareHeathensMessage;
	private ScrollView foreignLeadersListScrollView;
	private EligibilityScreen foreignLeaderList;
	
	/* increasing your peoples faith in you as divine ui elements */
	private TextView raiseOrderMessage;
	private TextView sacCountView;
	
	public Fragment getFragment(){
		ReligiousScreen newReligiousFrag = new ReligiousScreen();
		
		return newReligiousFrag;
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		finalLayout = new FrameLayout(getActivity());
		sacrificeLayout = new LinearLayout(getActivity());
		sacrificeLayout.setOrientation(LinearLayout.VERTICAL);
		heathenLayout = new LinearLayout(getActivity());
		heathenLayout.setOrientation(LinearLayout.VERTICAL);
		raiseOrderLayout = new LinearLayout(getActivity());
		raiseOrderLayout.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutParams.gravity = Gravity.CENTER;
		
		sacrificeLayout.setLayoutParams(layoutParams);
		heathenLayout.setLayoutParams(layoutParams);
		raiseOrderLayout.setLayoutParams(layoutParams);
		
		sacrificeMessage = new TextView(getActivity());
		sacrificeMessage.setText("How many civilians will you sacrifice and who will lead the ceremony");
		increaseSacrificeCount = new Button(getActivity());
		increaseSacrificeCount.setText("+");
		increaseSacrificeCount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(sacrificeCount < gameScreen.getPlayer().getKingdom().getHomeCity().getPopulation()){
					sacrificeCount++;
					sacCountView.setText(String.valueOf(sacrificeCount));
				}
				
			}
		});
		decreaseSacrificeCount = new Button(getActivity());
		decreaseSacrificeCount.setText("-");
		decreaseSacrificeCount.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(sacrificeCount > 0){
					sacrificeCount--;
					sacCountView.setText(String.valueOf(sacrificeCount));
				}
				
			}
		});
		sacrificeCount = 0;
		sacCountView = new TextView(getActivity());
		sacCountView.setText(String.valueOf(sacrificeCount));
		LinearLayout sublayout = new LinearLayout(getActivity());
		sublayout.setLayoutParams(layoutParams);
		sublayout.addView(decreaseSacrificeCount);
		sublayout.addView(sacCountView);
		sublayout.addView(increaseSacrificeCount);
		sacrificeLayout.setLayoutParams(layoutParams);
		sacrificeLayout.addView(sacrificeMessage);
		sacrificeLayout.addView(sublayout);
		
		declareHeathensMessage = new TextView(getActivity());
		declareHeathensMessage.setText("Which leader will you denounce and who will carry out your order?");
		foreignLeadersListScrollView = new ScrollView(getActivity());
		foreignLeaderList = new EligibilityScreen();
		LinearLayout sublayout1 = new LinearLayout(getActivity());
		sublayout1.setOrientation(LinearLayout.VERTICAL);
		sublayout1.setId(99);
		FragmentTransaction fTrans = getActivity().getSupportFragmentManager().beginTransaction(); 
		fTrans.add(sublayout1.getId(), foreignLeaderList, "foreign leaders list");
		fTrans.commit();
		foreignLeadersListScrollView.addView(sublayout1);
		heathenLayout.setLayoutParams(layoutParams);
		heathenLayout.addView(declareHeathensMessage);
		heathenLayout.addView(foreignLeadersListScrollView);
		
		raiseOrderMessage = new TextView(getActivity());
		raiseOrderMessage.setText("Choose your envoy to raise the people's faith in you!");
		raiseOrderLayout.setLayoutParams(layoutParams);
		raiseOrderLayout.addView(raiseOrderMessage);
		
		finalLayout.addView(sacrificeLayout);
		finalLayout.addView(heathenLayout);
		finalLayout.addView(raiseOrderLayout);
		
		hideViews();
		
	}
	
	public void hideViews(){
		sacrificeLayout.setVisibility(View.GONE);
		heathenLayout.setVisibility(View.GONE);
		raiseOrderLayout.setVisibility(View.GONE);
		
	}
	
	public void showSacrificeViews(){
		hideViews();
		sacrificeLayout.setVisibility(View.VISIBLE);
	}
	
	public void showHeathenViews(){
		hideViews();
		heathenLayout.setVisibility(View.VISIBLE);
	}
	
	public void showDivineRightViews(){
		hideViews();
		raiseOrderLayout.setVisibility(View.VISIBLE);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
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
