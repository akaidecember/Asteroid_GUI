package Objects;

import com.codename1.charts.util.ColorUtil;

public class MissileLauncher extends Movable{
	
	//Default constructor for the class MissileLauncher
	public MissileLauncher(int newSpeed, int newDirection) {
		
		this.setDirection(newDirection);
		this.setSpeed(newSpeed);
		this.setColor(ColorUtil.rgb(204, 204, 0));								//Setting the color to dark gold
		
	}
	
	//Method to update the speed and direction of the launcher if any changes occur to the ships
	public void updateLauncher(int newSpeed) {

		this.setSpeed(newSpeed);
		//this.setDirection(newDirection);
		
	}
	
}
