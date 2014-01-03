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

public class BottomMenuPolitics extends View {

	private Button hireButton;
	private Button giftButton;
	private Button marryButton;
	private Button awardButton;
	private GameScreen gameScreen;
	
	private LinearLayout bottomHorizontalLayout;

	
	public BottomMenuPolitics(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		hireButton = new Button(context);
		hireButton.setText("Hire");
		hireButton.setTextColor(Color.WHITE);
		hireButton.setTextSize(12);
		hireButton.setBackgroundResource(R.drawable.custom_button);
		hireButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		hireButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPoliticsFrag().showHireView();
				gameScreen.showPoliticsScreen();
			}
		});
		
		marryButton = new Button(context);
		marryButton.setText("Marriage");
		marryButton.setTextColor(Color.WHITE);
		marryButton.setTextSize(12);
		marryButton.setBackgroundResource(R.drawable.custom_button);
		marryButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		marryButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPoliticsFrag().showMarryView();
				gameScreen.showPoliticsScreen();
				
			}
		});
		
		giftButton = new Button(context);
		giftButton.setText("Trade");
		giftButton.setTextColor(Color.WHITE);
		giftButton.setTextSize(12);
		giftButton.setBackgroundResource(R.drawable.custom_button);
		giftButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		giftButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPoliticsFrag().showTradeView();
				gameScreen.showPoliticsScreen();
				
			}
		});
		
		awardButton = new Button(context);
		awardButton.setText("Award");
		awardButton.setTextColor(Color.WHITE);
		awardButton.setTextSize(12);
		awardButton.setBackgroundResource(R.drawable.custom_button);
		awardButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		awardButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPoliticsFrag().showAwardView();
				gameScreen.showPoliticsScreen();
			}
		});
		
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(hireButton);
		bottomHorizontalLayout.addView(giftButton);
		bottomHorizontalLayout.addView(marryButton);
		bottomHorizontalLayout.addView(awardButton);
		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}
}
