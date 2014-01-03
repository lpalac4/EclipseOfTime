package palacesoft.eclipseoftime.mapview;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL10Ext;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;

public class MapView extends GLSurfaceView {

	private MapRenderer mapRenderer;
	private ArrayList<Integer> pointID;
	private ArrayList<Pair<Float,Float>> touchPoints;
	private float distanceBetweenPoints;
	private int viewH;
	private int viewW;

	//constants controlling how fast and until when translation occurs
	private static final float SCALE_FACTOR = 0.008f;
	private static final float SCALE_MAX = 2.0f;
	private static final float SCALE_MIN = -2.0f;
	private static final float TRANSLATION_FACTOR = .000064f;
	private static final float TRANSLATION_MAX_X = 1.5f;
	private static final float TRANSLATION_MAX_Y = 1f;
	private boolean zoomMode = false;

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
		int touchNum = e.getPointerCount();
		int pointerIndex = e.getActionIndex();
		int pointerId = e.getPointerId(pointerIndex);
		int maskedAction = e.getActionMasked();
		float touchX = e.getX(pointerIndex);
		float touchY = e.getY(pointerIndex);
		
		if(touchNum > 1)
			zoomMode = true;
		else 
			zoomMode = false;

		switch (maskedAction) {
		/* finger first touches down */
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_POINTER_DOWN:
			Pair<Float,Float> newPoint = new Pair<Float,Float>(e.getX(pointerIndex), e.getY(pointerIndex));
			touchPoints.add(newPoint);
			pointID.add(pointerId);
			
			if(zoomMode && (touchPoints.size() == 2)){
				float fingerOneX = touchPoints.get(0).first;
				float fingerOneY = touchPoints.get(0).second;
				float fingerTwoX = touchPoints.get(1).first;
				float fingerTwoY = touchPoints.get(1).second;
				distanceBetweenPoints = (float) Math.sqrt(Math.pow(fingerOneX - fingerTwoX, 2) + Math.pow(fingerOneY - fingerTwoY, 2));
			}
			break;
			/* finger is moving across the screen */
		case MotionEvent.ACTION_MOVE:
			if(!zoomMode){
				/* get pointer id */
				int thisPointId = pointID.get(0);
				int ithPointer = e.findPointerIndex(thisPointId);
				/* grab the coordinate for the ithPointer in the gesture */
				float thisX = e.getX(ithPointer);
				float thisY = e.getY(ithPointer);
				Pair<Float,Float> storedCoord = touchPoints.get(0);
				/* translation calculated after every move update */
				float xDiff = thisX - storedCoord.first;
				float yDiff = thisY - storedCoord.second;
				/* store the most recent touch point */
				storedCoord = Pair.create(thisX, thisY);
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
			}
			else if(zoomMode && touchPoints.size() == 2){
				/* use the stored pointer id to locate where that pointer(finger) is now */
				int fingerOneInitPointId = pointID.get(0);
				int fingerTwoInitPointId = pointID.get(1);
				int updatedFingerOnePointId = e.findPointerIndex(fingerOneInitPointId);
				int updatedFingerTwoPointId = e.findPointerIndex(fingerTwoInitPointId);
				/* get the new coordinates at the most recent contact for finger one */
				float fingerOneUpdatedX = e.getX(updatedFingerOnePointId);
				float fingerOneUpdatedY = e.getY(updatedFingerOnePointId);

				/* get the new coordinates for the second finger(pointer) now */
				float fingerTwoUpdatedX = e.getX(updatedFingerTwoPointId);
				float fingerTwoUpdatedY = e.getY(updatedFingerTwoPointId);
 
				/* find the distance between fingers and compare that with the distance between the two fingers on the last gesture callback */
				float distanceOfNewPoints = (float) Math.sqrt(Math.pow((fingerOneUpdatedX - fingerTwoUpdatedX),2) + Math.pow((fingerOneUpdatedY - fingerTwoUpdatedY), 2));
				float ratioBetweenDistances = distanceOfNewPoints / distanceBetweenPoints;
				
				/* store the new distance for later use */
				distanceBetweenPoints = distanceOfNewPoints;
				if(ratioBetweenDistances > 1.0 && mapRenderer.getViewPortZoom() < SCALE_MAX){
					mapRenderer.setViewPortZoom(mapRenderer.getViewPortZoom() + SCALE_FACTOR);
				}else if(ratioBetweenDistances < 1.0 && mapRenderer.getViewPortZoom() > SCALE_MIN){
					mapRenderer.setViewPortZoom(mapRenderer.getViewZoom() - SCALE_FACTOR);
				}
				/* use that ratio of distance to adjust the zoom on the view matrix */
//				if((mapRenderer.getViewPortZoom() < SCALE_MAX && ratioBetweenDistances < 1) || 
//						(mapRenderer.getViewPortZoom() > -SCALE_MAX && ratioBetweenDistances > 1)) {
//					mapRenderer.setViewPortZoom(ratioBetweenDistances);
//					mapRenderer.setViewPortZoom(mapRenderer.getViewPortZoom() + ratioBetweenDistances * SCALE_FACTOR);
//				}
			}
			break;
			/* Finger is lifted off the screen */
		case MotionEvent.ACTION_UP:
			/* if in zoom mode don't clear the stored points until the second up gesture */
		case MotionEvent.ACTION_POINTER_UP:
			int upPointer = pointID.indexOf(pointerId);
			pointID.remove(upPointer);
			touchPoints.remove(upPointer);
			//requestRender();
			//return false;
		}
		requestRender();
		return true;
	}
	
	public Pair<Float,Float> viewCoordToWorldCoord(Pair<Float,Float> touch){
		
		// Initialize auxiliary variables.
		Pair<Float,Float> worldCoord = null;
		
	    return worldCoord;  
	}
	
}


