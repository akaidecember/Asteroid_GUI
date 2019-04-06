package CommandButton;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;

public class CommandButtons extends Button{

	//Constructor for the class CommandButtons
	public CommandButtons(String label, Command cmd, int color) {
		
		super(label);
		
		//setting the styles for the buttons
		this.getAllStyles().setBgTransparency(0);
		this.getAllStyles().setBorder(Border.createBevelRaised());
		this.getAllStyles().setBorder(Border.createBevelLowered());
		this.getAllStyles().setBorder(Border.createDoubleBorder(2, ColorUtil.YELLOW));
  		this.getAllStyles().setPadding(TOP, 1);
  		this.getAllStyles().setPadding(BOTTOM, 1);
  		
		this.getUnselectedStyle().setBgColor(color);
		this.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		
		this.getSelectedStyle().setBgTransparency(255);
		this.getSelectedStyle().setBgColor(ColorUtil.GREEN);
		this.getSelectedStyle().setFgColor(ColorUtil.BLUE);
		
		//setting the command
		this.setCommand(cmd);
		
	}
	
}
