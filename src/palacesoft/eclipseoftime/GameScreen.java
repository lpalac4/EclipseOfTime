package palacesoft.eclipseoftime;

import palacesoft.eclipseoftime.mapview.MapRenderer;
import palacesoft.eclipseoftime.mapview.MapView;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.text.method.HideReturnsTransformationMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class GameScreen extends FragmentActivity {

	private LinearLayout finalLayout;
	private int screenW;
	private int screenH;
	private MapView mapView;
	private DomesticScreen domesticFrag;
	private MilitaryScreen militaryFrag;
	private PlotScreen plotFrag;
	private PoliticsScreen politicsFrag;
	private ReligiousScreen religionFrag;
	private TreasuryScreen treasuryFrag;
	private int[] gameOptions;
	private int[] defaultOptions = {30,3,40,20};
	private LinearLayout leftFragLayout;
	private LinearLayout rightFragLayout; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

		/* getting dimensions from the device running the game */
		screenW = getResources().getDisplayMetrics().widthPixels;
		screenH = getResources().getDisplayMetrics().heightPixels;

		/* retrieving game options from the passed intent 
		 * if no options selected testing perhaps, run default setting */
		gameOptions = getIntent().getIntArrayExtra("Options");
		if(gameOptions == null){
			gameOptions = defaultOptions;
		}
		/* The very important custom map of the game */
		mapView = new MapView(this);
		mapView.setLayoutParams(new LinearLayout.LayoutParams(screenW, (int)(screenH * 0.80)));
		//mapView.setRenderer(new MapRenderer(this));
	
		/* the lowest layout where everything on screen will be held, will match the devices dimensions */
		finalLayout = new LinearLayout(this);
		finalLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		finalLayout.setBackgroundColor(Color.BLACK);
		finalLayout.setOrientation(LinearLayout.VERTICAL);

		/* this frame layout is the center of the screen which will hold the map and the two possible fragments
		 * sized to match the device's width but only 75% of its height */
		FrameLayout middleLayout = new FrameLayout(this);
		middleLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.80)));
		middleLayout.setId(3);

		/* layout size parameters for the left and right fragments on top of middleLayout matching its height but taking a combined 50% screenW real estate
		 * they can each have a gravity defined for them. */
		FrameLayout.LayoutParams leftfrag = new FrameLayout.LayoutParams((int)(screenW * 0.25), LayoutParams.MATCH_PARENT);
		leftfrag.gravity = Gravity.LEFT;
		FrameLayout.LayoutParams rightfrag = new FrameLayout.LayoutParams((int)(screenW * 0.25), LayoutParams.MATCH_PARENT);
		rightfrag.gravity = Gravity.RIGHT;

		/* initializing the layouts for the two fragments */
		leftFragLayout = new LinearLayout(this);
		leftFragLayout.setLayoutParams(leftfrag);
		leftFragLayout.setBackgroundColor(Color.BLACK);
		leftFragLayout.setOrientation(LinearLayout.VERTICAL);
		leftFragLayout.setId(4);
		rightFragLayout = new LinearLayout(this);
		rightFragLayout.setLayoutParams(rightfrag);
		rightFragLayout.setBackgroundColor(Color.BLACK);
		rightFragLayout.setOrientation(LinearLayout.VERTICAL);
		rightFragLayout.setId(5);

		/* initialize the fragments that may appear on screen */
		domesticFrag = new DomesticScreen();
		militaryFrag = new MilitaryScreen();
		plotFrag = new PlotScreen();
		politicsFrag = new PoliticsScreen();
		religionFrag = new ReligiousScreen();
		treasuryFrag = new TreasuryScreen();
		
		/* commit those initialized fragments to their respective layout */
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(leftFragLayout.getId(), domesticFrag, "Domestic Fragment");
		fTrans.hide(domesticFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(leftFragLayout.getId(), militaryFrag, "Military Fragment");
		fTrans.hide(militaryFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(leftFragLayout.getId(), plotFrag, "Plot Fragment");
		fTrans.hide(plotFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(rightFragLayout.getId(), politicsFrag, "Politics Fragment");
		fTrans.hide(plotFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(rightFragLayout.getId(), religionFrag, "Religion Fragment");
		fTrans.hide(plotFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		fTrans.add(rightFragLayout.getId(), treasuryFrag, "Treasury Fragment");
		fTrans.hide(plotFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();

		leftFragLayout.setVisibility(LinearLayout.GONE);
		rightFragLayout.setVisibility(LinearLayout.GONE);
		
		middleLayout.addView(mapView);
		middleLayout.addView(rightFragLayout);
		middleLayout.addView(leftFragLayout);
		/* add the views on top of final layout in this order, 
		 * top label-> interactive map -> leftFrag -> right fragment -> bottom label */
		finalLayout.addView(createTopLabel());
		finalLayout.addView(middleLayout);
		finalLayout.addView(createBotLabel());

		/* testing listeners */
		finalLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(rightFragLayout.getVisibility() == LinearLayout.GONE)
					rightFragLayout.setVisibility(LinearLayout.VISIBLE);
				else if(rightFragLayout.getVisibility() == LinearLayout.VISIBLE)
					rightFragLayout.setVisibility(LinearLayout.GONE);
				
				if(leftFragLayout.getVisibility() == LinearLayout.GONE)
					leftFragLayout.setVisibility(LinearLayout.VISIBLE);
				else if(leftFragLayout.getVisibility() == LinearLayout.VISIBLE)
					leftFragLayout.setVisibility(LinearLayout.GONE);
				
			}
		});

		/* set the final view to go up for display */
		setContentView(finalLayout);
	}

	private View createBotLabel() {
		BottomMenuView botMenu = new BottomMenuView(this);
		return botMenu.getView();
	}

	private View createTopLabel() {
		TopMenuView topMenu = new TopMenuView(this);
		return topMenu.getView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}


	/**
	 * Show the requested fragment for a specific phase of the game, keeping 
	 * in mind that fragments can be either on the left or right of the screen.
	 */
	public boolean showDomesticScreen(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(domesticFrag != null && domesticFrag.isHidden())
			fTrans.show(domesticFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
		
		return false;
	}
	public boolean showMilitaryScreen(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(militaryFrag != null && militaryFrag.isHidden())
			fTrans.show(militaryFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		return false;
	}
	public boolean showPlotScreen(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(plotFrag != null && plotFrag.isHidden())
			fTrans.show(plotFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		return false;
	}
	private boolean showPoliticsScreen(){	
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(politicsFrag != null && politicsFrag.isHidden())
			fTrans.show(politicsFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		return false;
	}
	private boolean showReligiousScreen(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(religionFrag != null && religionFrag.isHidden())
			fTrans.show(religionFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		return false;
	}
	private boolean showTreasuryScreen(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(treasuryFrag != null && treasuryFrag.isHidden())
			fTrans.show(treasuryFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		return false;
	}

	/* Start new activities that end the game loop ie the win/lose activities */
	private void startWinActivity(){
		
	}
	private void startLoseActivity(){
		
	}
	
	/**
	 *  Interfaces between the left and right fragments and this activity
	 */
	public void leftFragListener(){
		//listen for changes made 
	}
	public void rightFragListener(){
		//listen for changes 
	}
	
	/* helper function to hide all fragments during transitions between two of them in the same
	 * layout.
	 */
	private void hideLeftFrags(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(domesticFrag != null && !domesticFrag.isHidden())
			fTrans.hide(domesticFrag);
		if(militaryFrag != null && !militaryFrag.isHidden())
			fTrans.hide(militaryFrag);
		if(plotFrag != null && !plotFrag.isHidden())
			fTrans.hide(plotFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
	}
	private void hideRightFrags(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(politicsFrag != null && politicsFrag.isHidden())
			fTrans.hide(politicsFrag);
		if(religionFrag != null && !religionFrag.isHidden())
			fTrans.hide(religionFrag);
		if(treasuryFrag != null && !treasuryFrag.isHidden())
			fTrans.hide(treasuryFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
	}

	/**
	 * too communicate with fragment one must capture its instance like this
	 *  ArticleFragment articleFrag = (ArticleFragment)
            getSupportFragmentManager().findFragmentById(R.id.article_fragment);

   then you can reference its public methods.
	 * @return
	 */
	
	
	@Override
	protected void onResume() {
		super.onResume();
		mapView.onResume();
	}

	
	@Override
	protected void onPause() {
		super.onPause();
		mapView.onPause();
	}


}

