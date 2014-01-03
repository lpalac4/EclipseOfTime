package palacesoft.eclipseoftime;

import palacesoft.eclipseoftime.utils.SongArray;
import palacesoft.lostundertheshade.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MenuScreen extends Activity {

	private static final String TAG = MenuScreen.class.getSimpleName();
	
	private int screenWidth;
	private int screenHeight;
	private Button startGameButton; 
	private Button options;
	private Button help;
	private Button exit;
	private LinearLayout verticalLayout;
	private LinearLayout gravityLayout;
	private ImageView titleLogo;
	private FrameLayout hLayout;
	private FragmentManager fm;
	private Intent setupIntent;
	private MediaPlayer mediaPlayer;
	private SongArray songs;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		setupIntent = new Intent(this, SetupScreen.class);
		
		screenWidth = getResources().getDisplayMetrics().widthPixels; 
		screenHeight = getResources().getDisplayMetrics().heightPixels;
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams((int)(screenWidth * 0.2), (int)(screenHeight * 0.1));
		LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams((int)(screenWidth * 0.85), (int)(screenHeight * 0.9), Gravity.CENTER);
		
		startGameButton = new Button(this); 
		startGameButton.setText("Start Game");
		startGameButton.setTextSize(12);
		startGameButton.setTextColor(Color.WHITE);
		startGameButton.setBackgroundResource(R.drawable.custom_button);
		startGameButton.setLayoutParams(buttonParams);
		
		exit = new Button(this); 
		exit.setText("Exit");
		exit.setTextSize(12);
		exit.setTextColor(Color.WHITE);
		exit.setBackgroundResource(R.drawable.custom_button);
		exit.setLayoutParams(buttonParams);
		
		help = new Button(this); 
		help.setText("Help");
		help.setTextSize(12);
		help.setTextColor(Color.WHITE);
		help.setBackgroundResource(R.drawable.custom_button);
		help.setLayoutParams(buttonParams);
		
		options = new Button(this);
		options.setText("Options");
		options.setTextSize(12);
		options.setTextColor(Color.WHITE);
		options.setBackgroundResource(R.drawable.custom_button);
		
		options.setLayoutParams(buttonParams);
		
		titleLogo = new ImageView(this);
		titleLogo.setImageResource(R.drawable.game_logo);
		titleLogo.setLayoutParams(imageParams);
		
		verticalLayout = new LinearLayout(this);
		verticalLayout.setOrientation(LinearLayout.VERTICAL);
		verticalLayout.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		
		verticalLayout.addView(startGameButton);
		verticalLayout.addView(options);
		verticalLayout.addView(help);
		verticalLayout.addView(exit);
		
		LinearLayout imageGLayout = new LinearLayout(this);
		imageGLayout.setGravity(Gravity.CENTER | Gravity.LEFT);
		imageGLayout.addView(titleLogo);
		
		gravityLayout = new LinearLayout(this);
		gravityLayout.setGravity(Gravity.RIGHT|Gravity.CENTER);
		gravityLayout.addView(verticalLayout);
				
		hLayout = new FrameLayout(this);
		hLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		hLayout.addView(imageGLayout);
		hLayout.addView(gravityLayout);
		hLayout.setBackgroundColor(Color.BLACK);
		
		/* now declare and define the mediaplayer object */
		//mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.songs[0]);
		
		setContentView(hLayout);
		Log.d(TAG, "Setting Content View in menuScreen");
		
		//Defining the characteristics of each button
		startGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	startActivity(setupIntent);
            	
            }
        });
		
		options.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		help.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus){
		super.onWindowFocusChanged(hasFocus);
		
	}

}
