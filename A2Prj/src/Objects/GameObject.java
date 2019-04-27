package Objects;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

/*
 * Abstract class GameObject to provide implementations for the different objects of the game
 */
public abstract class GameObject {

	//Attributes---------------------------------------------------------------
	
	private double x;
	private double y;
	private int color;
	private Random rand;
	private Point2D objectLocation;
	private GameCanvas canvas;
	//private ObjectColor objColor;
	
	//Behaviours---------------------------------------------------------------
	
	//Default constructor for the class GameObject
	public GameObject() {
		
		//objColor = new ObjectColor();
		canvas = new GameCanvas();
		rand = new Random();
		x = (double) rand.nextInt((int)(canvas.getCanvasXMax()));
		y = (double) rand.nextInt((int)(canvas.getCanvasYMax()));
		objectLocation = new Point2D(x,y);
		
	}
	
	//Getter and setter method for X and Y (position variables)
	public double getX() {
		
		return this.x;
		
	}
	
	public double getY() {
		
		return this.y;
		
	}
	
	public void setX(double newX) {
		
		//if(GameCanvas.rangeCheckX(newX))
			this.x = newX;
		
	}
	
	public void setY(double newY) {
		
		//if(GameCanvas.rangeCheckY(newY))
			this.y = newY;
		
	}
	
	//Getter method for color
	public int getColor() {
		
		return this.color;
		
	}
	
	//Setter method for color
	public void setColor(int newColor){
	
		this.color = newColor;
	
	}
	
	//Method to get the random object
	public Random getRandom() {
		
		return rand;
		
	}
	
	//Method to set the location of the object by checking if the coordinates are within the specification 
	public void setLocation(Point2D newLocation) {
		
		try {
			
			double tempX = newLocation.getX();
			double tempY = newLocation.getY();
			
			//if(GameCanvas.rangeCheck(tempX, tempY)) {
			
				setX(tempX);
				setY(tempY);
				
			//}
			//else
			//	throw new Exception("The coordinates are out of range.");
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}
	
	//Method to return the location of the object
	public Point2D getLocation() {
		
		return this.objectLocation;
		
	}
	
	//Method to over-ride the default toString method for the class GamObject
	public String toString() {
		
		String desc = "loc=" + Math.round(this.getX() * 10.0) / 10.0 + "," + Math.round(this.getY() * 10.0) / 10.0 + 
				" color=[" + ColorUtil.red(getColor()) + "," + ColorUtil.green(getColor()) + "," + ColorUtil.blue(getColor()) + "]";
		return desc;
		
	}
}
