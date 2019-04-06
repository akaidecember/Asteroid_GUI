package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class KillAsteroidPs extends Command{

	//Attribute for the class KillAsteroidPs
	private GameWorld g;
	
	//Default constructor
	public KillAsteroidPs(GameWorld gw) {
		
		super("PS Missile (Asteroid)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.killAsteroidPs();
		
	}
	
}
