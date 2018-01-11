package zombieRush;


//TODO:TODO: this program is originally meant to display a
//an image saved in the project folder of this file
import java.awt.Image;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;


public class tankImage extends GCompound {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public tankImage (){
	GImage image=new GImage ("fighter.PNG");
	image.scale(0.1,0.1);
	add(image,0,10); 
 
	}
}

