package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecreasePsSpeed extends Command{

	//Attribute for the class DecreasePsSpeed
	private GameWorld g;
	
	//Default constructor
	public DecreasePsSpeed(GameWorld gw) {
		
		super("PS Speed (-)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.decreasePsSpeed();
		
	}
	
}
