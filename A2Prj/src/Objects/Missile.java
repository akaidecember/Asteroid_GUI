package Objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public class Missile extends Movable{

	//Attributes for the class Missile
	
	private int fuelLevel;
	
	//If the flag is 0, then it belongs to player ship. If it is 1, then it belongs to non player ship
	private int missileFlag;
	
	//Behaviours for the class Missile
	
	//Parameterized constructor
	public Missile(int newSpeed , int newDirection , Point2D newLocation , int newFlag) {
		
		this.setFuel(10);
		this.missileFlag = newFlag;				//0 for ps, 1 for nps
		super.setDirection(newDirection);
		super.setSpeed(newSpeed + 2);
		this.setLocation(newLocation);
		//Setting the color to orange
		this.setColor(ColorUtil.rgb(255, 128, 0));
				
	}
	
	//Default constuctor
	public Missile(){
	
	}
	
	//Getter method for flag
	public int getMissileFlag() {
		
		return this.missileFlag;
		
	}
	
	//Getter and setter methods
	public int getFuel() {
		
		return this.fuelLevel;
		
	}
	
	public void setFuel(int newFuel) {
		
		if(newFuel <= 10 && newFuel > -1)
			this.fuelLevel = newFuel;
		
	}
	
	//Method to decrease the fuel level by one
	public void decreaseFuelLevel() {
		
		setFuel(getFuel() - 1); 
		
	}
	
	//toString method for the class
	public String toString() {
		
		String desc = "";
		if(missileFlag == 0)
			desc = "PS's missile: ";
		else if(missileFlag == 1)
			desc = "NPS's missile: ";
		desc += super.toString() + " fuel=" + this.getFuel() + "\n";
		return desc;
		
	}
	
}
