package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;


public class PsHitNps extends Command{

	//Attribute for the class PsHitNps
	private GameWorld g;
	
	//Default constructor
	public PsHitNps(GameWorld gw) {
		
		super("PS (NPS)");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.psHitNps();
		
	}
	
}
