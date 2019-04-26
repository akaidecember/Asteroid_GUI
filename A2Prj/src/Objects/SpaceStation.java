package Objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

import Interfaces.IDrawable;

public class SpaceStation extends Fixed implements IDrawable{
	
	//Attributes for the class SpaceStation
	
	private int size = this.getRandom().nextInt(21) + 15;
	private int blinkRate;
	private boolean isLightsOn;
	
	//Behaviours for the class SpaceStation
	
	public SpaceStation() {
		
		blinkRate = getRandom().nextInt(5);
		isLightsOn = true;
		//Setting the color of the space station to white
		this.setColor(ColorUtil.rgb(255, 255, 255));
		
		
	}
	
	//Getter method for blink rate
	public int getBlinkRate(){
		
		return this.blinkRate;
		
	}
	
	//toString method for the class
	public String toString() {
		
		String desc = "Station: " + super.toString() + " rate=" + this.getBlinkRate() + "\n";
		return desc;
		
	}

	public void toggleBlink() {
		
		isLightsOn = !isLightsOn;
		
	}

	@Override
	public void draw(Graphics g, Point2D pCmpRelPrnt) {
		
		//Getting the location relative to the local component
		int x = (int)(pCmpRelPrnt.getX() + this.getX());
		int y = (int)(this.getY());
		
		g.setColor(this.getColor());
		
		if(isLightsOn)
			g.fillRoundRect(x, y, size, size, 20, 10);

		g.drawRoundRect(x, y, size, size, 20, 10);
		
	}

}
