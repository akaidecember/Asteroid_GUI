package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintDisplay extends Command{

	//Attribute for the class PrintDisplay
	private GameWorld g;
	
	//Default constructor
	public PrintDisplay(GameWorld gw) {
		
		super("Print");
		g = gw;
		
	}
	
	public void actionPerformed(ActionEvent E) {

		if(E.getKeyEvent() != -1)
			g.print();
		
	}
	
}
