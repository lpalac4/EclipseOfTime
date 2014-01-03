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
	private Button infoButton;
	private Button militaryButton;
	private Button domesticButton;
	private Button plotButton;
	private Button politicsButton;
	private Button religionButton;
	private TextView instructionText;
	private String messageString = "Message needs to be set for this phase.";
	private String leftButtonString = "Military";
	private String rightButtonString = "Domestic";
	private GameScreen gameScreen;

	public BottomMenuView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		screenW = context.getResources().getDisplayMetrics().widthPixels;
		screenH = context.getResources().getDisplayMetrics().heightPixels;
		gameScreen = (GameScreen) context;
		
		int[] buttonSize = {(int)(screenW * 0.15), (int)(screenH * 0.09)};

		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		
		
		bottomHorizontalLayout = new LinearLayout(context);
		bottomHorizontalLayout.setLayoutParams(botLinearParams);
		bottomHorizontalLayout.setGravity(Gravity.BOTTOM | Gravity.CENTER);
		
		infoButton = new Button(context);
		infoButton.setText("Info");
		infoButton.setTextColor(Color.WHITE);
		infoButton.setTextSize(12);
		infoButton.setBackgroundResource(R.drawable.custom_button);
		infoButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		militaryButton = new Button(context);
		militaryButton.setText("Military");
		militaryButton.setTextColor(Color.WHITE);
		militaryButton.setTextSize(12);
		militaryButton.setBackgroundResource(R.drawable.custom_button);
		militaryButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		instructionText =  new TextView(context);
		instructionText.setTextColor(Color.WHITE);
		instructionText.setText(messageString);
		instructionText.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		instructionText.setGravity(Gravity.CENTER);
		
		plotButton = new Button(context);
		plotButton.setText("Plot");
		plotButton.setTextColor(Color.WHITE);
		plotButton.setTextSize(12);
		plotButton.setBackgroundResource(R.drawable.custom_button);
		plotButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		domesticButton = new Button(context);
		domesticButton.setText("Domestic");
		domesticButton.setTextColor(Color.WHITE);
		domesticButton.setTextSize(12);
		domesticButton.setBackgroundResource(R.drawable.custom_button);
		domesticButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		religionButton = new Button(context);
		religionButton.setText("Religion");
		religionButton.setTextColor(Color.WHITE);
		religionButton.setTextSize(12);
		religionButton.setBackgroundResource(R.drawable.custom_button);
		religionButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		politicsButton = new Button(context);
		politicsButton.setText("Politics");
		politicsButton.setTextColor(Color.WHITE);
		politicsButton.setTextSize(12);
		politicsButton.setBackgroundResource(R.drawable.custom_button);
		politicsButton.setLayoutParams(new LinearLayout.LayoutParams(buttonSize[0], buttonSize[1]));
		
		bottomHorizontalLayout.addView(militaryButton);
		bottomHorizontalLayout.addView(domesticButton);
		bottomHorizontalLayout.addView(religionButton);
		bottomHorizontalLayout.addView(politicsButton);
		bottomHorizontalLayout.addView(plotButton);
		bottomHorizontalLayout.addView(infoButton);
		
		infoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				gameScreen.showInfoOptions();
			}
		});
		
		militaryButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showMilitaryOptions();
				
			}
		});
		
		domesticButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showDomesticOptions();
				
			}
		});
		
		politicsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				gameScreen.showPoliticsOptions();
			}
		});
	
	
		plotButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showPlotOptions();
				
			}
		});
		
		religionButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				gameScreen.showReligionOptions();
				
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
