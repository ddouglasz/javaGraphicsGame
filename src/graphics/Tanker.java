package zombieRush;


import acm.graphics.*; 
import acm.program.GraphicsProgram;

import java.awt.Color;

public class Tanker extends GCompound {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2226791354038410849L;
	public static final double TANKBODY_WIDTH=1.0;
	public static final double TANKBODY_HEIGHT=0.5;
	public static final double TANKGUN_WIDTH=0.5;
	public static final double TANKGUN_HEIGHT=1.0;
	public Tanker(double width,double height){
		//tank1=new GRect(width,height);
		body=new GRect(TANKBODY_WIDTH*width,TANKBODY_HEIGHT*height);
		body.setFilled(true);
		gun=new GRect(TANKGUN_WIDTH*width,TANKGUN_HEIGHT*height);
		gun.setFilled(true);
		add(body,0.0*width,1.0*height);
	    add(gun,0.5*width-TANKGUN_WIDTH*width/2.0,0.5*height);
		//add(tank1,0,0);
	}
	private GRect body;
	private GRect gun;
	private GRect tank1;

}