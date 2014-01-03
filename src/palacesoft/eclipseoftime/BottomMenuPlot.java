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

public class BottomMenuPlot extends View {

	private Button riotButton;
	private Button scandalButton;
	private Button assassinateButton;
	private Button sabotageButton;
	private Button arsonButton;
	private GameScreen gameScreen;
	
	private LinearLayout bottomHorizontalLayout;

	
	public BottomMenuPlot(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		riotButton = new Button(context);
		riotButton.setText("Riot");
		riotButton.setTextColor(Color.WHITE);
		riotButton.setTextSize(12);
		riotButton.setBackgroundResource(R.drawable.custom_button);
		riotButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		riotButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPlotFrag().showRiotView();
				gameScreen.showPlotScreen();
			}
		});
		
		assassinateButton = new Button(context);
		assassinateButton.setText("Assassinate");
		assassinateButton.setTextColor(Color.WHITE);
		assassinateButton.setTextSize(12);
		assassinateButton.setBackgroundResource(R.drawable.custom_button);
		assassinateButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		assassinateButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPlotFrag().showAssassinateView();
				gameScreen.showPlotScreen();
			}
		});
		
		scandalButton = new Button(context);
		scandalButton.setText("Scandal");
		scandalButton.setTextColor(Color.WHITE);
		scandalButton.setTextSize(12);
		scandalButton.setBackgroundResource(R.drawable.custom_button);
		scandalButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		scandalButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPlotFrag().showScandalView();
				gameScreen.showPlotScreen();
			}
		});
		
		sabotageButton = new Button(context);
		sabotageButton.setText("Sabotage");
		sabotageButton.setTextColor(Color.WHITE);
		sabotageButton.setTextSize(12);
		sabotageButton.setBackgroundResource(R.drawable.custom_button);
		sabotageButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		sabotageButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPlotFrag().showSabotageView();
				gameScreen.showPlotScreen();
			}
		});
		
		arsonButton = new Button(context);
		arsonButton.setText("Arson");
		arsonButton.setTextColor(Color.WHITE);
		arsonButton.setTextSize(12);
		arsonButton.setBackgroundResource(R.drawable.custom_button);
		arsonButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		arsonButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.getPlotFrag().showArsonView();
				gameScreen.showPlotScreen();
			}
		});
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(riotButton);
		bottomHorizontalLayout.addView(scandalButton);
		bottomHorizontalLayout.addView(assassinateButton);
		bottomHorizontalLayout.addView(sabotageButton);
		bottomHorizontalLayout.addView(arsonButton);
		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}
}
