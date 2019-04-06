package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class QuitGame extends Command{

	//Attribute for the class PsHitNps
	private GameWorld g;
	
	//Default constructor
	public QuitGame(GameWorld gw) {
		
		super("Quit");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.quit();
		
	}
	
}
