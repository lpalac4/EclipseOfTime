package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class BottomMenuInfo extends View{

	private Button militaryInfoButton;
	private Button kingdomInfoButton;
	private Button rosterInfoButton;
	private Button foreignInfoButton;
	private Button disasterInfoButton;
	private GameScreen gameScreen;
	private LinearLayout bottomHorizontalLayout;

	
	public BottomMenuInfo(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		militaryInfoButton = new Button(context);
		militaryInfoButton.setText("Military");
		militaryInfoButton.setTextColor(Color.WHITE);
		militaryInfoButton.setTextSize(12);
		militaryInfoButton.setBackgroundResource(R.drawable.custom_button);
		militaryInfoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		militaryInfoButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getInfoFrag().showMilitaryInfo();
				gameScreen.showInfoScreen();				
			}
		});
		
		rosterInfoButton = new Button(context);
		rosterInfoButton.setText("Roster");
		rosterInfoButton.setTextColor(Color.WHITE);
		rosterInfoButton.setTextSize(12);
		rosterInfoButton.setBackgroundResource(R.drawable.custom_button);
		rosterInfoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		rosterInfoButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getInfoFrag().showRosterInfo();
				gameScreen.showInfoScreen();
			}
		});
		
		kingdomInfoButton = new Button(context);
		kingdomInfoButton.setText("Kingdom");
		kingdomInfoButton.setTextColor(Color.WHITE);
		kingdomInfoButton.setTextSize(12);
		kingdomInfoButton.setBackgroundResource(R.drawable.custom_button);
		kingdomInfoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		kingdomInfoButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getInfoFrag().showKingdomInfo();	
				gameScreen.showInfoScreen();
			}
		});
		
		foreignInfoButton = new Button(context);
		foreignInfoButton.setText("Foreign");
		foreignInfoButton.setTextColor(Color.WHITE);
		foreignInfoButton.setTextSize(12);
		foreignInfoButton.setBackgroundResource(R.drawable.custom_button);
		foreignInfoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		foreignInfoButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getInfoFrag().showForeignInfo();
				gameScreen.showInfoScreen();
			}
		});
		
		disasterInfoButton = new Button(context);
		disasterInfoButton.setText("Disasters");
		disasterInfoButton.setTextColor(Color.WHITE);
		disasterInfoButton.setTextSize(12);
		disasterInfoButton.setBackgroundResource(R.drawable.custom_button);
		disasterInfoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		disasterInfoButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				//gameScreen.getInfoFrag().showDisasterInfo();
				//gameScreen.showInfoScreen();
			}
		});
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(militaryInfoButton);
		bottomHorizontalLayout.addView(kingdomInfoButton);
		bottomHorizontalLayout.addView(rosterInfoButton);
		bottomHorizontalLayout.addView(foreignInfoButton);
		bottomHorizontalLayout.addView(disasterInfoButton);
		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}
}
