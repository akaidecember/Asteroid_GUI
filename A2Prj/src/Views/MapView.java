package Views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.GameWorld;

import Collection.GameCollection;
import Interfaces.IGameWorld;

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

		//Since this is an empty container, map is called so that it prints on the console
		proxy.map();
		
	}

}
