package Objects;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends Movable{
	
	//Attributes for the class Asteroid
	
	private int size;			//Field to determine the size of the asteroid	

	//Behaviours for the class Asteroid
	
	//Default constructor for the class Asteroid
	public Asteroid() {
		
		//Setting the size to a random value between 6 and 30
		size = getRandom().nextInt(25) + 6;
		
		//Setting the color to grey
		this.setColor(ColorUtil.rgb(128, 128, 128));
				
	}
	
	//Getter method for the class Asteroid
	public int getSize() {
		
		return this.size;
		
	}
	
	//Method to over-rode the default toString method
	public String toString(){
		
		String desc = "Asteroid: " + super.toString() + " size=" + this.getSize() + "\n";
		return desc;
		
	}
	
}
