/*
 * Class to implement the coordinate values for the canvas, or the game world
 * which has to be in the range of (0.0, 0.0) to (1024.0, 768.0)
 */

package Objects;

import com.mycompany.a2.GameWorld;

public class GameCanvas {

	//Attributes for the class GameCanvas to set the limits for the size of the canvas
	
	private static double minimum = 0.0;
	private static double maximumX = 1024.0;
	private static double maximumY = 768.0;
	
	//Behaviours----------------------------------------------------------------------
	
/*	//Constructor
	public GameCanvas() {
		
		this.maximumX = GameWorld.getWidth();
		this.maximumY = GameWorld.getHeight();
		
	}*/
	
/*	//Static methods to check if the coordinates are within range
	public static boolean rangeCheck(double xVal, double yVal) {
		
		if(rangeCheckX(xVal) && rangeCheckY(yVal))	
			return true;

		else
			return false;
		
	}
	
	public static boolean rangeCheckX(double xVal) {
		
		if(xVal >= minimum && xVal <= maximumX)
			return true;
		else
			return false;
		
	}
	
	public static boolean rangeCheckY(double yVal) {
		
		if(yVal >= minimum && yVal <= maximumY) 
			return true;
		else
			return false;
		
	}*/
	
	//Methods to get the min. and max. values for reference
	public double getCanvasMin(){
		
		 return minimum;
		
	}
	
	public double getCanvasXMax(){
		
		return maximumX;
		
	}
	
	public double getCanvasYMax(){
		
		return maximumY;
		
	}

}
