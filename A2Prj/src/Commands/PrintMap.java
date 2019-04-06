package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintMap extends Command{

	//Attribute for the class PrintMap
	private GameWorld g;
	
	//Default constructor
	public PrintMap(GameWorld gw) {
		
		super("Map");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.map();
		
	}
	
}
