package Enum;

public enum SpeedEnum {

	MaxSpeed(15), MinSpeed(0);
	
	public final int speed;
	
	private SpeedEnum(int newSpeed){
		
		this.speed = newSpeed;
		
	}
	
	public int getSpeed() {
		
		return this.speed;
		
	}
	
}
