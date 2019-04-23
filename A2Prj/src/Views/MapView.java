package Views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.GameWorld;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

import Collection.GameCollection;
import Interfaces.IGameWorld;
import Interfaces.IIterator;
import Objects.GameObject;
import Interfaces.IDrawable;

public class MapView extends Container implements Observer{

	//Attributes for the class MapView-----------------------------------------------------------------------------------------
	private IGameWorld proxy;
	private GameCollection objects;
	
	//Behaviours for the class MapView-----------------------------------------------------------------------------------------
	public MapView(GameWorld proxy) {
		
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.BLUE));
		
		this.proxy = proxy;
		
	}
	
	@Override
	public void update(Observable observable, Object data) {

		setWidth(proxy.getWidth());
		setHeight(proxy.getHeight());
		this.repaint();
		proxy.map();s
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Point2D pCmpRelPrnt = new Point2D(getX(), getY());
		
		IIterator iterator = objects.getIterator();
		
		while(iterator.hasNext()) {
			
			Object object = (GameObject)iterator.getNext();
			((IDrawable)object).draw(g, pCmpRelPrnt);
			
		}
		
	}

}
