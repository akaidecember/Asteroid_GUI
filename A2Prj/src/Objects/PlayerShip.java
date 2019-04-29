package Objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import com.mycompany.a2.GameWorld;

import Interfaces.ICollider;
import Interfaces.IDrawable;
import Interfaces.ISteerable;

public class PlayerShip extends Movable implements ISteerable, IDrawable, ICollider{

	//Attributes for the class PlayerShip
	
	private int size;
	private int missileCount;
	private int steerDegrees;
	private final int maxMissileCount = 10;
	private SteerableMissileLauncher psLauncher;
	
	//Behaviours for the class PlayerShip
	
	public PlayerShip() {
		
		super();
		setX(GameWorld.getWidth()/2);							//Setting the initial position of PS to the center of the screen 
		setY(GameWorld.getHeight()/2);							//Spawn the player ship to the center of the screen
		setSpeed(0);											//Default speed is set to zero
		setDirection(0);										//Setting the default direction to 0 degrees
		setMissileCount(maxMissileCount);						//Setting the default missile max to 10
		setColor(ColorUtil.rgb(255, 0, 0));						//Color set to red
		psLauncher = new SteerableMissileLauncher(this.getSpeed(), this.getDirection());
		steerDegrees = 5;
		size = 10;
				
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

	@Override
	public boolean collidesWith(ICollider gameObject) {
		
		return false;
	}

	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		
		//Getting the location relative to the local component
		int x = (int)(pCmpRelPrnt.getX() + this.getX());
		int y = (int)(pCmpRelPrnt.getY() + this.getY());
		
		//Setting the color for the graihpcs object
		g.setColor(this.getColor());
		
		//Creating the points for drawing the shape
		Point2D top = new Point2D(x,y + size/3*2);
		Point2D bottomLeft = new Point2D(x - (size/3*2), y - (size/3*2));
		Point2D bottomRight = new Point2D(x + (size/3*2), y - (size/3*2));
		
		//Storing the points in integer array for drawing the triangle
		int[] xPoints = new int[] {(int) top.getX(), (int)bottomLeft.getX(), (int)bottomRight.getX()};
		int[] yPoints = new int[] {(int) top.getY(), (int)bottomLeft.getY(), (int)bottomRight.getY()};
		
		//Drawing and colouring the triangles
		g.drawPolygon(xPoints, yPoints, 3);
		g.fillPolygon(xPoints, yPoints, 3);
		
	}
	
}
