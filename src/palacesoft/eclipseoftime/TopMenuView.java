package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopMenuView extends View {
	private LinearLayout topHorizontalLayout;
	private TextView phaseTurnLabel;
	private ImageView phaseIcon;
	private ImageView settingsIcon;
	private int screenW;
	private int screenH;
	
	public TopMenuView(Context context) {
		super(context);
		screenW = context.getResources().getDisplayMetrics().widthPixels;
		screenH = context.getResources().getDisplayMetrics().heightPixels;
		
		int[] phaseIconSize = {(int)(screenW * 0.1), (int)(screenH * 0.10)};
		int[] phaseTextSize = {(int)(screenW * 0.4), (int)(screenH * 0.10)};
		int[] settingsSize = {(int)(screenW * 0.1), (int)(screenH * 0.10)};
		
		LinearLayout.LayoutParams botLinearParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		topHorizontalLayout = new LinearLayout(context);
		topHorizontalLayout.setLayoutParams(botLinearParams);
		topHorizontalLayout.setGravity(Gravity.TOP|Gravity.CENTER);
		
		phaseTurnLabel = new TextView(context);
		phaseTurnLabel.setBackgroundResource(R.drawable.phase_label);
		LinearLayout.LayoutParams phaseTextPadding = new LinearLayout.LayoutParams(phaseTextSize[0], phaseTextSize[1]);
		phaseTextPadding.setMargins((int)(screenW * 0.2), 0, (int)(screenW * 0.2), 0);
		
		phaseIcon = new ImageView(context);
		phaseIcon.setBackgroundResource(R.drawable.phase_icon);
		phaseIcon.setLayoutParams(new LinearLayout.LayoutParams(phaseIconSize[0], phaseIconSize[1]));
		
		settingsIcon = new ImageView(context);
		settingsIcon.setBackgroundResource(R.drawable.settings_icon);
		settingsIcon.setLayoutParams(new LinearLayout.LayoutParams(settingsSize[0], settingsSize[1]));
		
		topHorizontalLayout.addView(phaseIcon);
		topHorizontalLayout.addView(phaseTurnLabel, phaseTextPadding);
		topHorizontalLayout.addView(settingsIcon);
		
	}

	public View getView(){
		return topHorizontalLayout;
		
	}
	

}
