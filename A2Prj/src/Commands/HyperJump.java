package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class HyperJump extends Command{

	//Attribute for the class HyperJump
	private GameWorld g;
	
	//Default constructor
	public HyperJump(GameWorld gw) {
		
		super("Jump");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.hyperJump();
		
	}
	
}
