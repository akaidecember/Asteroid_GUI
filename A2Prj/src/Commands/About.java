package Commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class About extends Command{
	
	public About() {
		super("About");
	}
	
	
	

	public void actionPerformed(ActionEvent E) {
		
		if(E.getKeyEvent() != -1) {
			
			System.out.println("About information selected");
			String info = ("Asteroids Game, by Anshul Kumar Shandilya");
			info += "\nFor CSc 133, #2 : Assignment 3";
			info += "\nInstructor Doan Nguyen";
	
			if(Dialog.show("About", info, "Version", "Close")) {
				
				String version = "0.2";
				  
				Dialog.show("Version", version, "Okay", null);
				
			}
		
		}
			
	}

}
