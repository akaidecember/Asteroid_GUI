package Objects;

import com.codename1.charts.util.ColorUtil;

import Interfaces.ISteerable;

public class SteerableMissileLauncher extends MissileLauncher implements ISteerable{

	//Attributes for the class SteerableMissileLauncher

	private int steerDegrees;	
	
	//Behaviours for the class SteerableMissileLauncher
	
	//Default constructor for the class SteerableMissileLauncher
	public SteerableMissileLauncher(int newSpeed, int newDirection) {
		
		super(newSpeed, newDirection);							//Calling the super constructor to initialize its speed and direction with that of the ps
		steerDegrees = 3;
		this.setColor(ColorUtil.rgb(204, 204, 0));				//Setting the color to gold	
		
	}
	
	//Method to steer the player ship left
	public void steerLeft() {
		
		setDirection(getDirection() + steerDegrees);
		
	}
	
	//Method to steer the player ship right
	public void steerRight() {
		
		setDirection(getDirection() - steerDegrees);
		
	}
	
	//Method to override the toString method of the class
	public String toString() {
		
		return " Missile launcher dir = " + this.getDirection();
		
	}
	
}
