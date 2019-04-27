package Commands;

import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Sound extends Command {
	
	private CheckBox c;
	private GameWorld gw;
	
	public Sound (CheckBox cIn, GameWorld gw){
		
	    super("Sound");
	    c = cIn;
	    this.gw=gw;
	    
	}
	
	public void actionPerformed(ActionEvent E){
		
		if(E.getKeyEvent() != -1) {
			
			System.out.println("sound toggled");
			
			if(c.isSelected()) {
				
				System.out.println("sound selected");
				gw.soundToggle();
				
			}
			else {
				
				System.out.println("sound unselected");
				gw.soundToggle();
				
			}
		
		}
	}
}