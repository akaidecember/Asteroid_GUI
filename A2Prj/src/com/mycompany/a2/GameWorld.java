package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;
import Interfaces.IMovable;
import Interfaces.IGameWorld;
import Interfaces.IIterator;
import ClosingForm.ClosingApp;
import Collection.GameCollection;
import Objects.Asteroid;
import Objects.GameObject;
import Objects.Missile;
import Objects.NonPlayerShip;
import Objects.PlayerShip;
import Objects.SpaceStation;

public class GameWorld extends Observable implements IGameWorld{

	//Attributes for the class GameWorld----------------------------------------------------------------
	
	private GameCollection worldList;
	private Asteroid asteroid;
	private Missile missile;
	private NonPlayerShip nps;
	private PlayerShip ps;
	private SpaceStation spaceStation;
	private boolean sound;
	private int life;
	private int score;
	private int time;
	private int gameWidth;
	private int gameHeight;
	
	//Behaviours for the class GameWorld----------------------------------------------------------------
	
	//Default Constructor for the class GameWorld 
	public GameWorld() {
		
		//Calls init to initialize the procedures for running the game
		init();
		
	}
	
	public void init() {
		
		//ArrayList of the type GameObject to store all the objects created for the game
		worldList = new GameCollection();
		
		//Setting the scores, time and life for the start of the game
		score = 0;
		time = 0;
		life = 3;
		sound = false;
		System.out.println("Initialized world for the game");
		
		callObserver();
		
	}
	
	//Method to set the observer
	public void setObserver(Observer obs) {
		
		this.addObserver(obs);
		
	}
	
	//method to call the observer
	public void callObserver() {
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		
	}
	
	//Method to return the collection of Objects
	public GameCollection getObjects() {
		
		return worldList;
		
	}

	//Method to add an asteroid to the game
	public void addAsteroid() {
		
		asteroid = new Asteroid();
		worldList.add(asteroid);
		System.out.println("New asteroid created");
		callObserver();
		
	}
	
	//Method to add a non-player ship to the game
	public void addNps() {
		
		nps = new NonPlayerShip();
		worldList.add(nps);
		System.out.println("New non player ship created");
		callObserver();
		
	}
	
	//Method to add a space-station to the game
	public void addStation() {
		
		spaceStation = new SpaceStation();
		worldList.add(spaceStation);
		System.out.println("New space station created");
		callObserver();
		
	}
	
	//Method to add a player ship to the game
	public void addPs() {
		
		if(checkForPs())
			System.out.println("Error! Cannot create more than one player ship\n");			//Enforcing that only one player ship should exist at any time
		else {
			ps = new PlayerShip();
			worldList.add(ps);
			System.out.println("New player ship created");
			callObserver();
		}
		
	}
	
	//Method to increase the speed of the player ship
	public void increasePsSpeed() {
		
		if(checkForPs()) {
			System.out.println("PS speed increased");
			ps.increaseSpeedPs();
			callObserver();
		}
		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
	}
	
	//Method to decrease the speed of the player ship
	public void decreasePsSpeed() {
		
		if(checkForPs()) {
			System.out.println("PS speed decreased");
			ps.decreaseSpeedPs();
			callObserver();
		}
		else
			System.out.println("Error! Player ship not found. Create one first\n");
		
	}
	
	//Method to turn the Player ship left by a small amount
	public void turnPsLeft() {
		
		if(checkForPs()) {
			System.out.println("turned PS left");
			ps.steerLeft();
			callObserver();
		}
		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
		
	}
	
	//Method to turn the player ship right by a small amount
	public void turnPsRight() {
		
		if(checkForPs()) {
			System.out.println("turned PS right");
			ps.steerRight();
			callObserver();
		}
		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
	}
	
	//Method to let the user turn the launcher left
	public void turnLauncherLeft() {
		
		if(checkForPs()) {
			System.out.println("Turned PS missile launcher left");
			ps.steerLauncherLeft();
			callObserver();
		}		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
	}
	
	//Method to let the user turn the launcher right
	public void turnLauncherRight() {
		
		if(checkForPs()) {
			System.out.println("Turned PS missile launcher right");
			ps.steerLauncherRight();
			callObserver();
		}		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
	}
	
	//Method to fire out a missile from the player ship
	public void firePs() {
		
		if(checkForPs()) {
			
			if(ps.getMissileCount() > 0) {
				
				//Setting the missile with the speed, direction and location of the PS for the start
				missile = new Missile(ps.getSpeed(), ps.getDirection(), ps.getLocation(), 0);
				worldList.add(missile);
				
				//Decrementing the missile count for the player ship
				ps.setMissileCount(ps.getMissileCount() - 1);
				
				System.out.println("PS missile fired");
				
				callObserver();
				
			}
			else
				System.out.println("Your ship has run out of missiles! Please reload at the Space Station\n");
			
		}
		else
			System.out.println("Error! Player ship not found. Create one first\n");
		
	}
	
	//Method to fire out a missile from the Non player ship
	public void fireNps() {
		
		if(checkForNps()) {
			
			if(nps.getNpsMissileCount() > 0) {
				
				missile = new Missile(nps.getSpeed(), nps.getDirection(), nps.getLocation(), 1);
				worldList.add(missile);
				
				//Decrementing the missile count for the non player ship
				nps.setNpsMissileCount(nps.getNpsMissileCount() - 1);
				
				System.out.println("NPS missile fired");
				
				callObserver();
				
			}
			else
				System.out.println("The non player ship has run out of missiles!\n");
			
		}
		else
			System.out.println("Error! Non player ship not found. Create one first.\n");
				
	}
	
	//Method to instantly make the player ship jump to the center of the screen a.k.a hyperjump
	public void hyperJump() {
		
		if(checkForPs()) {

			ps.defaultLocationPs();
			System.out.println("PS hyperjump!");
			callObserver();
			
		}
		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
		
	}
	
	//Method to load a new supply of missiles to the Player ship
	public void loadMissiles() {
		
		if(checkForPs()) {

			ps.setMaxMissiles();
			System.out.println("Missiles loaded");
			callObserver();
			
		}
		else
			System.out.println("Error! Player ship not found. Create one first.\n");
		
	}
	
	/*Method to handle the situation where a player ship missile has struck an asteroid and destroyed it.
	 * This method removes the asteroid and the Player ship missile that were involved in the collision
	 */
	public void killAsteroidPs() {
		
		Asteroid tempAsteroid = new Asteroid();
		Missile tempMissile = new Missile();
		IIterator iterator1 = worldList.getIterator();
		IIterator iterator2 = worldList.getIterator();
		Object current1 = new Object();
		Object current2 = new Object();
		int count = 0;
			
		if(worldList.size() != 0) {
			
			while(iterator1.hasNext()) {
				
				current1 = iterator1.getNext();
				
				if(current1 instanceof Asteroid) {
					
					tempAsteroid = (Asteroid) current1;
					count++;
					break;
					
				}
				
			}
			if(count == 1) {
	
				while(iterator2.hasNext()) {
					
					current2 = iterator2.getNext();
					if(current2 instanceof Missile) {
						
						tempMissile = (Missile) current2;
						if(tempMissile.getMissileFlag() == 0) {
							
							count++;
							break;
							
						}
						
					}
					
				}
				if(count == 2) {
					
					worldList.remove(tempAsteroid);
					worldList.remove(tempMissile);
					System.out.println("Asteroid and PS Missile destroyed");
					score++;
					callObserver();
					
				}
				else
					System.out.println("Error! Insufficient number of required objects in the game\n");
				
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");
		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
	
	}
	
	/*Method to handle the situation where a player ship missile has struck a non player ship and 
	 * destroyed it. This method removes the non player ship and the Player ship missile that were 
	 * involved in the collision
	 */
	public void eliminateNps() {
		
		NonPlayerShip tempNps = new NonPlayerShip();
		Missile tempMissile = new Missile();
		IIterator iterator1 = worldList.getIterator();
		IIterator iterator2 = worldList.getIterator();
		Object current1 = new Object();
		Object current2 = new Object();
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator1.hasNext()){
				
				current1 = iterator1.getNext();
				if(current1 instanceof NonPlayerShip) {
					
					tempNps = (NonPlayerShip) current1;
					count++;
					break;
					
				}
				
			}
			if(count == 1) {

				while(iterator2.hasNext()) {
					
					current2 = iterator2.getNext();
					if(current2 instanceof Missile) {
						
						tempMissile = (Missile) current2;
						if(tempMissile.getMissileFlag() == 0) {
							
							count++;
							
						}
						
					}
					
				}
				if(count == 2) {
					
					worldList.remove(tempNps);
					worldList.remove(tempMissile);
					System.out.println("NPS and PS Missile destroyed");
					score++;
					callObserver();
					
				}
				else
					System.out.println("Error! Insufficient number of required objects in the game\n");
				
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");
			
		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
		
	}
	
	/* Method to handle the situation where the non player ship missile has struck and destroyed a 
	 * player ship. This method removes one NPS missile and a player ship
	 */
	public void explodePs() {
		
		Missile tempMissile = new Missile();
		IIterator iterator = worldList.getIterator();
		Object current = new Object();
		
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator.hasNext()) {
				
				current = iterator.getNext();
				if(current instanceof Missile) {
						
					tempMissile = (Missile) current;
					if(tempMissile.getMissileFlag() == 1) {
							
						count++;
						break;
							
					}	
					
				}

			}
			
			if(count == 1 && checkForPs()) {
				
				worldList.remove(tempMissile);
				worldList.remove(ps);
				
				System.out.println("PS and NPS Missile destroyed");
				callObserver();
					
				if(life > 1) 
					life--;
				else if(life == 1)
					gameOver();
					
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");
			
		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
		
	}
	
	/*Method to handle the situation where a player ship has crashed into an asteroid. In this case
	 * an asteroid and a player ship needs to be destroyed.
	 */
	public void crashPs() {
		
		Asteroid temp = new Asteroid();
		IIterator iterator = worldList.getIterator();
		Object current = new Object();
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator.hasNext()) {
				
				current = iterator.getNext();
				if(current instanceof Asteroid) {
					
					temp = (Asteroid) current;
					count++;
					break;
					
				}
			
			}
			if(checkForPs() && count == 1) {
				
				worldList.remove(ps);
				worldList.remove(temp);
				
				System.out.println("PS crashed into asteroid");
				callObserver();
				
				if(life > 1) 
					life--;
				else if(life == 1)
					gameOver();
				
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");

		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
		
	}
	
	/*Method invoked when a player ship collides with a non player ship. In this case, both the objects 
	 * are removed from the game
	 */
	public void psHitNps() {
		
		NonPlayerShip tempNps = new NonPlayerShip();
		IIterator iterator = worldList.getIterator();
		Object current = new Object();
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator.hasNext()) {
				
				current = iterator.getNext();
				if(current instanceof NonPlayerShip) {
					
					tempNps = (NonPlayerShip) current;
					count++;
					break;
					
				}
			
			}
			if(checkForPs() && count == 1) {
				
				worldList.remove(ps);
				worldList.remove(tempNps);
				
				System.out.println("PS has hit NPS");
				callObserver();
				
				if(life > 1) 
					life--;
				else if(life == 1)
					gameOver();
				
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");

		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
		
	}
	
	/*Method invoked when two asteroids have collided with each other. In this case, two asteroids are 
	 * removed from the game
	 */
	public void asteroidsCollide() {
			
		Asteroid[] temp = new Asteroid[2];
		IIterator iterator = worldList.getIterator();
		Object current = new Object();
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator.hasNext()) {
				
				current = iterator.getNext();
				if(current instanceof Asteroid) {
					
					temp[count] = (Asteroid) current;
					count++;
					
				}
				
				if(count == 2)
					break;
				
			}
			
			if(count == 2) {
				
				count--;
				worldList.remove(temp[count]);
				count--;
				worldList.remove(temp[count]);
				System.out.println("Two asteroids destroyed");
				callObserver();
				
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");
			
		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
		
	}
	
	/*Method invoked when an asteroid collides with a non player ship. In this case, both the objects are
	 *  removed from the game
	 */
	public void asteroidCollidesNps() {
				
		Asteroid tempAsteroid = new Asteroid();
		NonPlayerShip tempNps = new NonPlayerShip();
		IIterator iterator1 = worldList.getIterator();
		IIterator iterator2 = worldList.getIterator();
		Object current1 = new Object();
		Object current2 = new Object();
		int count = 0;
		
		if(worldList.size() != 0) {
			
			while(iterator1.hasNext()) {
				
				current1 = iterator1.getNext();
				if(current1 instanceof Asteroid) {
					
					tempAsteroid = (Asteroid) current1;
					count++;
					break;
					
				}
			
			}
			if(count == 1) {
				
				while(iterator2.hasNext()) {
					
					current2 = iterator2.getNext();
					if(current2 instanceof NonPlayerShip) {
						
						tempNps = (NonPlayerShip) current2;
						count++;
						break;
						
					}
					
				}
				if(count == 2) {
					
					worldList.remove(tempAsteroid);
					worldList.remove(tempNps);
					System.out.println("Asteroid collided with NPS");
					callObserver(); 					
				}
				else
					System.out.println("Error! Insufficient number of required objects in the game\n");
			
			}
			else
				System.out.println("Error! Insufficient number of required objects in the game\n");

		}
		else
			System.out.println("Error! Insufficient number of required objects in the game\n");
	}
	
	/*Method to tell the game world that the time or the 'game clocked' has ticked. Each tick of the 
	 * game clock tells all movable objects to update their positions, every missile's fuel level
	 * is reduced by one and any missiles which are depleted must be removed. Each space station toggles 
	 * its blinking light if the tick is zero and the game time elapsed is incremented by one. 
	 */
	public void tick() {
		
		IIterator iterator = worldList.getIterator();
		Object current = new Object();
		
		time++;
		System.out.println("Game Clock ticked");
		
		if(worldList.size() != 0) {
			
			while(iterator.hasNext()) {
				
				current = iterator.getNext();
				if(current instanceof IMovable) {
					
					IMovable mObj = (IMovable) current;
					mObj.move();
					
					if(mObj instanceof Missile) {
						
						Missile tempMissile = (Missile) current;
						if(tempMissile.getFuel() == 0)
							worldList.remove(tempMissile);
						else
							tempMissile.decreaseFuelLevel();
					}
					
				}
				
			}
			if(checkForStation()) {
				
				if(spaceStation.getBlinkRate() % time == 0)
					spaceStation.toggleBlink();
				
			}
			
		}
		
		callObserver();
		
	}
	
	/*Method to print the current state of the game, which includes current score, number of missiles,
	 * current time elapsed.
	 */
	public void print() {
		
		System.out.println("\nGame State:\n*********************************************************************************************************\n");
		System.out.println("Current Score: " + score + "\n");
		
		if(checkForPs()) 			
			System.out.println("Number of missiles in player ship: " + ps.getMissileCount() + "\n");
		else
			System.out.println("Number of missiles in player ship: [Playership not initialized]\n");
		
		System.out.println("Time elapsed: " + time + "\n");
		System.out.println("Lives remaining: " + life + "\n");
		System.out.println("*********************************************************************************************************\n");
	}
	
	// Method to print the current world state
	public void map(){
		
		if(worldList.size() == 0) {
			
			System.out.println("There are no objects in the game!\n\n");
			
		}
		else {
			
			IIterator iterator = worldList.getIterator();
			
			while(iterator.hasNext()){
				
				System.out.print(iterator.getNext());
				
			}
			
			System.out.println();
			
		}
		
	}
	
	//Method to quit the game. This method asks the user for confirmation before exiting from the game
	public void quit() {	
		
		System.out.println("Quit option selected");
		new ClosingApp();
		
	}
	
	//Method to initiate the game over sequence. This is called whenever the number of lives for the player has reacher 0
	public void gameOver() {
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx     Game Over !!!     xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.exit(0);
		
	}
	
	//Method to return the missile count for the PS
	public int getMissileCount() {
		
		if(checkForPs())
			return ps.getMissileCount();
		else
			return 0;

	}
	
	//Method to return the lives for the player
	public int getLives() {
		
		return this.life;
		
	}
	
	//Method to return the points for the player
	public int getPoints() {
		
		return this.score;
		
	}
	
	///Method to return the time
	public int getTime() {
		
		return this.time;
		
	}

	//Method to determine if the sound attribute od true or false
	@Override
	public boolean checkSound() {
		
		return (this.sound?true:false);
		
	}
	
	//returns the height of the canvas
	public int getHeight() {
		
		return gameHeight;
		
	}
	
	//returns the width of the canvas
	public int getWidth() {
		
		return gameWidth;
		
	}
	
	//sets the height of the canvas
	public void setHeight(int height) {
		
		this.gameHeight = height;
		
	}
	
	//sets the width of the canvas
	public void setWidth(int width) {
		
		this.gameWidth = width;
		
	}
	
	//toggles sound to true or false
	public void soundToggle() {
		
		this.sound = !sound;
		callObserver();
		
	}
	
	//checks if a playerShip exists in the gameWorld
	private boolean checkForPs() {
		
		IIterator objIterator = worldList.getIterator();
		Object currentObj = new Object();
	
		while(objIterator.hasNext()) {
				
			currentObj = (GameObject)objIterator.getNext();
			if(currentObj instanceof PlayerShip)
				return true;
				
		}

		return false;	
		
	}
	
	//checks if a nonPlayerShip exists in the gameWorld
	private boolean checkForNps() {
		
		IIterator objIterator = worldList.getIterator();
		Object currentObj = new Object();
		
		while(objIterator.hasNext()) {
			
			currentObj = objIterator.getNext();
			if(currentObj instanceof NonPlayerShip)
				return true;
			
		}
	
		return false;
		
	}
	
	//Checks if a spaceStation exists in the gameWorld
	private boolean checkForStation() {
		
		IIterator objIterator = worldList.getIterator();
		Object currentObj = new Object();
		
		while(objIterator.hasNext()) {
			
			currentObj = objIterator.getNext();
			if(currentObj instanceof SpaceStation)
				return true;
			
		}
	
		return false;
		
	}
	
}
