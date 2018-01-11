package zombieRush;

import java.awt.*;
import java.awt.event.*;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.graphics.*;
 	

//import java.io.*;

 
//import ufo.Tanker;
public class UFO extends GraphicsProgram{
	/**
	 * 
	 */
	private CloudEffect1 cloud1;
	private static final long serialVersionUID = 1L;
	private static  final int UFO_WIDTH=40;
	private static final int UFO_HEIGHT=UFO_WIDTH/2;
	/**Animation cycle delay*/
	private static final int DELAY=10;
	private int UFO_SPEED=5;
	/*size and speed of the bullets*/
	private static final int BULLET_SPEED=60;
	private static final int BULLET_DIAM=10;
	private static final int BULLET_WIDTH=5;
	private static final int BULLET_HEIGHT=10;
	
	 /**size and speed of the block*/
	private static final int BLOCK_WIDTH=100;
	private static final int BLOCK_HEIGHT=20;
	private static final int BLOCK_SPEED=2;
	private static final int TANK_WIDTH=10;
	private static final int TANK_HEIGHT=20;
	private static final int WORLD_WIDTH=300;
	private static final int WORLD_HEIGHT=500;
	private static final int POINTS=10;
	private double FIGHTER_SPEED1=1;
	private static final double ATTACK_SPEED=0.3;
	
	private int LIFE=3;
	
	//private GCanvas gamePoint;

	//private final static int TANK2_WIDTH=20;
//	private static final int TANK2_HEIGHT=15;
	private static final int DELTA_X=-10;
	private static final String MESSAGE="in the begining was the end, and the end was war...";
	
	private static final int PAUSE_TIME=20;
	
   public void run(){	
	   
	   //GImage ig=new GImage("panther.jpg");
	   //ig.scale(0.5,0.5);
	   //add(ig,100,100);
	   
	     setup();
	  //   fighterJet.move(0,20);
	    
	 	while (true){
		//	moveUFO();
	 		moveCloud1();
	 	     moveAttack();
			moveBlock();
			moveBullet();
			checkForCollision();
		//	displayInfo();
			//if(ufo==null){
				//add(ufo,50,50);
			if(cloud1==null){
				add(cloud1,100,0);
				checkForCollision();
			}
				
				
			//}
			pause(DELAY);
			//if(gameOver()){
				//presentLife=presentLife-1;
				//remove(ufo);
				//remove(bullet);
				//add(ufo,50,50);
				//remove(bar1); 
			}
			 
		}
	 	//remove(ufo);
	 	//GLabel go=new GLabel("game over!",20,40);
	 //   go.setFont("sanSeriff-20");
	 //	add(go,50,50);
 
  // }
   
	/**setup UFO and add mouse listeners*/
   
  //creating a world for the game interface
	private void setup(){

      //  ig=new tankImage();
		//add(ig,50,0);
		
		Planet pl=new Planet();
		add(pl,0,0);
		
		//GRect world= new GRect(WORLD_WIDTH,WORLD_HEIGHT);
		//add(world,10,10);
		
		//world.setColor(Color.red);
		//world.setFillColor(Color.GRAY);
		
		
		//world.setVisible(false);
		//world.setFilled(true);
		
		//creating a display to keep track of the player's progress
		//GRect display=new GRect(100,500);
		//add(display,310,10);
		//display.setColor(Color.red);
		
		
		//the GFace class for our Zombie(UFO)
		 ufo=new GFace(UFO_WIDTH,UFO_HEIGHT); 
	     //add(ufo,10,0);//UFO starts at top right
	     
	     //adding the side sliding block for the obstacle
		block=new GRect(BLOCK_WIDTH,BLOCK_HEIGHT); //adding the block as obstacle.
		block.setColor(Color.yellow);
		//block.setFilled(true);
		//add(block,0,getWidth()/2);
		
		//add(block,0,getWidth()/5);
		
		
		
		
		//adding the right rotor block for the obstacle
		blockL=new GRect(50,10);
				blockL.setFilled(true);
		blockL.setColor(Color.red);
	    //add(blockL,60,(10+WORLD_HEIGHT*2/5));

		
		//adding the left rotor block fior the obstacle
		blockR=new GRect(50,10);
		//add(blockR,(10+WORLD_WIDTH-50),(10+WORLD_HEIGHT*2/5));
		blockR.setFilled(true);
		//blockR.setColor(Color.red);
	
		//keeping track of the scores
		displayInfo();
		
		//adding a shooting tank
		 		
		//car= new Car(25,50);
		//add(car,20,100);
		
		
		//creating the fighter jet object from a png image
		//tank=new Tanker(TANK_WIDTH,TANK_HEIGHT);
		  fighterJet=new tankImage();
			//add(ig,50,0);
			
		 add(fighterJet,0,getHeight()-TANK_HEIGHT);
		 
		 
		 //adding the illusion of motion by adding a cloud
		 cloud1=new CloudEffect1();
		 add(cloud1,300,0);
		
		
		tankToRight=true;
		blockToRight=true;
		ufoToLeft=true;
		 addMouseListeners();
		 
		 //adding/testing a moving enemy
		 enemy= new boka();
		// add(enemy,getWidth()/2,150);
		 intro();
	}
	
	/**determine if game is over --true if either
	 * the UFO is destroyed or if the UFO lands*/
	//remember to put back ufo==null;
	private boolean gameOver(){
		return (ufo.getY()+UFO_HEIGHT>=10+WORLD_HEIGHT);
		
		//return (ufo==null);
		//return(block==null);
	 
	}
	/**when mouse is clicked, create bullet, unless bullet
	 * already exists*/
	
	
	//a detailed text on the activities and progress of the game.
	private void displayInfo(){
		if(ufo.getY()+UFO_HEIGHT>=10+WORLD_HEIGHT){
			lifeBar++;
		}
		if(lifeBar==1){
			remove(bar1);
		}else{
			 if(lifeBar==2){
				remove(bar2);
			}
		}
		
		
		life=new GLabel("life:");//,35,30);
		add(life,15,15);
		life.setFont("times-20");
		life.setColor(Color.RED);
		//life.setLabel("life:  "+presentLife);
		
		bar1=new GRect(10,10);
		add(bar1,50,4);
		bar1.setColor(Color.GREEN);
		bar1.setFilled(true);
		
		bar2=new GRect(10,10);
		add(bar2,62,4);
		bar2.setColor(Color.GREEN);
		bar2.setFilled(true);
		
		bar3=new GRect(10,10);
		add(bar3,74,4);
		bar3.setColor(Color.GREEN);
		bar3.setFilled(true);
		
		
		highScore=new GLabel("",35,30);
		add(highScore, 150,15);
		highScore.setLabel("high score:  "+presentHigh);
		highScore.setColor(Color.BLUE);
		highScore.setFont("sanSeriff-15");
		
		
		level=new GLabel("",35,30);
		add(level,300,15);
		level.setLabel("level:  "+presentLevel);
		level.setColor(Color.BLUE);
        level.setFont("sanSeriff-15");
	}
	
	public void mouseClicked(MouseEvent e){
		if(bullet==null){
			bullet=new GRect(0,0,BULLET_WIDTH,BULLET_HEIGHT+10);
			bullet.setFilled(true);
			bullet.setColor(Color.RED);
			//add(bullet,(getWidth()-BULLET_DIAM)/2,
				//	getHeight()-BULLET_DIAM);
			 add(bullet,fighterJet.getX()+33,fighterJet.getY());
			 
			 
			}
	}
	/**move UFO, if UFO has moved to edge of screen, 
	 * moves UFo and changes UFO direction.*/
	  private void intro(){
		   GLabel label = new GLabel(MESSAGE);
		   label.setFont("sanSeriff-100");
	
		   add(label,getWidth(),80);
		   while(label.getX()+label.getWidth()>0){
			   label.setColor(rg.nextColor());
			   label.move(DELTA_X, 0);
			   pause(PAUSE_TIME);
		   }
	   }
	
	private void moveCloud1(){
		cloud1.move(0,FIGHTER_SPEED1);
		//if(cloud1.getY()==50){
			
		//}
	}
	private void moveAttack(){
	 enemy.move(0,ATTACK_SPEED);
	}
private void moveUFO(){
	if(ufoToLeft){
		ufo.move(-UFO_SPEED,0);
		if(ufo.getX()<=10){
			ufoToLeft=false;
			ufo.move(0,UFO_HEIGHT);
			//if(ufo.getY()+UFO_HEIGHT==10+WORLD_HEIGHT){
				//presentLife-=presentLife;
				
			//}
			
		}
	}else{
		ufo.move(UFO_SPEED,0);
		if(ufo.getX()>=300-UFO_WIDTH){
			ufoToLeft=true;
			ufo.move(0,UFO_HEIGHT);
		}
	}
	
}
/**the bullet blocker feature*/
private void moveBlock(){
	//rotating the right block
	blockR.rotate(BLOCK_SPEED);
	//rotating the left block 
	blockL.rotate(-BLOCK_SPEED);
	
	//cloud1.rotate(2);
	
	//moving the third block
if(blockToRight){
	// block.rotate(BLOCK_SPEED);
	
	block.move(BLOCK_SPEED, 0);
	 if(block.getX()>=300-BLOCK_WIDTH){
		blockToRight=false;
		// remove(block);
		// block=null;
		
		
	 }
	 
	 
}else{
	 block.move(-BLOCK_SPEED, 0);
	 if(block.getX()<10){
		
		 blockToRight=true;
	 }
}
}


/**moves bullet*/
private void moveBullet(){ 
	if(bullet!=null){
		bullet.move(0,-BULLET_SPEED);
	}
}
/**checks for bullet interactions with the world
(either colliding with the UFO or moving off screen)*/
private void checkForCollision(){
	collideWithUfO();
	moveOffScreen();
	  //creating new bullet obstacles to make the game more intersting.
	collideWithBlock();
	UpdateEffect();
}
/**checks to see if UFO and object collides, if so, bullet and UFO
*  are removed and both variables are set to null */


//keeping track of the  game interface in case there for continous looping of effects.
private void UpdateEffect(){
	 
	if(cloud1.getY()== getHeight()){
	//	X=rg.nextDouble(1.0,3.0);
		remove(cloud1);
		//cloud1=null;
		//add(cloud1,X,0.0);
		add(cloud1,100,10);
		FIGHTER_SPEED1++;
	  }
	}

//Todo list for the collide with cloud and refresh and new stage 

private void RefreshCloud(){
	while(true){
		moveCloud1();
		
	}
}

private void collideWithUfO(){

	score=new GLabel("score:",35,30);
	add(score,600,15);
	score.setColor(Color.BLUE);
	score.setFont("sanSariff-15");
	 
	if(bullet!=null){
		GObject collObj=getElementAt(bullet.getX()+BULLET_DIAM,bullet.getY()+BULLET_DIAM);
		if(collObj==ufo){
			remove(ufo);
			remove(bullet);
			//add(ufo,50,50);
			
			presentScore+=POINTS;
			add(score, 600,15);
			score.setLabel("            "+presentScore);
			
			UFO_SPEED+=1;
			//ufo=null;
			
		}
		
	}

}


/**checking to see if the bullet have collided with the block*/
private void collideWithBlock(){
if(bullet!=null){
	GObject collObj=getElementAt(bullet.getX(),bullet.getY());
	if(collObj==block){
		remove(bullet);
		bullet=null;
	}
}
}
/**determine if the bullet has moved offScreen,
* if it has, remove bullet and sets variable to null*/
private void moveOffScreen(){
	if(bullet!=null){
		if(bullet.getY()<=-BULLET_DIAM+10){
			remove(bullet);
			bullet=null;
			//add(bullet,20,0);
      }
	}
}
//creating the activity that moves the mouse from one part of the wall to the other.
public void mouseMoved(MouseEvent e){
	 
	fighterJet.move(e.getX()-lastX,0);
	//fighterJet.move(0,e.getY()-lastY);
	//fighterJet.move(0,e.getY()-lastY);
	//tank.rotate(e.getX()-lastX);
	//tank.movePolar(100,45);
	lastX=e.getX();
	lastY=e.getY();
	
	}
	 
 
 

/*private instance variables*/
private GLabel life,score,highScore, level;
private double lastX;
private double lastY;
private tankImage fighterJet;
//private Tanker tank;
//private Car car;
private GFace ufo;
//private GImage image;
private GRect bullet;
private GRect block,blockL,blockR,bar1,bar2,bar3;//tank,tank2;

private boolean ufoToLeft;//when true, UFO is moving to left
private boolean blockToRight; //When true, block is moving to right
private boolean tankToRight;
private int presentLife=3;
private int presentScore=0;
private int presentLevel=1;
private int presentHigh=0;
private int lifeBar=0;
private boka enemy;
//private CloudEffect1 cloud1;
private RandomGenerator rg=new RandomGenerator(); 
//private double X=5.0;
   
	}

	
		
