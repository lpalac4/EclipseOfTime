package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;


public class BottomMenuMilitary extends View {

	private Button draftButton;
	private Button trainButton;
	private Button warButton;
	private LinearLayout bottomHorizontalLayout;
	private GameScreen gameScreen;
	
	public BottomMenuMilitary(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		draftButton = new Button(context);
		draftButton.setText("Draft");
		draftButton.setTextColor(Color.WHITE);
		draftButton.setTextSize(12);
		draftButton.setBackgroundResource(R.drawable.custom_button);
		draftButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		draftButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showMilitaryScreen();
				gameScreen.getMilitaryFrag().showDraftView();				
			}
		});
		
		warButton = new Button(context);
		warButton.setText("War");
		warButton.setTextColor(Color.WHITE);
		warButton.setTextSize(12);
		warButton.setBackgroundResource(R.drawable.custom_button);
		warButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		warButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				/* show WAR activity */			
			}
		});
		
		trainButton = new Button(context);
		trainButton.setText("Train");
		trainButton.setTextColor(Color.WHITE);
		trainButton.setTextSize(12);
		trainButton.setBackgroundResource(R.drawable.custom_button);
		trainButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		trainButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showMilitaryScreen();	
				gameScreen.getMilitaryFrag().showTrainView();
			}
		});
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(draftButton);
		bottomHorizontalLayout.addView(trainButton);
		bottomHorizontalLayout.addView(warButton);
		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}

}
