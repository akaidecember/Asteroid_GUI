package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class TurnLauncherLeft extends Command{

	//Attribute for the class TurnPsLauncher
	private GameWorld g;
	
	//Default constructor
	public TurnLauncherLeft(GameWorld gw) {
		
		super("MSL Left");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.turnLauncherLeft();
		
	}
	
}
