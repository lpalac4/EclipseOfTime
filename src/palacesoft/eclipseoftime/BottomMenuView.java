package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomMenuView extends View {

	private int screenW;
	private int screenH;
	private LinearLayout bottomHorizontalLayout;
	private Button acceptSelection;
	private Button resetSelection;
	private TextView instructionText;
	private Button continueButton;
	private ImageView playerIndicator;
	private String messageString = "Message needs to be set for this phase.";
	private String leftButtonString = "Reset";
	private String rightButtonString = "Confirm";
	private GameScreen gameScreen;

	public BottomMenuView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		screenW = context.getResources().getDisplayMetrics().widthPixels;
		screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] playerIndicatorSize = {(int)(screenW * 0.1),(int)(screenH * 0.10)};
		int[] messageSize = {(int)(screenW * 0.5),(int)(screenH * 0.1)};
		int[] acceptButtonSize = {(int)(screenW * 0.15), (int)(screenH * 0.1)};
		int[] resetButtonSize = {(int)(screenW * 0.15), (int)(screenH * 0.1)};
		int[] continueIconSize = {(int)(screenW * 0.1), (int)(screenH * 0.1)};

		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		acceptSelection = new Button(context);
		acceptSelection.setText(rightButtonString);
		acceptSelection.setTextColor(Color.WHITE);
		acceptSelection.setTextSize(12);
		acceptSelection.setBackgroundResource(R.drawable.custom_button);
		acceptSelection.setLayoutParams(new LinearLayout.LayoutParams(acceptButtonSize[0], acceptButtonSize[1]));
		
		resetSelection = new Button(context);
		resetSelection.setText(leftButtonString);
		resetSelection.setTextColor(Color.WHITE);
		resetSelection.setTextSize(12);
		resetSelection.setBackgroundResource(R.drawable.custom_button);
		resetSelection.setLayoutParams(new LinearLayout.LayoutParams(resetButtonSize[0], resetButtonSize[1]));
		
		instructionText =  new TextView(context);
		instructionText.setTextColor(Color.WHITE);
		instructionText.setText(messageString);
		instructionText.setLayoutParams(new LayoutParams(messageSize[0], messageSize[1]));
		instructionText.setGravity(Gravity.CENTER);
		
		continueButton = new Button(context);
		continueButton.setBackgroundResource(R.drawable.continue_icon);
		continueButton.setLayoutParams(new LinearLayout.LayoutParams(continueIconSize[0], continueIconSize[1]));
		
		playerIndicator = new ImageView(context);
		playerIndicator.setImageResource(R.drawable.player_indicator);
		playerIndicator.setLayoutParams(new LinearLayout.LayoutParams(playerIndicatorSize[0], playerIndicatorSize[1]));
		
		bottomHorizontalLayout.addView(playerIndicator);
		bottomHorizontalLayout.addView(resetSelection);
		bottomHorizontalLayout.addView(instructionText);
		bottomHorizontalLayout.addView(acceptSelection);
		bottomHorizontalLayout.addView(continueButton);
		
		acceptSelection.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gameScreen.showDomesticScreen();
			}
		});
		
		resetSelection.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		continueButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		playerIndicator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public View getView(){
		return bottomHorizontalLayout;
	}
	
	public void setMessageString(String newMessage){
		messageString = newMessage;
	}
	
	public void setLeftButtonString(String buttonString){
		leftButtonString = buttonString;
	}
	
	public void setRightButtonString(String buttonString){
		rightButtonString = buttonString;
	}
}
