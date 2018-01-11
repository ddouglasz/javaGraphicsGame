package zombieRush;
 
import java.awt.Image;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;


public class CloudEffect1 extends GCompound{
	public CloudEffect1(){
		GImage cloud1=new GImage("cloud1.PNG");
		 cloud1.scale(5,5 );
		 cloud1.rotate(2);
		add(cloud1,0,0);
		
		GImage cloud2=new GImage("cloud2.PNG");
		//cloud2.scale(0.5,0.5);
		add(cloud2,100,100);
		
		GImage cloud3=new GImage("cloud1.PNG");
		cloud3.scale(2,2);
		add(cloud3,0,3);
		
		// GImage star=new GImage("star.PNG");
		// add(star,300,150);
		
	 
	}

}
