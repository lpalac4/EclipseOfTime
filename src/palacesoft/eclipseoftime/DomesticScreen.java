package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnCreateContextMenuListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

public class DomesticScreen extends Fragment {

	ScrollView craftActionButtons;
	ScrollView buildActionButtons;
	ScrollView cityMaintButtons;
	LinearLayout craftLayout,buildLayout,cityMainLayout;
	private int screenH, screenW;
	private GameScreen gameScreen;
	
	/* Declare the buttons that will signal the crafting choice */
	private ImageButton craftSpearButton;
	private ImageButton craftBowButton;
	private ImageButton craftAtlatlButton;
	private ImageButton craftMaquahitlButton;
	
	/* Declare buttons for building choices */
	private ImageButton builMarketButton;
	private ImageButton buildPyramidButton;
	private ImageButton buildArmoryButton;
	private ImageButton buildTempleButton;
	private ImageButton buildWallButton;
	
	/* Declare buttons for city maintenance */
	private ImageButton maintainDamButton;
	private ImageButton maintainFarmButton;
	private ImageButton maintainEconomyButton;
	private ImageButton maintainTechnologyButton;
	private FrameLayout finalLayout;
	
	
	public DomesticScreen getFragment(){
		DomesticScreen newDomesticFrag = new DomesticScreen();
		gameScreen = (GameScreen) getActivity();
		return newDomesticFrag;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		gameScreen = (GameScreen) getActivity();
		
		
		screenW = (int)(getActivity().getResources().getDisplayMetrics().widthPixels * 0.60);
		screenH = (int)(getActivity().getResources().getDisplayMetrics().heightPixels * 0.75);

		craftActionButtons = new ScrollView(getActivity());
		buildActionButtons = new ScrollView(getActivity());
		cityMaintButtons = new ScrollView(getActivity());
		
		craftLayout = new LinearLayout(getActivity());
		craftLayout.setOrientation(LinearLayout.VERTICAL);
		craftLayout.setGravity(Gravity.CENTER);
		
		buildLayout = new LinearLayout(getActivity());
		buildLayout.setOrientation(LinearLayout.VERTICAL);
		buildLayout.setGravity(Gravity.CENTER);
		
		cityMainLayout = new LinearLayout(getActivity());
		cityMainLayout.setOrientation(LinearLayout.VERTICAL);
		cityMainLayout.setGravity(Gravity.CENTER);
		
		finalLayout = new FrameLayout(getActivity());
	
		LinearLayout.LayoutParams buttonSize = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		buttonSize.gravity = Gravity.CENTER;
		craftLayout.setLayoutParams(buttonSize);
		buildLayout.setLayoutParams(buttonSize);
		cityMainLayout.setLayoutParams(buttonSize);
		
		FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		frameParams.gravity = Gravity.CENTER;
		finalLayout.setLayoutParams(frameParams);
		
		maintainDamButton = new ImageButton(getActivity());
		maintainDamButton.setBackgroundResource(R.drawable.ic_launcher);
		maintainDamButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
			}
		});
		
		maintainFarmButton = new ImageButton(getActivity());
		maintainFarmButton.setBackgroundResource(R.drawable.ic_launcher);
		maintainFarmButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		maintainEconomyButton = new ImageButton(getActivity());
		maintainEconomyButton.setBackgroundResource(R.drawable.ic_launcher);
		maintainEconomyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		maintainTechnologyButton = new ImageButton(getActivity());
		maintainTechnologyButton.setBackgroundResource(R.drawable.ic_launcher);
		maintainTechnologyButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		buildWallButton = new ImageButton(getActivity());
		buildWallButton.setBackgroundResource(R.drawable.phase_icon);
		buildWallButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		buildTempleButton = new ImageButton(getActivity());
		buildTempleButton.setBackgroundResource(R.drawable.ic_launcher);
		buildTempleButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		buildArmoryButton = new ImageButton(getActivity());
		buildArmoryButton.setBackgroundResource(R.drawable.ic_launcher);
		buildArmoryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		buildPyramidButton = new ImageButton(getActivity());
		buildPyramidButton.setBackgroundResource(R.drawable.ic_launcher);
		buildPyramidButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		builMarketButton = new ImageButton(getActivity());
		builMarketButton.setBackgroundResource(R.drawable.ic_launcher);
		builMarketButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		craftBowButton = new ImageButton(getActivity());
		craftBowButton.setBackgroundResource(R.drawable.continue_icon);
		craftBowButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});

		craftAtlatlButton = new ImageButton(getActivity());
		craftAtlatlButton.setBackgroundResource(R.drawable.ic_launcher);
		craftAtlatlButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		craftMaquahitlButton = new ImageButton(getActivity());
		craftMaquahitlButton.setBackgroundResource(R.drawable.ic_launcher);
		craftMaquahitlButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		craftSpearButton = new ImageButton(getActivity());
		craftSpearButton.setBackgroundResource(R.drawable.ic_launcher);
		craftSpearButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showEligibilityScreen();
				
			}
		});
		
		craftLayout.addView(craftSpearButton);
		craftLayout.addView(craftBowButton);
		craftLayout.addView(craftAtlatlButton);
		craftLayout.addView(craftMaquahitlButton);
		craftActionButtons.addView(craftLayout);
		
		buildLayout.addView(buildArmoryButton);
		buildLayout.addView(buildPyramidButton);
		buildLayout.addView(buildTempleButton);
		buildLayout.addView(buildWallButton);
		buildActionButtons.addView(buildLayout);
		
		cityMainLayout.addView(maintainDamButton);
		cityMainLayout.addView(maintainEconomyButton);
		cityMainLayout.addView(maintainFarmButton);
		cityMainLayout.addView(maintainTechnologyButton);
		cityMaintButtons.addView(cityMainLayout);

		finalLayout.addView(craftActionButtons);
		finalLayout.addView(buildActionButtons);
		finalLayout.addView(cityMaintButtons);
		
		hideAllViews();
	
	}
	
	public void hideAllViews(){
		craftActionButtons.setVisibility(View.GONE);
		buildActionButtons.setVisibility(View.GONE);
		cityMaintButtons.setVisibility(View.GONE);
	}
	
	public void showCraftOptions(){
		hideAllViews();
		craftActionButtons.setVisibility(View.VISIBLE);
	}
	
	public void showBuildOptions(){
		hideAllViews();
		buildActionButtons.setVisibility(View.VISIBLE);
		
	}
	
	public void showMaintenanceOptions(){
		hideAllViews();
		cityMaintButtons.setVisibility(View.VISIBLE);
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
