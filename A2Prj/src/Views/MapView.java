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
import Interfaces.ICollider;
import Interfaces.IDrawable;

public class MapView extends Container implements Observer{

	//Attributes for the class MapView-----------------------------------------------------------------------------------------
	private IGameWorld proxy;
	private GameCollection objects;
	
	//Behaviours for the class MapView-----------------------------------------------------------------------------------------
	public MapView(GameWorld proxy) {
		
		this.proxy = proxy;
		this.objects = this.proxy.getObjects();
		
	}
	
	@Override
	public void update(Observable observable, Object data) {

		if(data instanceof IGameWorld)
			proxy = (IGameWorld)data;
		
		this.objects = proxy.getObjects();
		
		setWidth(GameWorld.getWidth());
		setHeight(GameWorld.getHeight());
		
		this.repaint();
		proxy.map();
		
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
