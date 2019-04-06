package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class TurnPsLeft extends Command{

	//Attribute for the class TurnPsLeft
	private GameWorld g;
	
	//Default constructor
	public TurnPsLeft(GameWorld gw) {
		
		super("PS Left");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.turnPsLeft();
		
	}
	
}
