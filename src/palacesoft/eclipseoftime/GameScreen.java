package palacesoft.eclipseoftime;

import java.io.File;

import palacesoft.eclipseoftime.mapview.MapRenderer;
import palacesoft.eclipseoftime.mapview.MapView;
import palacesoft.eclipseoftime.models.Player;
import palacesoft.eclipseoftime.models.Player.Difficulty;
import palacesoft.eclipseoftime.utils.GameLoop;
import palacesoft.eclipseoftime.utils.TurnController;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.Fragment;
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
import android.widget.ViewFlipper;

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
	private EligibilityScreen eligibilityFrag; 
	private InfoScreen infoFrag;
	private int[] gameOptions;
	private int[] defaultOptions = {30,3,40,20};
	private FrameLayout leftFragLayout;
	private FrameLayout rightFragLayout;
	
	private FrameLayout currentBotView;
	private BottomMenuView botDefaultMenu;
	private BottomMenuDomestic botDomMenu;
	private BottomMenuInfo botInfoMenu;
	private BottomMenuMilitary botMilitaryMenu;
	private BottomMenuPlot botPlotMenu;
	private BottomMenuPolitics botPoliticsMenu;
	private BottomMenuReligion botReligionMenu;
	
	public GameLoop gameLoop;
	
	private TopMenuView topMenu;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		File gameData = new File("/gameData.data");
		
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
		gameLoop = new GameLoop(defaultOptions[1], Difficulty.MEDIUM, gameData, this);
	
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
		leftFragLayout = new FrameLayout(this);
		leftFragLayout.setLayoutParams(leftfrag);
		leftFragLayout.setBackgroundColor(Color.WHITE);
		//leftFragLayout.setOrientation(LinearLayout.VERTICAL);
		leftFragLayout.setId(4);
		rightFragLayout = new FrameLayout(this);
		rightFragLayout.setLayoutParams(rightfrag);
		rightFragLayout.setBackgroundColor(Color.WHITE);
		//rightFragLayout.setOrientation(LinearLayout.77VERTICAL);
		rightFragLayout.setId(5);

		/* initialize the fragments that may appear on screen */
		/* commit those initialized fragments to their respective layout */
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		domesticFrag = new DomesticScreen();
		fTrans.add(leftFragLayout.getId(), domesticFrag, "Domestic Fragment");
		fTrans.hide(domesticFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		militaryFrag = new MilitaryScreen();
		fTrans.add(leftFragLayout.getId(), militaryFrag, "Military Fragment");
		fTrans.hide(militaryFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		plotFrag = new PlotScreen();
		fTrans.add(leftFragLayout.getId(), plotFrag, "Plot Fragment");
		fTrans.hide(plotFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction(); 
		politicsFrag = new PoliticsScreen();
		fTrans.add(leftFragLayout.getId(), politicsFrag, "Politics Fragment");
		fTrans.hide(politicsFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		
		fTrans = getSupportFragmentManager().beginTransaction(); 
		religionFrag = new ReligiousScreen();
		fTrans.add(leftFragLayout.getId(), religionFrag, "Religion Fragment");
		fTrans.hide(religionFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction();
		treasuryFrag = new TreasuryScreen();
		fTrans.add(leftFragLayout.getId(), treasuryFrag, "Treasury Fragment");
		fTrans.hide(treasuryFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction();
		infoFrag = new InfoScreen();
		fTrans.add(leftFragLayout.getId(), infoFrag, "Information Fragment");
		fTrans.hide(infoFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();
		fTrans = getSupportFragmentManager().beginTransaction();
		eligibilityFrag = new EligibilityScreen();
		fTrans.add(rightFragLayout.getId(), eligibilityFrag, "Eligibility List");
		fTrans.hide(eligibilityFrag);
		fTrans.addToBackStack(null);
		fTrans.commit();

		leftFragLayout.setVisibility(LinearLayout.GONE);
		rightFragLayout.setVisibility(LinearLayout.GONE);
		
		middleLayout.addView(mapView);
		middleLayout.addView(rightFragLayout);
		middleLayout.addView(leftFragLayout);
		currentBotView = new FrameLayout(this);
		createBotLabel();
		/* add the views on top of final layout in this order, 
		 * top label-> interactive map -> leftFrag -> right fragment -> bottom label */
		finalLayout.addView(createTopLabel());
		finalLayout.addView(middleLayout);
		finalLayout.addView(currentBotView);

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
				
				showDefaultBotOptions();
				
			}
		});
		hideLeftFrags();
		hideRightFrags();

		/* set the final view to go up for display */
		setContentView(finalLayout);
	}

	private void createBotLabel() {
		botDefaultMenu = new BottomMenuView(this);
		botDefaultMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botDomMenu = new BottomMenuDomestic(this);
		botDomMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botInfoMenu = new BottomMenuInfo(this);
		botInfoMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botMilitaryMenu = new BottomMenuMilitary(this);
		botMilitaryMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botPlotMenu = new BottomMenuPlot(this);
		botPlotMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botPoliticsMenu = new BottomMenuPolitics(this);
		botPoliticsMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		botReligionMenu = new BottomMenuReligion(this);
		botReligionMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
		
		currentBotView.addView(botDefaultMenu.getView());
		currentBotView.addView(botDomMenu.getView());
		currentBotView.addView(botInfoMenu.getView());
		currentBotView.addView(botMilitaryMenu.getView());
		currentBotView.addView(botPlotMenu.getView());
		currentBotView.addView(botPoliticsMenu.getView());
		currentBotView.addView(botReligionMenu.getView());

		showDefaultBotOptions();
	
	}
	
	private void hideBotViews(){
		botDefaultMenu.getView().setVisibility(View.GONE);
		botDomMenu.getView().setVisibility(View.GONE);
		botInfoMenu.getView().setVisibility(View.GONE);
		botMilitaryMenu.getView().setVisibility(View.GONE);
		botPlotMenu.getView().setVisibility(View.GONE);
		botPoliticsMenu.getView().setVisibility(View.GONE);
		botReligionMenu.getView().setVisibility(View.GONE);
	}

	private View createTopLabel() {
		topMenu = new TopMenuView(this);
		topMenu.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(screenH * 0.10)));
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
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(domesticFrag != null && domesticFrag.isHidden())
			fTrans.show(domesticFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		
		return false;
	}
	
	public boolean showEligibilityScreen(){
		hideRightFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(eligibilityFrag != null && eligibilityFrag.isHidden())
			fTrans.show(eligibilityFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
		
		rightFragLayout.setVisibility(View.VISIBLE);
		
		return false;
	}
	
	public boolean showInfoScreen(){
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(infoFrag != null && infoFrag.isHidden())
			fTrans.show(domesticFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		
		return false;
	}
	
	public boolean showMilitaryScreen(){
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(militaryFrag != null && militaryFrag.isHidden())
			fTrans.show(militaryFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		
		return false;
	}
	public boolean showPlotScreen(){
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(plotFrag != null && plotFrag.isHidden())
			fTrans.show(plotFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		return false;
	}
	public boolean showPoliticsScreen(){	
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(politicsFrag != null && politicsFrag.isHidden())
			fTrans.show(politicsFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		return false;
	}
	public boolean showReligiousScreen(){
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(religionFrag != null && religionFrag.isHidden())
			fTrans.show(religionFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
		return false;
	}
	public boolean showTreasuryScreen(){
		hideLeftFrags();
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(treasuryFrag != null && treasuryFrag.isHidden())
			fTrans.show(treasuryFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.VISIBLE);
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
		if(politicsFrag != null && politicsFrag.isHidden())
			fTrans.hide(politicsFrag);
		if(religionFrag != null && !religionFrag.isHidden())
			fTrans.hide(religionFrag);
		if(treasuryFrag != null && !treasuryFrag.isHidden())
			fTrans.hide(treasuryFrag);

		fTrans.addToBackStack(null);
		fTrans.commit();
		
		leftFragLayout.setVisibility(View.GONE);
	}
	private void hideRightFrags(){
		FragmentTransaction fTrans = getSupportFragmentManager().beginTransaction(); 
		if(eligibilityFrag != null && eligibilityFrag.isHidden())
			fTrans.hide(eligibilityFrag);
		
		fTrans.addToBackStack(null);
		fTrans.commit();
	
		rightFragLayout.setVisibility(View.GONE);
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

	public void showInfoOptions() {
		hideBotViews();
		botInfoMenu.getView().setVisibility(View.VISIBLE);
		//showInfoScreen();
		
	}

	public void showMilitaryOptions() {
		hideBotViews();
		botMilitaryMenu.getView().setVisibility(View.VISIBLE);
		//showMilitaryScreen();
		
	}

	public void showDomesticOptions() {
		hideBotViews();
		botDomMenu.getView().setVisibility(View.VISIBLE);
		//showDomesticScreen();
		
	}

	public void showPoliticsOptions() {
		hideBotViews();
		botPoliticsMenu.getView().setVisibility(View.VISIBLE);
		//showPoliticsScreen();
		
	}

	public void showPlotOptions() {
		hideBotViews();
		botPlotMenu.getView().setVisibility(View.VISIBLE);
		//showPlotScreen();
		
	}
	
	public void showDefaultBotOptions(){
		hideBotViews();
		botDefaultMenu.getView().setVisibility(View.VISIBLE);
		hideLeftFrags();
		hideRightFrags();
	}

	public void showReligionOptions() {
		hideBotViews();
		botReligionMenu.getView().setVisibility(View.VISIBLE);
		//showReligiousScreen();
		
	}

	public FrameLayout getCurrentBotView() {
		return currentBotView;
	}

	public void setCurrentBotView(FrameLayout currentBotView) {
		this.currentBotView = currentBotView;
	}

	public BottomMenuView getBotDefaultMenu() {
		return botDefaultMenu;
	}

	public void setBotDefaultMenu(BottomMenuView botDefaultMenu) {
		this.botDefaultMenu = botDefaultMenu;
	}

	public BottomMenuDomestic getBotDomMenu() {
		return botDomMenu;
	}

	public void setBotDomMenu(BottomMenuDomestic botDomMenu) {
		this.botDomMenu = botDomMenu;
	}

	public BottomMenuInfo getBotInfoMenu() {
		return botInfoMenu;
	}

	public void setBotInfoMenu(BottomMenuInfo botInfoMenu) {
		this.botInfoMenu = botInfoMenu;
	}

	public BottomMenuMilitary getBotMilitaryMenu() {
		return botMilitaryMenu;
	}

	public void setBotMilitaryMenu(BottomMenuMilitary botMilitaryMenu) {
		this.botMilitaryMenu = botMilitaryMenu;
	}

	public BottomMenuPlot getBotPlotMenu() {
		return botPlotMenu;
	}

	public void setBotPlotMenu(BottomMenuPlot botPlotMenu) {
		this.botPlotMenu = botPlotMenu;
	}

	public BottomMenuPolitics getBotPoliticsMenu() {
		return botPoliticsMenu;
	}

	public void setBotPoliticsMenu(BottomMenuPolitics botPoliticsMenu) {
		this.botPoliticsMenu = botPoliticsMenu;
	}

	public BottomMenuReligion getBotReligionMenu() {
		return botReligionMenu;
	}

	public void setBotReligionMenu(BottomMenuReligion botReligionMenu) {
		this.botReligionMenu = botReligionMenu;
	}

	public DomesticScreen getDomesticFrag() {
		return domesticFrag;
	}

	public void setDomesticFrag(DomesticScreen domesticFrag) {
		this.domesticFrag = domesticFrag;
	}

	public MilitaryScreen getMilitaryFrag() {
		return militaryFrag;
	}

	public void setMilitaryFrag(MilitaryScreen militaryFrag) {
		this.militaryFrag = militaryFrag;
	}

	public PlotScreen getPlotFrag() {
		return plotFrag;
	}

	public void setPlotFrag(PlotScreen plotFrag) {
		this.plotFrag = plotFrag;
	}

	public PoliticsScreen getPoliticsFrag() {
		return politicsFrag;
	}

	public void setPoliticsFrag(PoliticsScreen politicsFrag) {
		this.politicsFrag = politicsFrag;
	}

	public ReligiousScreen getReligionFrag() {
		return religionFrag;
	}

	public void setReligionFrag(ReligiousScreen religionFrag) {
		this.religionFrag = religionFrag;
	}

	public EligibilityScreen getEligibilityFrag() {
		return eligibilityFrag;
	}

	public void setEligibilityFrag(EligibilityScreen eligibilityFrag) {
		this.eligibilityFrag = eligibilityFrag;
	}

	public InfoScreen getInfoFrag() {
		return infoFrag;
	}

	public void setInfoFrag(InfoScreen infoFrag) {
		this.infoFrag = infoFrag;
	}

	public Player getPlayer() {
		
		return gameLoop.getTurnController().getCurrentPlayer();
	}

}

