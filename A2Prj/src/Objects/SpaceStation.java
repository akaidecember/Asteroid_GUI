package Objects;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends Fixed{
	
	//Attributes for the class SpaceStation
	
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

}
