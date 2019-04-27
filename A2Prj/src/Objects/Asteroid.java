package Objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;
import Interfaces.ICollider;
import Interfaces.IDrawable;
import Interfaces.ISelectable;

public class Asteroid extends Movable implements IDrawable, ISelectable, ICollider{
	
	//Attributes for the class Asteroid----------------------------------------------------------------------------------------------
	
	private int[] xSidePoints;
	private int[] ySidePoints;
	private int sidePoints;
	private int size;	
	private boolean selected;

	//Behaviours for the class Asteroid----------------------------------------------------------------------------------------------
	
	//Default constructor for the class Asteroid
	public Asteroid() {

		size = getRandom().nextInt(25) + 6;					   							//Setting the size to a random value between 6 and 30
		this.setColor(ColorUtil.rgb(128, 128, 128));									//Setting the color to grey
		sidePoints = this.getRandom().nextInt(5) + 10;									//Setting the number of side points (corners) for the asteroid
		
		//Initializing the arrays
		xSidePoints = new int[sidePoints];
		ySidePoints = new int[sidePoints];
		
		for(int i=1; i < sidePoints; i++) {
			
			xSidePoints[i] = (int)(this.getX() + this.getRandom().nextInt(20) - 10 + size * Math.cos((360/sidePoints * i)));
			ySidePoints[i] = (int)(this.getY() + this.getRandom().nextInt(20) - 10 + size * Math.sin((360/sidePoints * i)));
			
		}
				
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

	@Override
	public void setSelected(boolean select) {

		selected = select;
		
	}

	@Override
	public boolean isSelected() {
		
		return selected;
		
	}

	//Method to draw the asteroid
	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {

		//Getting the location relative to the local component
		int x = (int)(pCmpRelPrnt.getX() + this.getX());
		int y = (int)(pCmpRelPrnt.getY() + this.getY());
		 
		//Setting the first points to the origin of the asteroid
		 xSidePoints[0] = x;
		 ySidePoints[0] = y;
		 
		 //Drawing and filling the asteroid
		 g.setColor(this.getColor());
		 g.drawPolygon(xSidePoints, ySidePoints, sidePoints);
		 g.fillPolygon(xSidePoints, ySidePoints, sidePoints);
		
	}
	
	@Override
	public boolean collidesWith(ICollider gameObject) {

		return false;
		
	}

	@Override
	public boolean contains(Point2D pPtrRelPrnt, Point2D pCmpRelPrnt) {

		return false;
		
	}
	
}
