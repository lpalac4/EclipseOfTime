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

public class BottomMenuReligion extends View {

	private Button sacrificeButton;
	private Button heathensButton;
	private Button divineButton;
	private GameScreen gameScreen; 
	private LinearLayout bottomHorizontalLayout;
	
	public BottomMenuReligion(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		sacrificeButton = new Button(context);
		sacrificeButton.setText("Sacrifice");
		sacrificeButton.setTextColor(Color.WHITE);
		sacrificeButton.setTextSize(12);
		sacrificeButton.setBackgroundResource(R.drawable.custom_button);
		sacrificeButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		sacrificeButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showReligiousScreen();
				gameScreen.getReligionFrag().showSacrificeViews();
				
			}
		});
		
		divineButton = new Button(context);
		divineButton.setText("Divine Right");
		divineButton.setTextColor(Color.WHITE);
		divineButton.setTextSize(12);
		divineButton.setBackgroundResource(R.drawable.custom_button);
		divineButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		divineButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showReligiousScreen();
				gameScreen.getReligionFrag().showDivineRightViews();
				
			}
		});
		
		heathensButton = new Button(context);
		heathensButton.setText("Heathens");
		heathensButton.setTextColor(Color.WHITE);
		heathensButton.setTextSize(12);
		heathensButton.setBackgroundResource(R.drawable.custom_button);
		heathensButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		heathensButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showReligiousScreen();
				gameScreen.getReligionFrag().showHeathenViews();
				
			}
		});
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(sacrificeButton);
		bottomHorizontalLayout.addView(heathensButton);
		bottomHorizontalLayout.addView(divineButton);

		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}
}
