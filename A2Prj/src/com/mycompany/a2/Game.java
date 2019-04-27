package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.MenuBar;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UITimer;
import CommandButton.CommandButtons;
import Commands.*;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import Views.MapView;
import Views.PointsView;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form implements Runnable{

	private GameWorld gw;
	private MapView mv;
	private PointsView pv;
	private UITimer timer;
	
	//Objects for the commands
	private AddAsteroid addAsteroid;
	private AddNps addNps;
	private AddStation addStation;
	private AddPs addPs;
	private IncreasePsSpeed increasePsSpeed;
	private DecreasePsSpeed decreasePsSpeed;
	private TurnPsLeft turnPsLeft;
	private TurnPsRight turnPsRight;
	private TurnLauncherLeft turnLauncherLeft;
	private TurnLauncherRight turnLauncherRight;
	private FirePs firePs;
	private FireNps fireNps;
	private HyperJump hyperJump;
	private LoadMissiles loadMissiles;
	private KillAsteroidPs killAsteroidPs;
	private EliminateNps eliminateNps;
	private ExplodePs explodePs;
	private CrashPs crashPs;
	private PsHitNps psHitNps;
	private AsteroidsCollide asteroidsCollide;
	private AsteroidCollidesNps asteroidCollidesNps;
	private Tick tick;
	private QuitGame quitGame;
	private About about;
	private PrintMap printMap;
	private PrintDisplay printDisplay;
	private Pause pauseCommand;
	
	//GameButtons
	private CommandButtons b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
	
	//Constructor
	public Game() {
		
		//Setting the bg color for the game
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.GRAY);
		
		gw = new GameWorld();									//Creating an observable
		mv = new MapView(gw);									//Create an observable for the map
		pv = new PointsView();									//Create an Observer for the points
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		//Initializing the UITimer timer field and starting the timer in the constructor
		timer = new UITimer(this);
		startTime(timer);
		
		//Add commands to create the form
		this.setLayout(new BorderLayout());
		
		//Creating the top container
		Container top = new Container();
		top.setLayout(new FlowLayout(Component.CENTER));
		this.add(BorderLayout.NORTH, top);						//Adding the top container to the form
		top.add(pv);											//Adding the points view to the top container
		
		//Creating the center container for the mapView
		Container center = new Container();
		center.getAllStyles().setBgTransparency(255);
		center.getAllStyles().setBgColor(ColorUtil.BLACK);
		center.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLUE));
		this.add(BorderLayout.CENTER, center);
		
		//this.add(BorderLayout.CENTER, mv);						//Centre container
		//this.add(BorderLayout.NORTH, pv);						//north container
		
		//West Container to hold the buttons for game commands
		Container left = new Container();
		left.getAllStyles().setBgTransparency(0);
		left.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		left.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.YELLOW));
		this.add(BorderLayout.WEST, left);
		
		//Tool bar
		Toolbar toolBar = new Toolbar();
		toolBar.setUIID("mainToolBar");
		toolBar.getAllStyles().setBgTransparency(0);
		toolBar.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.rgb(100,0,0)));
		this.setToolbar(toolBar);
		toolBar.setTitle("Asteroid Game");
		toolBar.getTitleComponent().getAllStyles().setFgColor(ColorUtil.BLUE);
		
		//Side menu
		Command newGame = new Command("New");
		Command saveGame = new Command("Save");
		Command undoAction = new Command("Undo");
		CheckBox soundBox = new CheckBox();
		soundBox.getAllStyles().setBgTransparency(255);
		Command sCommand = new Sound(soundBox, gw);
		soundBox.setCommand(sCommand);
		soundBox.setSelected(true);
		about = new About();
		quitGame = new QuitGame(gw);

		//Commands
		addAsteroid = new AddAsteroid(gw);
		addNps = new AddNps(gw);
		addStation = new AddStation(gw);
		addPs = new AddPs(gw);
		increasePsSpeed = new IncreasePsSpeed(gw);
		decreasePsSpeed = new DecreasePsSpeed(gw);
		turnPsLeft = new TurnPsLeft(gw);
		turnPsRight = new TurnPsRight(gw);
		turnLauncherLeft = new TurnLauncherLeft(gw);
		turnLauncherRight = new TurnLauncherRight(gw);
		firePs = new FirePs(gw);
		fireNps = new FireNps(gw);
		hyperJump = new HyperJump(gw);
		loadMissiles = new LoadMissiles(gw);
		killAsteroidPs = new KillAsteroidPs(gw);
		eliminateNps = new EliminateNps(gw);
		explodePs = new ExplodePs(gw);
		crashPs = new CrashPs(gw);
		psHitNps = new PsHitNps(gw);
		asteroidsCollide = new AsteroidsCollide(gw);
		asteroidCollidesNps = new AsteroidCollidesNps(gw);
		tick = new Tick(gw);
		printDisplay = new PrintDisplay(gw);
		printMap = new PrintMap(gw);
		pauseCommand = new Pause(timer, gw, this);

		//Adding the menus to the container-----------
		
		//Adding to the side menu
		toolBar.addComponentToSideMenu(soundBox);
		toolBar.addCommandToSideMenu(newGame);
		toolBar.addCommandToSideMenu(saveGame);
		toolBar.addCommandToSideMenu(undoAction);
		toolBar.addCommandToSideMenu(about);
		toolBar.addCommandToSideMenu(quitGame);

		//initializing buttons
		b1 = new CommandButtons("+ Asteroid", addAsteroid, ColorUtil.BLUE);
		b2 = new CommandButtons("+ NPS", addNps, ColorUtil.BLUE);
		b3 = new CommandButtons("+ Space Station", addStation, ColorUtil.BLUE);
		b4 = new CommandButtons("+ PS (1)", addPs, ColorUtil.BLUE);
		b5 = new CommandButtons("PS Speed (+)", increasePsSpeed, ColorUtil.BLUE);
		b6 = new CommandButtons("PS Speed (-)", decreasePsSpeed, ColorUtil.BLUE);
		b7 = new CommandButtons("PS Left", turnPsLeft, ColorUtil.BLUE);
		b8 = new CommandButtons("PS Right", turnPsRight, ColorUtil.BLUE);
		b9 = new CommandButtons("MSL Left", turnLauncherLeft, ColorUtil.BLUE);
		b10 = new CommandButtons("MSL Right", turnLauncherRight, ColorUtil.BLUE);
		b11 = new CommandButtons("PS Fire", firePs, ColorUtil.BLUE);
		b12 = new CommandButtons("NPS Fire", fireNps, ColorUtil.BLUE);
		b13 = new CommandButtons("Jump", hyperJump, ColorUtil.BLUE);
		b14 = new CommandButtons("Load PS", loadMissiles, ColorUtil.BLUE);
		b15 = new CommandButtons("PS missile (Asteroid)", killAsteroidPs, ColorUtil.BLUE);
		b16 = new CommandButtons("PS Missile (NPS)", eliminateNps, ColorUtil.BLUE);
		b17 = new CommandButtons("NPS Missile (PS)", explodePs, ColorUtil.BLUE);
		b18 = new CommandButtons("PS (Asteroid)", crashPs, ColorUtil.BLUE);
		b19 = new CommandButtons("PS (NPS)", psHitNps, ColorUtil.BLUE);
		b20 = new CommandButtons("Asteroid (Asteroid)", asteroidsCollide, ColorUtil.BLUE);
		b21 = new CommandButtons("Asteroid (NPS)", asteroidCollidesNps, ColorUtil.BLUE);
		b22 = new CommandButtons("Tick", tick, ColorUtil.BLUE);
		b23 = new CommandButtons("Pause", pauseCommand, ColorUtil.BLUE);
		
		//Adding the buttons to the container
		left.add(b1);
		left.add(b2);
		left.add(b3);
		left.add(b4);
		left.add(b5);
		left.add(b6);
		left.add(b7);
		left.add(b8);
		left.add(b9);
		left.add(b10);
		left.add(b11);
		left.add(b12);
		left.add(b13);
		//left.add(b14);
		left.add(b15);
		left.add(b16);
		left.add(b17);
		left.add(b18);
		left.add(b19);
		left.add(b20);
		left.add(b21);
		//left.add(b22);
		left.add(b23);
		
		//Calling the notPaused function to enable the buttons only if the game is not currently paused
		gameNotPaused();
		
		this.show();
		mv.setHeight(center.getHeight());
		mv.setWidth(center.getWidth());
		
		//Setting the attributes of the GameWorld width and height to the dimensions of the center container 
		gw.setHeight((int)center.getHeight());
		gw.setWidth((int)center.getWidth());
		
		//Adding the mapView to the center container
		center.add(mv);
		
		gw.callObserver();
		gw.init();
				
	}
	
	public void gameNotPaused() {
		
		//Enabling the buttons
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
		b10.setEnabled(true);
		b11.setEnabled(true);
		b12.setEnabled(true);
		b13.setEnabled(true);
		//b14.setEnabled(true);
		b15.setEnabled(true);
		b16.setEnabled(true);
		b17.setEnabled(true);
		b18.setEnabled(true);
		b19.setEnabled(true);
		b20.setEnabled(true);
		b21.setEnabled(true);
		
		//Setting the pause button
		b23.setText("Pause");
		
		//Adding the key listeners
		this.addKeyListener('i', increasePsSpeed);
		this.addKeyListener(-91, increasePsSpeed);
		this.addKeyListener('d', decreasePsSpeed);
		this.addKeyListener(-92, decreasePsSpeed);
		this.addKeyListener('l', turnPsLeft);
		this.addKeyListener('r', turnPsRight);
		this.addKeyListener(-93, turnPsLeft);
		this.addKeyListener(-94, turnPsRight);
		this.addKeyListener(',', turnLauncherLeft);
		this.addKeyListener('.', turnLauncherRight);
		this.addKeyListener('j', hyperJump);
		this.addKeyListener(-90, firePs);
		this.addKeyListener('q', quitGame);
		this.addKeyListener('M', printMap);
		this.addKeyListener('P', printDisplay);
		
	}
	
	//Disabling all the appropriate buttons if the game is paused
	public void gamePaused() {
		
		//Enabling the buttons
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
		b10.setEnabled(false);
		b11.setEnabled(false);
		b12.setEnabled(false);
		b13.setEnabled(false);
		//b14.setEnabled(false);
		b15.setEnabled(false);
		b16.setEnabled(false);
		b17.setEnabled(false);
		b18.setEnabled(false);
		b19.setEnabled(false);
		b20.setEnabled(false);
		b21.setEnabled(false);
		
		//Setting the pause button
		b23.setText("Resume");
		
		//Adding the key listeners
		this.removeKeyListener('i', increasePsSpeed);
		this.removeKeyListener(-91, increasePsSpeed);
		this.removeKeyListener('d', decreasePsSpeed);
		this.removeKeyListener(-92, decreasePsSpeed);
		this.removeKeyListener('l', turnPsLeft);
		this.removeKeyListener('r', turnPsRight);
		this.removeKeyListener(-93, turnPsLeft);
		this.removeKeyListener(-94, turnPsRight);
		this.removeKeyListener(',', turnLauncherLeft);
		this.removeKeyListener('.', turnLauncherRight);
		this.removeKeyListener('j', hyperJump);
		this.removeKeyListener(-90, firePs);
		this.addKeyListener('q', quitGame);
		this.removeKeyListener('M', printMap);
		this.removeKeyListener('P', printDisplay);
		
	}

	@Override
	public void run() {
		
		//Tick the game and call repaint if the game is not paused
		if(gw.isPaused() == false){
			
			gw.tick();
			mv.repaint();
			
		}
			
	}
	
	public void startTime(UITimer t) {
		
		t.schedule(100, true, this);
		
	}
	
	public void stopTime(UITimer t) {
		
		t.cancel();
		
	}
	
}
