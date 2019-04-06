package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class TurnPsRight extends Command{

	//Attribute for the class TurnPsRight
	private GameWorld g;
	
	//Default constructor
	public TurnPsRight(GameWorld gw) {
		
		super("PS Right");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {
		
		if(E.getKeyEvent() != -1)
			g.turnPsRight();
		
	}
	
}
