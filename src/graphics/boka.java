package zombieRush;
import acm.graphics.GCompound;
import acm.graphics.GImage;

//building the attacker class for the ufo game.
public class boka extends GCompound {

	 private static final long serialVersionUID = 1L;
	public boka  (){
	 GImage boka= new GImage("boka2.PNG");
	   boka.scale(1,1);
	 add(boka,100,300);
	}

 }
 