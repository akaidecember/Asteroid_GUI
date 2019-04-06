package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class FirePs extends Command{

	//Attribute for the class FirePs
	private GameWorld g;
	
	//Default constructor
	public FirePs(GameWorld gw) {
		
		super("PS Fire");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.firePs();
		
	}
	
}
