/**
 * Startup Activity to display the logo for our team, with the implementation of a handler that 
 * will maintain this activity on top for the duration required.
 * @author Luis Palacios
 */

package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class StartUpActivity extends Activity {
	private static final String TAG = StartUpActivity.class.getSimpleName();
	private static final int STARTTIMER = 5000;
	
	private ImageView companyLogo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
			
			if(!isTaskRoot()){
				final Intent intent = getIntent();
				final String intentAction = intent.getAction();
				if(intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null && intentAction.equals(Intent.ACTION_MAIN)){
					Log.d(TAG,"additional duplicate activity opened finishing it");
					finish();
					return;
				}
			}
	        
	        companyLogo = new ImageView(this);
			companyLogo.setImageResource(R.drawable.game_logo);
			companyLogo.setBackgroundColor(Color.BLACK);
			companyLogo.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	                   
	        Handler timer = new Handler();
	        timer.postDelayed(
	        		new Runnable() {				
	        			@Override
	        			public void run() {
	        				startActivity(new Intent(StartUpActivity.this, MenuScreen.class));
	        				finish();
	        			}
	        		}, STARTTIMER);
	        
	        Log.d(TAG, "Leaving SplashScreen");
	        
	        setContentView(companyLogo);
	    
	}

}
