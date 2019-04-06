package Enum;

public enum DirectionEnum {

	MaxDegrees(359), MinDegrees(0);
	
	public final int degrees;
	
	DirectionEnum(int degrees){
		
		this.degrees = degrees;
		
	}
	
	public int getDegrees() {
		
		return this.degrees;
		
	}
	
}
