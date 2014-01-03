package palacesoft.eclipseoftime;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.LinearGradient;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MilitaryScreen extends Fragment {

	private FrameLayout finalLayout;
	
	private TextView trainDuration;
	private int trainMonths;
	private Button increaseMonth;
	private Button decreaseMonth;
	
	private TextView draftCount;
	private int[] draftNumber = {0,0,0,0};
	private int draftNumberIndex;
	private Button increaseDraftNumber;
	private Button decreaseDraftNumber;
	private Button increaseDigit;
	private Button decreaseDigit;
	
	private LinearLayout trainView;
	private LinearLayout draftView;
	
	public MilitaryScreen getFragment(){
		MilitaryScreen militaryScreen = new MilitaryScreen();
		
		return militaryScreen;
	}
	
	public void showDraftView(){
		hideViews();
		draftView.setVisibility(View.VISIBLE);
	}
	
	public void showTrainView(){
		hideViews();
		trainView.setVisibility(View.VISIBLE);
	}
	
	public void hideViews(){
		draftView.setVisibility(View.GONE);
		trainView.setVisibility(View.GONE);
	}
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		finalLayout = new FrameLayout(getActivity());
		
		trainDuration = new TextView(getActivity());
		trainMonths = 1;
		trainDuration.setText(String.valueOf(trainMonths));
		increaseMonth = new Button(getActivity());
		decreaseMonth = new Button(getActivity());
		trainView = new LinearLayout(getActivity());
		
		draftCount = new TextView(getActivity());
		draftNumberIndex = 0;
		draftCount.setText(convertArrayToString());
		increaseDraftNumber = new Button(getActivity());
		decreaseDraftNumber = new Button(getActivity());
		increaseDigit = new Button(getActivity());
		decreaseDigit = new Button(getActivity());
		draftView = new LinearLayout(getActivity());
		
		
		LinearLayout.LayoutParams layoutCenter = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		layoutCenter.gravity = Gravity.CENTER;
		trainView.setLayoutParams(layoutCenter);
		draftView.setLayoutParams(layoutCenter);
		draftView.setOrientation(LinearLayout.VERTICAL);
		trainView.setOrientation(LinearLayout.VERTICAL);
		
		LinearLayout sublayout = new LinearLayout(getActivity());
		sublayout.setLayoutParams(layoutCenter);
		TextView trainViewMessage = new TextView(getActivity());
		trainViewMessage.setText("How long should we train?");
		sublayout.addView(decreaseMonth);
		sublayout.addView(trainDuration);
		sublayout.addView(increaseMonth);
		trainView.addView(trainViewMessage);
		trainView.addView(sublayout);
		
		LinearLayout sublayout1 = new LinearLayout(getActivity());
		sublayout1.setLayoutParams(layoutCenter);
		TextView trainViewMessage1 = new TextView(getActivity());
		trainViewMessage1.setText("How many soldiers should we draft?");
		sublayout1.addView(decreaseDigit);
		sublayout1.addView(draftCount);
		sublayout1.addView(increaseDigit);
		draftView.addView(trainViewMessage1);
		draftView.addView(increaseDraftNumber);
		draftView.addView(sublayout1);
		draftView.addView(decreaseDraftNumber);
		
		increaseMonth.setText("+");
		increaseMonth.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				if(trainMonths < 12)
					trainDuration.setText(String.valueOf(++trainMonths));				
			}
		});
		
		decreaseMonth.setText("-");
		decreaseMonth.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(trainMonths > 1)
				trainDuration.setText(String.valueOf(--trainMonths));
				
			}
		});
		
		increaseDraftNumber.setText("+");
		increaseDraftNumber.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(draftNumber[draftNumberIndex] < 9){
					draftNumber[draftNumberIndex]++;
					draftCount.setText(convertArrayToString());
				}
			}
		});
		
		decreaseDraftNumber.setText("-");
		decreaseDraftNumber.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(draftNumber[draftNumberIndex] > 0){
					draftNumber[draftNumberIndex]--;
					draftCount.setText(convertArrayToString());
				}
			}
		});
		
		increaseDigit.setText(">");
		increaseDigit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(draftNumberIndex < 3)
				draftNumberIndex++;				
			}
		});
		
		decreaseDigit.setText("<");
		decreaseDigit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(draftNumberIndex > 0)
					draftNumberIndex--;
			}
		});
		
		
		finalLayout.addView(draftView);
		finalLayout.addView(trainView);
		
		hideViews();
		
	}
	
	private String convertArrayToString() {
		String str = new String();
		for(int i : draftNumber)
			str += String.valueOf(i);
		return str;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return finalLayout;
	}
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
}
