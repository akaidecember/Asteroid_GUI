package Views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

import Interfaces.IGameWorld;

public class PointsView extends Container implements Observer{

	//Attributes for the class PointsView
	
	private Label points;
	private Label sound;
	private Label missiles;
	private Label time;
	private Label lives;
	
	//Behaviours for the class PointsView
	
	public PointsView() {
		
		//Laying out the labels
		this.setLayout(new FlowLayout(CENTER));
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.GREEN));
		this.getAllStyles().setBgTransparency(50);
		this.getAllStyles().setBgColor(ColorUtil.GREEN);
		
		//Initial labels 
		points = new Label("Points: 00\t");
		missiles = new Label("Missiles: 00\t");
		lives = new Label("Lives: 03\t");
		time = new Label("Time: 00\t");
		sound = new Label("Sound: OFF\t");
		
		//Setting the label styles
		
		points.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		points.getAllStyles().setBgTransparency(50);
		points.getAllStyles().setPadding(RIGHT, 8);
		points.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, ColorUtil.GREEN), Border.createLineBorder(1, ColorUtil.GREEN), null, null));
		
		missiles.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		missiles.getAllStyles().setBgTransparency(50);
		missiles.getAllStyles().setPadding(RIGHT, 5);
		missiles.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, ColorUtil.GREEN), Border.createLineBorder(1, ColorUtil.GREEN), null, null));
		
		lives.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		lives.getAllStyles().setBgTransparency(50);
		lives.getAllStyles().setPadding(RIGHT, 5);
		lives.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, ColorUtil.GREEN), Border.createLineBorder(1, ColorUtil.GREEN), null, null));
		
		time.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		time.getAllStyles().setBgTransparency(50);
		time.getAllStyles().setPadding(RIGHT, 5);
		time.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, ColorUtil.GREEN), Border.createLineBorder(1, ColorUtil.GREEN), null, null));
		
		sound.getAllStyles().setFgColor(ColorUtil.rgb(0,0,255));
		sound.getAllStyles().setBgTransparency(50);
		sound.getAllStyles().setPadding(RIGHT, 5);
		sound.getAllStyles().setBorder(Border.createCompoundBorder(Border.createLineBorder(1, ColorUtil.GREEN), Border.createLineBorder(1, ColorUtil.GREEN), null, null));
		
		//Adding the labels
		this.add(points);
		this.add(missiles);
		this.add(lives);
		this.add(sound);
		this.add(time);
		
	}
	
	@Override
	public void update(Observable observable, Object data) {
		
		//Getting new data upon update
		Integer curPoints = ((IGameWorld) data).getPoints();
		Integer curTime = ((IGameWorld) data).getTime();
		Integer curLives = ((IGameWorld) data).getLives();
		Integer curMissiles = ((IGameWorld) data).getMissileCount();
		
		//setting new data
		points.setText("Points: " + Integer.toString(curPoints) + " ");
		missiles.setText("Missiles: " + Integer.toString(curMissiles) + " ");
		lives.setText("Lives: " + Integer.toString(curLives) + " ");
		time.setText("Time: " + Integer.toString(curTime) + " ");
		
		//toggle sound on or off
		if(((IGameWorld) data).checkSound() == true)	
			sound.setText("Sound : ON\t");
		else
			sound.setText("Sound : OFF\t");
		
	}

}
