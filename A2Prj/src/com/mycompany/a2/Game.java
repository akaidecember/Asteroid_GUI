package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.MenuBar;
import com.codename1.ui.SideMenuBar;
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
	private Container container;
	
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
	
	//GameButtons
	private CommandButtons b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22;
	
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
		
		//Add commands to create the form
		this.setLayout(new BorderLayout());
		
		this.add(BorderLayout.CENTER, mv);						//Centre container
		this.add(BorderLayout.NORTH, pv);						//north container
		
		//West Container to hold the buttons for game commands
		container = new Container();
		container.getAllStyles().setBgTransparency(0);
		container.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		container.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.YELLOW));
		this.add(BorderLayout.WEST, container);
		
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

		
		//Adding the menus to the container
		
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
		
		//Adding the buttons to the container
		container.add(b1);
		container.add(b2);
		container.add(b3);
		container.add(b4);
		container.add(b5);
		container.add(b6);
		container.add(b7);
		container.add(b8);
		container.add(b9);
		container.add(b10);
		container.add(b11);
		container.add(b12);
		container.add(b13);
		container.add(b14);
		container.add(b15);
		container.add(b16);
		container.add(b17);
		container.add(b18);
		container.add(b19);
		container.add(b20);
		container.add(b21);
		container.add(b22);

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
		b14.setEnabled(true);
		b15.setEnabled(true);
		b16.setEnabled(true);
		b17.setEnabled(true);
		b18.setEnabled(true);
		b19.setEnabled(true);
		b20.setEnabled(true);
		b21.setEnabled(true);
		
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
				
		this.show();
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		gw.callObserver();
		gw.init();
		
	}

	@Override
	public void run() {
		
		
		
	}
	
}
