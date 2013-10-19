package palacesoft.lostundertheshade;

import java.util.Stack;
import android.app.Activity;

/**
 * The class will act as a UI stack.
 * @author DaPalacios
 *
 */
public class UISwitcher {
	
	private DefeatScreen defeatScreen;
	private DomesticScreen domesticScreen;
	private MilitaryScreen militaryScreen;
	private PoliticsScreen politicsScreen;
	private PlotScreen plotScreen;
	private ReligiousScreen religionScreen;
	private TreasuryScreen treasuryScreen;
	private WinScreen winScreen;
	
	private Stack<Activity> activityStack;
	
	public UISwitcher(){
		activityStack = new Stack<Activity>();
		activityStack.push(new DefeatScreen());
		activityStack.push(new DomesticScreen());
		activityStack.push(new MilitaryScreen());
		activityStack.push(new PoliticsScreen());
		activityStack.push(new PlotScreen());
		activityStack.push(new ReligiousScreen());
		activityStack.push(new TreasuryScreen());
		activityStack.push(new WinScreen());

	}
	
	public UISwitcher(DefeatScreen defeatScreen, DomesticScreen domesticScreen, MilitaryScreen militaryScreen, PoliticsScreen politicsScreen,
			PlotScreen plotScreen, ReligiousScreen religionScreen, TreasuryScreen treasuryScreen, WinScreen winScreen){
		
		this.defeatScreen = defeatScreen;
		this.domesticScreen = domesticScreen;
		this.militaryScreen = militaryScreen;
		this.politicsScreen = politicsScreen;
		this.plotScreen = plotScreen;
		this.religionScreen = religionScreen;
		this .treasuryScreen = treasuryScreen;
		this.winScreen = winScreen;
	
		
	}
	
	
	
	/**
	 * Getters and setters *****************************************************************
	 */
	

	
	public void addToStack(Activity newActivity){
		activityStack.push(newActivity);
	}

	public DefeatScreen getDefeatScreen() {
		return defeatScreen;
	}

	public void setDefeatScreen(DefeatScreen defeatScreen) {
		this.defeatScreen = defeatScreen;
	}

	public DomesticScreen getDomesticScreen() {
		return domesticScreen;
	}

	public void setDomesticScreen(DomesticScreen domesticScreen) {
		this.domesticScreen = domesticScreen;
	}

	public MilitaryScreen getMilitaryScreen() {
		return militaryScreen;
	}

	public void setMilitaryScreen(MilitaryScreen militaryScreen) {
		this.militaryScreen = militaryScreen;
	}

	public PoliticsScreen getPoliticsScreen() {
		return politicsScreen;
	}

	public void setPoliticsScreen(PoliticsScreen politicsScreen) {
		this.politicsScreen = politicsScreen;
	}

	public PlotScreen getPlotScreen() {
		return plotScreen;
	}

	public void setPlotScreen(PlotScreen plotScreen) {
		this.plotScreen = plotScreen;
	}

	public ReligiousScreen getReligionScreen() {
		return religionScreen;
	}

	public void setReligionScreen(ReligiousScreen religionScreen) {
		this.religionScreen = religionScreen;
	}

	public TreasuryScreen getTreasuryScreen() {
		return treasuryScreen;
	}

	public void setTreasuryScreen(TreasuryScreen treasuryScreen) {
		this.treasuryScreen = treasuryScreen;
	}

	public WinScreen getWinScreen() {
		return winScreen;
	}

	public void setWinScreen(WinScreen winScreen) {
		this.winScreen = winScreen;
	}

	public Stack<Activity> getActivityStack() {
		return activityStack;
	}

	public void setActivityStack(Stack<Activity> activityStack) {
		this.activityStack = activityStack;
	}

	

	

	
	

}
