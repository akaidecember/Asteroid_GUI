package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class AsteroidCollidesNps extends Command{

	//Attribute for the class AsteroidCollideNps
	private GameWorld g;
	
	//Default constructor
	public AsteroidCollidesNps(GameWorld gw) {
		
		super("Asteroid (NPS)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.asteroidCollidesNps();
		
	}
	
}
