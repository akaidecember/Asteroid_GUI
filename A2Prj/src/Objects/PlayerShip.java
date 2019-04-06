package Objects;

import com.codename1.charts.util.ColorUtil;

import Interfaces.ISteerable;

public class PlayerShip extends Movable implements ISteerable{

	//Attributes for the class PlayerShip
	
	private int missileCount;
	private int steerDegrees;
	private final int maxMissileCount = 10;
	private SteerableMissileLauncher psLauncher;
	
	//Behaviours for the class PlayerShip
	
	public PlayerShip() {
		
		super();
		setX(512);							//Setting the initial position of PS to the center of the screen 
		setY(384);							//x,y = 512,384
		setSpeed(0);						//Default speed is set to zero
		setDirection(0);					//Setting the default direction to 0 degrees
		setMissileCount(maxMissileCount);	//Setting the default missile max to 10
		setColor(ColorUtil.rgb(255, 0, 0));	//Color set to red
		psLauncher = new SteerableMissileLauncher(this.getSpeed(), this.getDirection());
		steerDegrees = 5;
				
	}
	
	//Method to move to default location (hyper space jump functionality) for the player ship
	public void defaultLocationPs() {
		
		setX(512);
		setY(384);
		
	}
	
	//Method to update the speed and the direction of the steerable missile launcher
	public void update() {
		
		//psLauncher.updateLauncher(this.getSpeed(), this.getDirection());
		psLauncher.updateLauncher(this.getSpeed());

		
	}
	
	//Method to increase the speed of the player ship
	public void increaseSpeedPs() {
		
		setSpeed(this.getSpeed() + 1);
		update();
		
	}
	
	//Method to decrease the speed of the player ship
	public void decreaseSpeedPs() {
		
		setSpeed(this.getSpeed() - 1);
		update();
		
	}
	
	//Get the current missile count for the player ship
	public int getMissileCount() {
		
		return this.missileCount;
		
	}
	
	//Method to set the missile count for the player ship
	public void setMissileCount(int newMissileCount) {
		
		if(newMissileCount <= maxMissileCount && newMissileCount >= 0)
			this.missileCount = newMissileCount;
		
	}
	
	//Method to steer the player ship left
	public void steerLeft() {
		
		setDirection(this.getDirection() + steerDegrees);
		//update();
		
	}
	
	//Method to steer the player ship right
	public void steerRight() {
		
		setDirection(this.getDirection() - steerDegrees);
		//update();
		
	}
	
	//Method to steer the launcher right
	public void steerLauncherRight() {
		
		psLauncher.steerRight();
		
	}
	
	//Method to steer the launcher left
	public void steerLauncherLeft() {
		
		psLauncher.steerLeft();
		
	}
	
	//Method to reload the ship to its maximum capacity
	public void setMaxMissiles() {
		
		this.setMissileCount(this.maxMissileCount);
		
	}
	
	//Method to over-ride the toString method
	public String toString() {
		
		String desc = "Player Ship: " + super.toString() + " missiles=" + this.getMissileCount() + psLauncher.toString() + "\n";
		return desc;
		
	}
	
}
