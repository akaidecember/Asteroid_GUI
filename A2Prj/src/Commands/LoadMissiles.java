package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class LoadMissiles extends Command{

	//Attribute for the class LoadMissiles
	private GameWorld g;
	
	//Default constructor
	public LoadMissiles(GameWorld gw) {
		
		super("Load PS");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.loadMissiles();
		
	}
	
}
