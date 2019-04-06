package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class ExplodePs extends Command{

	//Attribute for the class ExplodePs
	private GameWorld g;
	
	//Default constructor
	public ExplodePs(GameWorld gw) {
		
		super("NPS Missile (PS)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.explodePs();
		
	}
	
}
