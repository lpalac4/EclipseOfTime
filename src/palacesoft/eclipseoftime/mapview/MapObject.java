package palacesoft.eclipseoftime.mapview;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import palacesoft.lostundertheshade.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class MapObject {

	/* this buffer will hold points for our map object */
	private FloatBuffer vertexBuffer;
	/* this buffer will hold texture mappings */
	private FloatBuffer textureBuffer;
	
	/* this map will be rectangular with a bit larger width than height */
	private float vertices[] = { 
			-1.5f, -1.0f, 0.0f,	//bottom left
			-1.5f, 1.0f, 0.0f, 	//top left
			1.5f, -1.0f, 0.0f,	//bottom right
			1.5f, 1.0f, 0.0f	//top right
	};
	/* the mapping for the map image onto the mesh i defined in vertices */
	private float mapMesh[] = {
			0.0f, 1.0f, 	//top left
			0.0f, 0.0f,		//bottom left
			1.5f, 1.0f,		//top right
			1.5f, 0.0f		//bottom right
	};
	
	private int[] textureArray = new int[1];
	
	/**
	 * Public constructor
	 */
	public MapObject(){
		/* allocate the necessary memory for our 4 vertices each being 4 bytes */
		ByteBuffer vertexByteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
		vertexByteBuffer.order(ByteOrder.nativeOrder());
		/* allocate that memory to our field variable */
		vertexBuffer = vertexByteBuffer.asFloatBuffer();
		/* the vertices go into that allocated memory */
		vertexBuffer.put(vertices);
		/* set the cursor to the first vertex */
		vertexBuffer.position(0);
		
		/* use the same ByteBuffer for the texture buffer */
		vertexByteBuffer = ByteBuffer.allocateDirect(mapMesh.length * 4);
		vertexByteBuffer.order(ByteOrder.nativeOrder());
		textureBuffer = vertexByteBuffer.asFloatBuffer();
		textureBuffer.put(mapMesh);
		textureBuffer.position(0);
	}
	/**
	 * Load a texture onto mapObject using GL 2D 
	 * @param gl
	 * @param context
	 */
	public void loadGLTexture(GL10 gl, Context context){
		/* loadImage */
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.world_map);
		/* tell opengl where to store texture ids */
		gl.glGenTextures(1, textureArray, 0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureArray[0]);
		/* tell opengl how to adjust our image in different cases */
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
		gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
		
		GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
		
		/* clean */
		bitmap.recycle();
	}
	
	
	/**
	 * Draw method
	 * @param gl
	 */
	public void drawMap(GL10 gl){
		/* prepare the image/texture i want to draw */
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureArray[0]);
				
		/* Prepare the LAZORS for drawing */
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glFrontFace(GL10.GL_CW);
				
		/* tell opengl that we want to draw te image in textureArray[0] using vertex/texture 
		 * mapping in the two buffers */
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textureBuffer);
				
		/* draw the triangles in our image using triangle strips */
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);

		/* disable to lazors to prevent hurting anyone else */
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		
	}
}
