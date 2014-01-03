package palacesoft.eclipseoftime.utils;

import palacesoft.lostundertheshade.R;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSound extends Service {

	private static final String TAG = "Background Service for sounds and music";
	private MediaPlayer mediaPlayer;
	
	@Override
	public IBinder onBind(Intent arg0) {
		
		return null;
	}
	
	@Override
	public void onCreate(){
		super.onCreate();
		//mediaPlayer = MediaPlayer.create(getApplicationContext(), R.drawable.idle);
		mediaPlayer.setLooping(true);
		mediaPlayer.setVolume(100, 100);
		
	}
	
	public int onStartCommand(Intent intent, int flags, int startId){
		mediaPlayer.start();
		return 1;
	}
	
	public void onStart(Intent intent, int startId0){
		// send track information with intent to choose the right sound to play
	}
	
	public void onStop(){
		mediaPlayer.stop();
	}
	
	public void onPause(){
		mediaPlayer.pause();
	}
	
	@Override
	public void onDestroy(){
		mediaPlayer.stop();
		mediaPlayer.release();
	}
	
	@Override
	public void onLowMemory(){
		
	}
}
