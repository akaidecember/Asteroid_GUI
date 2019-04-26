package Interfaces;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point2D;

public interface ISelectable {

	public boolean contains(Point2D pPtrRelPrnt, Point2D pCmpRelPrnt);
	public void setSelected(boolean select);
	public boolean isSelected();
	public void draw(Graphics g, Point2D pCmpRelPrnt);
	
}
