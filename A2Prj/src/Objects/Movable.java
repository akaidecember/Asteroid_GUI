package Objects;

import Enum.SpeedEnum;
import Enum.DirectionEnum;

import Interfaces.IMovable;
import com.codename1.ui.geom.Point2D;

public abstract class Movable extends GameObject implements IMovable{

	//Attributes for the class Movable----------------------------------------
	
	private int speed;
	private int direction;
	
	//Behaviours for the class Movable----------------------------------------
	
	//Constructor for the class Movable
	public Movable() {
		
		this.speed = getRandom().nextInt(SpeedEnum.MaxSpeed.speed);
		this.direction = getRandom().nextInt(DirectionEnum.MaxDegrees.degrees);
		
	}
	
	//Method to implement the move() method
	public void move(long elapsed) {
		
		int theta = 90 - direction;
		Point2D oldLocation = this.getLocation();

		double delX = Math.cos(Math.toRadians(theta)) * (speed * ((double)elapsed/1000));
		double delY = Math.sin(Math.toRadians(theta)) * (speed * ((double)elapsed/1000));
		Point2D newLocation = new Point2D( (oldLocation.getX() + delX) , (oldLocation.getY() + delY) );
		setLocation(newLocation);
		
	}
	
	//Method to get the direction
	public int getDirection() {
		
		return this.direction;
		
	}
	
	//Method to set the direction
	public void setDirection(int newDirection) {
		
		if(newDirection > 359)
			newDirection -= 360;
		else if(newDirection < 0)
			newDirection += 360;
		
		this.direction = newDirection;
		
	}
	
	//Method to get the speed
	public int getSpeed() {
		
		return this.speed;
		
	}
	
	//Method to set new speed
	public void setSpeed(int newSpeed) {
		
		if(newSpeed <= 15 && newSpeed >= 0)
			this.speed = newSpeed;
		
	}
	
	//Method to override the default toString()
	public String toString() {
		
		String desc = super.toString() + " speed=" + this.getSpeed() + " dir=" + this.getDirection();
		return desc;
		
	}
}
