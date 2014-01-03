package palacesoft.eclipseoftime;

import java.util.List;


import palacesoft.lostundertheshade.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Pair;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DefeatScreen extends Activity {

	String message;
	List<Pair<String, Integer>> finalStandings;
	Button continueButton;
	ImageView background;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_defeat_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.defeat_screen, menu);
		return true;
	}

}
