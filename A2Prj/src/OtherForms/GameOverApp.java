package OtherForms;

import com.codename1.ui.*;
import com.mycompany.a2.Game;

public class GameOverApp extends Form{

	//Default constructor for the class GameOverApp, will take the points and time elapsed as args
	public GameOverApp(int score, int time) {
		
		//Prompt message in a dialogue box for Game Over and display points and time
		Boolean bOk = Dialog.show("Game Over", "Game Over.\nScore: " + score + "\nTime: " + time + "\n\n Do you want to restart the game?", "Yes", "No");
		
		//if selected yes, restart game, else exit Application
		if(bOk)
			new Game();
		else
			Display.getInstance().exitApplication();
		
	}
	
}
