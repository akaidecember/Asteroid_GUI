package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNps extends Command{

	//Attribute for the class AddAsteroid
	private GameWorld g;
	
	//Default constructor
	public AddNps(GameWorld gw) {
		
		super("+ NPS");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.addNps();
		
	}
	
}
