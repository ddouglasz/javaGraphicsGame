package zombieRush;

import acm.graphics.*; 
import acm.program.GraphicsProgram;
import java.awt.*;

public class Planet extends GCompound {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Planet(){
		GImage planet= new GImage("background.PNG");
		planet.scale(100,100);
		add(planet,0,0);
	}
}
