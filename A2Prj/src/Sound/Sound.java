package Sound;

import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class Sound{
	
	//Attributes for the class Sound------------------------------------------------------------------------------
	
	private Media m;
	
	//Behaviours for the class Sound------------------------------------------------------------------------------
	
	//Constructor
	public Sound(String fileName) {
		
		try {
			
			InputStream is = Display.getInstance().getResourceAsStream(getClass(),"/"+fileName);
			m = MediaManager.createMedia(is, "audio/wav");
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	
	public void play(int vol) {
		
		m.setTime(0);									//Setting the audio position to zero
		m.setVolume(vol);								//Setting the volume for the playback
		m.play();
		
	}

}
