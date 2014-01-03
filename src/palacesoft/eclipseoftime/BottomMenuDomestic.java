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

public class BottomMenuDomestic extends View{
	
	private Button craftButton;
	private Button buildButton;
	private GameScreen gameScreen;
	private Button maintenanceButton;
	
	private LinearLayout bottomHorizontalLayout;
	
	public BottomMenuDomestic(Context context) {
		super(context);
		
		int screenW = context.getResources().getDisplayMetrics().widthPixels;
		int screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		craftButton = new Button(context);
		craftButton.setText("Craft");
		craftButton.setTextColor(Color.WHITE);
		craftButton.setTextSize(12);
		craftButton.setBackgroundResource(R.drawable.custom_button);
		craftButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		craftButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showDomesticScreen();
				gameScreen.getDomesticFrag().showCraftOptions();				
			}
		});
		
		buildButton = new Button(context);
		buildButton.setText("Build");
		buildButton.setTextColor(Color.WHITE);
		buildButton.setTextSize(12);
		buildButton.setBackgroundResource(R.drawable.custom_button);
		buildButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		buildButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showDomesticScreen();
				gameScreen.getDomesticFrag().showBuildOptions();
			}
		});
		
		maintenanceButton = new Button(context);
		maintenanceButton.setText("Maintenance");
		maintenanceButton.setTextColor(Color.WHITE);
		maintenanceButton.setTextSize(12);
		maintenanceButton.setBackgroundResource(R.drawable.custom_button);
		maintenanceButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		maintenanceButton.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				gameScreen.showDomesticScreen();
				gameScreen.getDomesticFrag().showMaintenanceOptions();
				
			}
		});
		
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		bottomHorizontalLayout.addView(craftButton);
		bottomHorizontalLayout.addView(buildButton);
		bottomHorizontalLayout.addView(maintenanceButton);
		
	}
	
	public View getView(){
		return bottomHorizontalLayout;
	}

}
