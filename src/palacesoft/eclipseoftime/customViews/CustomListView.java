package palacesoft.eclipseoftime.customViews;

import java.util.ArrayList;

import palacesoft.eclipseoftime.GameScreen;
import palacesoft.eclipseoftime.baseobjects.AbstractFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListView extends View {

	public int rowSize, columnSize;
	public LinearLayout finalLayout;
	public GameScreen gameScreen;
	public AbstractFragment fragmentParent;
	
	public CustomListView(Context context, AbstractFragment frag, ArrayList<String> columns) {
		super(context);
		
		rowSize = 1;
		columnSize = columns.size();
		gameScreen = (GameScreen)context;
		fragmentParent = frag;
		finalLayout = new LinearLayout(context);
		finalLayout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout rowView = new LinearLayout(context);
		if(columns != null){
			for(int i = 0; i < columnSize; i++){			
			TextView entryString = new TextView(context);
			entryString.setText(columns.get(i));
			rowView.addView(entryString);
			}
		}
		
		finalLayout.addView(rowView);
				
	}

	public CustomListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	/*
	 * Add content to the view and invalidate it to force a redraw()
	 */
	public void addContent(ArrayList<ArrayList<String>> entries){
		for(int i = 0; i < entries.size(); i++){
			LinearLayout rowView = new LinearLayout(gameScreen);
			for(int j = 0; j < entries.get(i).size(); j++){
				TextView columnView = new TextView(gameScreen);
				columnView.setText(entries.get(i).get(j));
				rowView.addView(columnView);
			}
			finalLayout.addView(rowView);
		}
		invalidate();
	}

	public View getView(){
		return finalLayout;
	}
}
