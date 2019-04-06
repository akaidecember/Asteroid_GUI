package OtherForms;

import com.codename1.ui.*;

public class ClosingApp extends Form{

	//Default constructor for the class ClosingApp
	public ClosingApp() {
		
		//this.setTitle("Exiting application");
		Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Yes", "No");
		
		if(bOk)
			Display.getInstance().exitApplication();
		
	}
	
}
