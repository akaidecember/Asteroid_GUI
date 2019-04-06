package com.mycompany.a2;

import java.util.Observable;

import Interfaces.IGameWorld;

public class GameWorldProxy extends Observable implements IGameWorld{
	
	//Attributes for the class GameWorldProxy----------------------------------------------------------------
	
	private GameWorld gw;
	
	//Behaviours for the class GameWorldProxy----------------------------------------------------------------
	
	//Parameterized constructor for the class GameWorldProxy
	public GameWorldProxy(GameWorld gw) {
		
		this.gw = gw;
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAsteroid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increasePsSpeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreasePsSpeed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPsLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnPsRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void firePs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fireNps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hyperJump() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadMissiles() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killAsteroidPs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminateNps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void explodePs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crashPs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void psHitNps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asteroidsCollide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asteroidCollidesNps() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void map() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMissileCount() {
		// TODO Auto-generated method stub
		return gw.getMissileCount();
	}

	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return gw.getLives();

	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return gw.getPoints();
	}

	@Override
	public int getTime() {
		// TODO Auto-generated method stub
		return gw.getTime();
	}

	@Override
	public boolean checkSound() {
		// TODO Auto-generated method stub
		return gw.checkSound();
	}

	@Override
	public void turnLauncherLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnLauncherRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void soundToggle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(int height) {
		// TODO Auto-generated method stub
		
	}
	
}
