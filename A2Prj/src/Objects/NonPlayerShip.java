package Objects;

import com.codename1.charts.util.ColorUtil;

public class NonPlayerShip extends Movable{

	//Attributes for the class Non Player Ship
	
	private int size;
	private int npsMissileCount;
	private MissileLauncher npsLauncher;
	
	//Behaviours for the class NonPlayerShip
	
	//Constructor for the class NonPlayerShip
	public NonPlayerShip() {
		
		//Setting the size of the nps to either 10 or 20 (small or large)
		this.size = getRandom().nextInt(20 + 1) + 10;
		this.npsLauncher = new MissileLauncher(this.getSpeed(), this.getDirection());
		this.setNpsMissileCount(2);
		
		//Setting the color to maroon
		this.setColor(ColorUtil.rgb(153, 0, 76));		
		
	}
	
	//Method to return the NPS missile count
	public int getNpsMissileCount() {
		
		return this.npsMissileCount;
		
	}
	
	//Method to set the number of missiles for the non=-player ship
	public void setNpsMissileCount(int newCount) {
		
		if(newCount <= 2 && newCount > 0)
			this.npsMissileCount = newCount;
		
	}
	
	//Method to get the size of the ship
	public int getSize() {
		
		return this.size;
		
	}
		
	//Method to override the toString() method for the class NonPlayerShip
	public String toString() {
		
		String desc = "Non-Player Ship: " + super.toString() + " size=" + this.getSize() + "\n";
		return desc;
		
	}
	
}
