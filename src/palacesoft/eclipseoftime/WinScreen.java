package palacesoft.eclipseoftime;

import palacesoft.lostundertheshade.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WinScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.win_screen, menu);
		return true;
	}

}
