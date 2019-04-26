package Sound;

public class GameSound {
	
	//Attribtes for the class GameSound------------------------------------------------------------------------------------
	
	private Sound collision;
	private Sound shipCrashed; 
	private Sound gameOver;
	private Sound missileLaunch;
	private Sound noAmmo;
	private Sound missileReload;
	private Sound hyperJump;
	private Sound moveLauncher;
	private BGSound background;
	private int bgVol, vol;
	private boolean enable;
	
	//Behaviours for the class GameSound-----------------------------------------------------------------------------------
	
	//Constructor for the class GameSound
	public GameSound(){
		
		collision = new Sound("OtherExplosion.wav");
		shipCrashed = new Sound("ShipExplosion.wav");
		gameOver = new Sound("GameOver.wav");
		missileLaunch = new Sound("FireMissile.wav");
		noAmmo = new Sound("NoAmmo.wav");
		missileReload = new Sound("Reload.wav");
		hyperJump = new Sound("Hyperjump.wav");
		moveLauncher = new Sound("MoveLauncher.wav");
		background = new BGSound("Background.wav");
		bgVol = 50;
		vol = 50;
		
		enable = false;
		
	}
	
	public void collisionSound(){
		
		if (enable)
			collision.play(getVol());

	}
	
	public void moveLauncherSound() {
		
		if(enable)
			moveLauncher.play(getVol());
		
	}
	
	public void shipCrashSound(){
		
		if (enable)
			shipCrashed.play(getVol());
		
	}
	
	public void gameOverSound(){
		
		if (enable)
			gameOver.play(getVol());
		
	}
	
	public void missileLaunchSound(){
		
		if (enable)
			missileLaunch.play(getVol());
		
	}
	
	public void noAmmoSound() {
		
		if(enable) 
			noAmmo.play(getVol());
		
	}
	public void reloadSound() {
	
		if(enable) 
			missileReload.play(getVol());
		
	}
	
	public void jumpSound() {
		
		if(enable) 
			hyperJump.play(getVol());
		
	}	
	
	//This method is for playing the background sound
	public void playMusic() { 

		if(enable)
			background.play(getBGVol());
		
	}
	
	public void pauseMusic() { 	
		
		background.pause();
		
	}
	
	public void soundToggle() {
		
		enable = !enable;
		
		if (enable == false)
			pauseMusic();
		else
			playMusic();

	}

	public boolean getSound() {
		
		return enable;
		
	}
	
	public void setVol(int v) {
		
		vol = v;
		
	}
	
	public void setBGVol(int v) {
		
		bgVol = v;
		playMusic();
		
	}
	
	public int getVol() {
		
		return vol;
		
	}
	
	public int getBGVol() {
		
		return bgVol;
		
	}
}
