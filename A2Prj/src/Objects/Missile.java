package Objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import Interfaces.ICollider;
import Interfaces.IDrawable;
import Interfaces.ISelectable;

public class Missile extends Movable implements ISelectable, IDrawable, ICollider{

	//Attributes for the class Missile------------------------------------------------------------------------------------------------------------
	
	private boolean selected;
	private int fuelLevel;
	private int missileFlag;								//If the flag is 0, then it belongs to player ship. If it is 1, then it belongs to non player ship
	private int size;
	
	//Behaviours for the class Missile------------------------------------------------------------------------------------------------------------
	
	//Parameterized constructor
	public Missile(int newSpeed , int newDirection , Point2D newLocation , int newFlag) {
		
		size = this.getRandom().nextInt(21) + 15;
		this.setFuel(10);
		this.missileFlag = newFlag;				//0 for ps, 1 for nps
		super.setDirection(newDirection);
		super.setSpeed(newSpeed + 2);
		this.setLocation(newLocation);
		
		if(missileFlag == 1)
			this.setColor(ColorUtil.rgb(255, 128, 0));			//Setting the color to orange			
		else
			this.setColor(ColorUtil.rgb(255, 255, 255));		//Setting the color to white
				
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

	@Override
	public boolean collidesWith(ICollider gameObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Point2D pPtrRelPrnt, Point2D pCmpRelPrnt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelected(boolean select) {
		
		this.selected = select;
		
	}

	@Override
	public boolean isSelected() {
		
		return this.selected;
		
	}

	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		
		//Getting the location relative to the local component
		int x = (int)(pCmpRelPrnt.getX() + this.getX());
		int y = (int)(pCmpRelPrnt.getY() + this.getY());
		
		g.setColor(this.getColor());
		g.drawRect(x - this.size/4, y - this.size/2, this.size/2, this.size);		
		g.drawRect(x - this.size/4, y - this.size/2, this.size/2, this.size);	
		
	}
	
}
