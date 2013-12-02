package palacesoft.eclipseoftime.mapview;

import java.util.ArrayList;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Pair;
import android.view.MotionEvent;

public class MapView extends GLSurfaceView {

	private MapRenderer mapRenderer;
	private ArrayList<Integer> pointID;
	private ArrayList<Pair<Float,Float>> touchPoints;
	
	//constants controlling how fast and until when translation occurs
	private static final float SCALE_FACTOR = 0.005f;
	private static final float SCALE_MAX = 0.1f;
	private static final float TRANSLATION_FACTOR = .000064f;
	private static final float TRANSLATION_MAX_X = 1.5f;
	private static final float TRANSLATION_MAX_Y = 1f;

	public MapView(Context context){
		super(context);

		mapRenderer = new MapRenderer(context); 
		pointID = new ArrayList<Integer>();
		touchPoints = new ArrayList<Pair<Float,Float>>();

		setDebugFlags(DEBUG_CHECK_GL_ERROR | DEBUG_LOG_GL_CALLS);
		setRenderer(mapRenderer);
		/* Render the only when state has changed */
		setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);		
		
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	@Override
	public void onResume() {
		super.onResume();
	}
	/**
	 * Override the GLSurfaceView onTouchEvent to allow for translation of the map.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		float x = e.getX();
		float y = e.getY();
		
		switch (e.getAction()) {
		/* finger first touches down */
		case MotionEvent.ACTION_DOWN:
			if(pointID.isEmpty()){
				pointID.add(e.getPointerId(0));
				Pair<Float, Float> newPair = new Pair<Float,Float>(e.getX(),e.getY());
				touchPoints.add(newPair);
			}
			break;
		/* finger is moving across the screen */
		case MotionEvent.ACTION_MOVE:
			/* get pointer id */
			int thisPointId = pointID.get(0);
			int ithPointer = e.findPointerIndex(thisPointId);
			/* grab the coordinate for the ithPointer in the gesture */
			float thisX = e.getX(ithPointer);
			float thisY = e.getY(ithPointer);
			Pair<Float,Float> thisPair = touchPoints.get(0);
			/* translation calculated after every move update */
			float xDiff = thisX - thisPair.first;
			float yDiff = thisY - thisPair.second;
			/* store the most recent touch point */
			thisPair = Pair.create(thisX, thisY);
			/* adjust the view port with the calculated values */
			if((mapRenderer.getViewPortX() < TRANSLATION_MAX_X && xDiff > 0) || 
					(mapRenderer.getViewPortX() > -TRANSLATION_MAX_X && xDiff < 0)){
				/* adjust the view port */
				mapRenderer.setViewPortX(mapRenderer.getViewPortX() + xDiff*TRANSLATION_FACTOR);
				/* adjust the center so we can still calculate the point on the map being clicked on */
				mapRenderer.setCenterX(mapRenderer.getCenterX() + xDiff*TRANSLATION_FACTOR);
			}
			/* check the translation is within bounds */
			if ((mapRenderer.getViewPortY() < TRANSLATION_MAX_Y && yDiff > 0) || 
					(mapRenderer.getViewPortY() > -TRANSLATION_MAX_Y && yDiff < 0)) {
				/* translate in the y direction */
				mapRenderer.setViewPortY(mapRenderer.getViewPortY() + yDiff*TRANSLATION_FACTOR);
				/* offset the center */
				mapRenderer.setCenterY(mapRenderer.getCenterY() + yDiff*TRANSLATION_FACTOR);
			}
			break;
		/* Finger is lifted off the screen */
		case MotionEvent.ACTION_UP:
			pointID.clear();
			touchPoints.clear();
			break;
		}

		requestRender();

		return true;
	}
}


