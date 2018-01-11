package zombieRush;

import acm.graphics.*;;

public class Car extends GCompound{

	/**
	 * 
	 */

	private static final double BODY_WIDTH=0.5;
	private static final double BODY_HEIGHT=1;
	private static final double TOP_ROOF=0.4;

	private static final long serialVersionUID = 1L;

	public Car(int width, int height){
	//creating the general body top view of the car
	body=new GRect(width,height);
	add(body,0,0);
	
	frontScreen=createWindScreenFront(TOP_ROOF*width,TOP_ROOF*height);
	add(frontScreen,(width-TOP_ROOF*width)/2,(height*8/10));
	
	//creating the roof of the car
	top=new GRect(TOP_ROOF*width,TOP_ROOF*height);
	add(top,(width-TOP_ROOF*width)/2,(height*3/10));
	 
	
	
	}
	//creating the wind screens of the car
	private GPolygon createWindScreenFront(double width, double height){
	windScreenFront=new GPolygon();
	windScreenFront.addVertex((width)/5, -height/2);
	windScreenFront.addVertex(0,height/2);
	windScreenFront.addVertex(width,height/2);
	windScreenFront.addVertex(width*4/5,-height/2);
	return windScreenFront;
	}
	private GRect body,top;
	private GPolygon windScreenFront,windScreenBack, frontScreen, backScreen;

	
}
