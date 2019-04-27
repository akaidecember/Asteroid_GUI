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
	private boolean enabled;
	
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
		
		enabled = true;
		
	}
	
	public void collisionSound(){
		
		if (enabled)
			collision.play(getVol());

	}
	
	public void moveLauncherSound() {
		
		if(enabled)
			moveLauncher.play(getVol());
		
	}
	
	public void shipCrashSound(){
		
		if (enabled)
			shipCrashed.play(getVol());
		
	}
	
	public void gameOverSound(){
		
		if (enabled)
			gameOver.play(getVol());
		
	}
	
	public void missileLaunchSound(){
		
		if (enabled)
			missileLaunch.play(getVol());
		
	}
	
	public void noAmmoSound() {
		
		if(enabled) 
			noAmmo.play(getVol());
		
	}
	public void reloadSound() {
	
		if(enabled) 
			missileReload.play(getVol());
		
	}
	
	public void jumpSound() {
		
		if(enabled) 
			hyperJump.play(getVol());
		
	}	
	
	//This method is for playing the background sound
	public void playMusic() { 

		if(enabled)
			background.play(getBGVol());
		
	}
	
	public void pauseMusic() { 	
		
		background.pause();
		
	}
	
	public void soundToggle() {
		
		enabled = !enabled;
		
		if (enabled == false)
			pauseMusic();
		else
			playMusic();

	}

	//Return the starte of the sound
	public boolean getSound() {
		
		return enabled;
		
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
