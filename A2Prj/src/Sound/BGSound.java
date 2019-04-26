package Sound;

import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BGSound implements Runnable{
	
	//Attributes for the class BGSound--------------------------------------------------------------------------
	
	private Media m;
	
	//Behaviours for the class BGSound--------------------------------------------------------------------------
	
	public BGSound(String fileName) {
		
		try {
			
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),  "/"+fileName);
			m = MediaManager.createMedia(is, "audio/wav", this);
			
		}
		catch(Exception e) {	
			
			e.printStackTrace();
		
		}
		
	}
	
	public void pause() {
		
		m.pause();
		
	}
	
	public void play(int v) {
		
		m.play(); 
		m.setVolume(v);
		
	}
	
	public void run() {
		
		m.setTime(0);
		m.play();
		
	}

}
