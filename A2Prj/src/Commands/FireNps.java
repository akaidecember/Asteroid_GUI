package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class FireNps extends Command{

	//Attribute for the class FireNps
	private GameWorld g;
	
	//Default constructor
	public FireNps(GameWorld gw) {
		
		super("NPS Fire");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.fireNps();
		
	}
	
}
