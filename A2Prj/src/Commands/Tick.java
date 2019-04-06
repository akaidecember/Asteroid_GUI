package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class Tick extends Command{

	//Attribute for the class Tick
	private GameWorld g;
	
	//Default constructor
	public Tick(GameWorld gw) {
		
		super("Tick");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.tick();
		
	}
	
}
