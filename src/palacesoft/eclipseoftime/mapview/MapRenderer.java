package palacesoft.eclipseoftime.mapview;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLU;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import android.util.Pair;

public class MapRenderer implements GLSurfaceView.Renderer{

	/* give the renderer application environment */
	private Context context;
	/* the object to be drawn by renderer */
	private MapObject mapObject;
	/* values to be used for translation */
	private float viewPortX, viewPortY, viewPortZ, centerX, centerY, centerZ;
	private GL10 storedGl;

	public MapRenderer(Context context) {
		this.context = context;
		viewPortX = 0;
		viewPortY = 0;
		viewPortZ = -1.0f;
		centerX = 0;
		centerY = 0;
		centerZ = 0;
		mapObject = new MapObject();
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		/* clear screen and depth buffer */
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		/* reset model view matrix */
		gl.glLoadIdentity();
		/* to translate im only changing where the camera is located */
		gl.glTranslatef(viewPortX, -viewPortY, viewPortZ);	
		mapObject.drawMap(gl);						
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		if(height == 0) { 						
			height = 1; 						
		}
		
		gl.glViewport(0, 0, width, height); 	
		gl.glMatrixMode(GL10.GL_PROJECTION); 	
		gl.glLoadIdentity(); 					

		/* recalculate aspect ratio for new window dimensions */
		GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);

		gl.glMatrixMode(GL10.GL_MODELVIEW); 	
		gl.glLoadIdentity(); 
		storedGl = gl;
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// Load the texture for the square
		mapObject.loadGLTexture(gl, context);
		
		gl.glEnable(GL10.GL_TEXTURE_2D);			
		gl.glShadeModel(GL10.GL_SMOOTH); 			
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); 	
		gl.glClearDepthf(1.0f); 					
		gl.glEnable(GL10.GL_DEPTH_TEST); 			
		gl.glDepthFunc(GL10.GL_LEQUAL); 			
				
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); 
		storedGl = gl;
	}
	

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public MapObject getMapObject() {
		return mapObject;
	}

	public void setMapObject(MapObject mapObject) {
		this.mapObject = mapObject;
	}

	public float getViewPortX() {
		return viewPortX;
	}

	public void setViewPortX(float viewPortX) {
		this.viewPortX = viewPortX;
	}

	public float getViewPortY() {
		return viewPortY;
	}

	public void setViewPortY(float viewPortY) {
		this.viewPortY = viewPortY;
	}

	public float getCenterX() {
		return centerX;
	}

	public void setCenterX(float centerX) {
		this.centerX = centerX;
	}

	public float getCenterY() {
		return centerY;
	}

	public void setCenterY(float centerY) {
		this.centerY = centerY;
	}

	public float getViewPortZoom() {
		return viewPortZ;
	}

	public float getViewZoom() {
		return viewPortZ;
	}

	public void setViewPortZoom(float f) {
		viewPortZ = f;
		
	}

	
}
