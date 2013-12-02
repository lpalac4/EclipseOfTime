/* This activity will create an options package that will be sent to the main gamescreen activity
 * to create the wanted game type.
 * @author Luis Palacios
 */

package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SetupScreen extends Activity {
private static final String TAG = SetupScreen.class.getSimpleName();
	
	private int counter;
	private TextView display;
	private Button plus;
	private Button minus;
	
	private LinearLayout h3Layout;
	private TextView numberOfPlayers;
	private LinearLayout verticalLayout;
	private Button startGameButton;
	private Intent gameScreenIntent;
	private int[] options = {30,3,40,20};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		gameScreenIntent = new Intent(SetupScreen.this, GameScreen.class);
		gameScreenIntent.putExtra("Options", options);
		
		numberOfPlayers = new TextView(this);
		numberOfPlayers.setText("Number of Players");
		numberOfPlayers.setTextColor(Color.WHITE);
		numberOfPlayers.setLayoutParams(buttonParams);
		
		counter = 2;
		plus = new Button(this);
		plus.setText("+");
		plus.setTextColor(Color.WHITE);
		plus.setLayoutParams(buttonParams);

		minus = new Button(this);
		minus.setText("-");
		minus.setTextColor(Color.WHITE);
		minus.setLayoutParams(buttonParams);
		
		display = new TextView(this);
		display.setText("      " + String.valueOf(counter) + "      ");
		display.setTextColor(Color.WHITE);
		display.setLayoutParams(buttonParams);
			
		plus.setOnClickListener(new View.OnClickListener() {
					
		    public void onClick(View v) {
		    if(counter != 6)
		    	counter++;
		    display.setText("      " + String.valueOf(counter) + "      ");
		    }
		});

		minus.setOnClickListener(new View.OnClickListener() {

		    public void onClick(View v) {
		    if(counter != 2)
		    	counter--;
		    display.setText("      " + String.valueOf(counter) + "      ");
		    }
		});
		
		LinearLayout h3TextLayout = new LinearLayout(this);
		h3TextLayout.setOrientation(LinearLayout.VERTICAL);
		h3TextLayout.addView(numberOfPlayers);
		h3TextLayout.setLayoutParams(layoutParams);
		
		h3Layout = new LinearLayout(this);
		h3Layout.setLayoutParams(layoutParams);
		h3Layout.setOrientation(LinearLayout.HORIZONTAL);
		h3Layout.addView(minus);
		h3Layout.addView(display);
		h3Layout.addView(plus);
		
		startGameButton = new Button(this);
		startGameButton.setText("Start Game");
		startGameButton.setTextColor(Color.WHITE);
		startGameButton.setBackgroundResource(R.drawable.custom_button);
		startGameButton.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		startGameButton.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				
				startActivity(gameScreenIntent);				
			}
		});
		TextView prepare = new TextView(this);
		prepare.setText("Game Setup");
		prepare.setTextColor(Color.WHITE);
		prepare.setTextSize(30);
		prepare.setLayoutParams(buttonParams);
		prepare.setGravity(Gravity.CENTER);
		
		LinearLayout h4Layout = new LinearLayout(this);
		h4Layout.setOrientation(LinearLayout.HORIZONTAL);
		h4Layout.setLayoutParams(layoutParams);
		
		LinearLayout.LayoutParams spacingLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		spacingLayout.setMargins(0, 50, 0, 0);
		
		verticalLayout = new LinearLayout(this);
		verticalLayout.setOrientation(LinearLayout.VERTICAL);
		verticalLayout.setBackgroundColor(Color.BLACK);
		prepare.setPadding(0, 0, 0, 50);
		verticalLayout.addView(prepare);
		verticalLayout.addView(h3TextLayout);
		verticalLayout.addView(h3Layout);
		
		verticalLayout.addView(startGameButton,spacingLayout);
		verticalLayout.setGravity(Gravity.CENTER);
		

		
		Log.d(TAG, "setttingContentView in SetupScreen");
		setContentView(verticalLayout);
		
		
		
		
		
		
		
		
		
	}


}
