package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class AsteroidsCollide extends Command{

	//Attribute for the class AsteroidsCollide
	private GameWorld g;
	
	//Default constructor
	public AsteroidsCollide(GameWorld gw) {
		
		super("Asteroids (Asteroid)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.asteroidsCollide();
		
	}
	
}
