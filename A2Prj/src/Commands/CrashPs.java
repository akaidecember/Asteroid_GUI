package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class CrashPs extends Command{

	//Attribute for the class CrashPs
	private GameWorld g;
	
	//Default constructor
	public CrashPs(GameWorld gw) {
		
		super("PS (Asteroid)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.crashPs();
		
	}
	
}
