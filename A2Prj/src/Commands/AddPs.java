package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddPs extends Command{

	//Attribute for the class AddPs
	private GameWorld g;
	
	//Default constructor
	public AddPs(GameWorld gw) {
		
		super("+ PS (1)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {
		
		if(E.getKeyEvent() != -1)
			g.addPs();
		
	}
	
}
