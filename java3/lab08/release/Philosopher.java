package release;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Philosopher {
	
	Point location;
	private static final int SIZE = 50;
	Color faceColor=Color.DARK_GRAY;
	Color eyeColor=Color.black;
    Color noseColor=Color.gray;
    Color mouthColor=Color.black;
    Color pupilColor=Color.cyan;
    boolean hasOne=false;

	
	private final int EAT = 5;
	private final int THINK = 4;
	private final int HUNGRY = 3;
	private final int FAMISHED = 2;
	private final int STARVE = 1;
	
	private int status = THINK;
	
	private int numberOfTries = 2;
	private static int  tries = 2;
	
	synchronized void hasOne(boolean b){
		hasOne=b;
	}
	
	public int getStatus() {
		return status;
	}
	synchronized void setStatus(int i) {
		status=i;
	}

	public Philosopher(Point location) {
		this.location=location;
	
		// TODO Auto-generated constructor stub
	}

	synchronized void changeStatus(Chopsticks c1, Chopsticks c2,int phil) {

		if(this.getStatus()==STARVE){
			return;
		}
		
		else if(this.getStatus()==EAT){
			c1.setAvailable(-1);
	    	c2.setAvailable(-1);
	    	setStatus(THINK);
		}
		
		else if(this.getStatus()==FAMISHED){
			
			if(c1.getAvailable()<0&&c2.getAvailable()<0){
				setStatus(EAT);
				hasOne(false);
		    	c1.setAvailable(phil);
		    	c2.setAvailable(phil);
		    	numberOfTries=tries;
		    }
			
			else if(c1.getAvailable()<0 && c2.getAvailable()==phil){
				setStatus(EAT);
				
				c1.setAvailable(phil);
				numberOfTries=tries;
				}
		
			else if(c1.getAvailable()==phil && c2.getAvailable()<0){
				setStatus(EAT);
				
				c2.setAvailable(phil);
				numberOfTries=tries;
				}
			else{
			
				if(c2.getAvailable()==phil){c2.setAvailable(-1);}
		    	if(c2.getAvailable()==phil){c1.setAvailable(-1);}
		    	if(numberOfTries<=0){setStatus(STARVE);hasOne(false);}
			}			
		}
		
		else if(this.getStatus()==HUNGRY){
			if(c1.getAvailable()<0&&c2.getAvailable()<0){
				setStatus(EAT);
			
		    	c1.setAvailable(phil);
		    	c2.setAvailable(phil);
		    	numberOfTries=tries;
		    }
			
			else if(c1.getAvailable()<0 && c2.getAvailable()==phil){
				setStatus(EAT);
				
				c1.setAvailable(phil);
				numberOfTries=tries;
				}
		
			else if(c1.getAvailable()==phil && c2.getAvailable()<0){
				setStatus(EAT);
			
				c2.setAvailable(phil);
				numberOfTries=tries;
				}
			
			else{
				if(c1.getAvailable()==phil || c2.getAvailable()==phil){
					hasOne(true);
				}
				
				if(numberOfTries==0){setStatus(FAMISHED);numberOfTries=tries;}else{
					numberOfTries--;
				}
				
				
			}	
			
			
			
		}
		
		else if(this.getStatus()==THINK){
			if(c1.getAvailable()<0&&c2.getAvailable()<0){
				setStatus(EAT);
				
		    	c1.setAvailable(phil);
		    	c2.setAvailable(phil);
		    	numberOfTries=tries;
		    }
			
			else if(c1.getAvailable()<0 && c2.getAvailable()==phil){
				setStatus(EAT);
			
				c1.setAvailable(phil);
				numberOfTries=tries;
				}
		
			else if(c1.getAvailable()==phil && c2.getAvailable()<0){
				setStatus(EAT);
				
				c2.setAvailable(phil);
				numberOfTries=tries;
				}
			
			else{
				if(c1.getAvailable()==phil || c2.getAvailable()==phil){
					hasOne(true);
				}
				
				if(numberOfTries==0){setStatus(HUNGRY);numberOfTries=tries;}else{
					numberOfTries--;
				}
				
			}	
			
			
			
		}		
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public void draw(Graphics page)
	   {  int       startX, startY, height, width;
	      Rectangle spot;

	// Draw face.

	     
		page.setColor(faceColor);      
	   
		page.fillOval(location.x, location.y, SIZE, SIZE );

	// Draw eyes.

	      startX = location.x + SIZE/5; 
	      startY = location.y + SIZE/5;
	      width  = SIZE/5;
	      height = SIZE/5;
	      page.setColor(eyeColor);   
	      page.fillOval(startX, startY, width, height );
	      startX = location.x + 3*SIZE/5; 
	      page.fillOval(startX, startY, width, height);

	// Draw nose.

	      startX = location.x + SIZE/2-3; 
	      startY = location.y + SIZE/5+5;
	      height = 10;                    
	      width  = 6; 
	      page.setColor(noseColor);       
	      page.fillRoundRect(startX, startY,width,height,3,3);

	// Draw mouth.

	      startX = location.x + SIZE/5;
	      startY = location.y + 3 * SIZE /5;
	      page.setColor(mouthColor);
	      height = 3;
	      if (status == HUNGRY) height = 5;
	      if (status == FAMISHED) height = 8;  
	      page.fillRoundRect(startX, startY, 3*SIZE/5, height, 3, 3); 

	      switch (status)
	      {  case EAT:
	            page.setColor(Runner.chopStickColor);
	            startX = location.x + 2*SIZE/5;
	            startY = location.y + 7*SIZE/10;
	            width  = -10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            Runner.fatLine(page,spot,new Dimension(3,3));
	            startX = location.x + 3*SIZE /5;
	            width  = 10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            Runner.fatLine(page,spot,new Dimension(3,3)); 
	         case THINK:
	        	 
	            startX = location.x + SIZE/4;   // Draw pupils.
	            startY = location.y + SIZE/4;
	            width  = SIZE/10;
	            height = SIZE/10;
	            page.setColor(pupilColor);   
	            page.fillOval(startX, startY, width, height );
	            startX = location.x + 2*SIZE/5+SIZE/4;
	            page.fillOval(startX, startY, width, height );
	            if(hasOne){page.setColor(Runner.chopStickColor);
	            startX = location.x + 2*SIZE/5;
	            startY = location.y + 7*SIZE/10;
	            width  = -10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            Runner.fatLine(page,spot,new Dimension(3,3));}
	            
	            break;
	         case STARVE:
	            startX = location.x + SIZE/5;   // Draw x for pupils.
	            startY = location.y + SIZE/5;
	            width  = SIZE/5;
	            height = SIZE/5;
	            page.setColor(pupilColor);   
	            page.drawLine(startX,startY,startX+width,startY+height);
	            page.drawLine(startX+width,startY,startX,startY+height);
	            startX = location.x + 3*SIZE/5; 
	            page.drawLine(startX,startY,startX+width,startY+height);
	            page.drawLine(startX+width,startY,startX,startY+height);        
	            
	            break;
	         case HUNGRY:
	            startX = location.x + SIZE/4;   // Draw pupils.
	            startY = location.y + 3*SIZE/10;
	            width  = SIZE/7;
	            height = SIZE/7;
	            page.setColor(pupilColor);   
	            page.fillOval(startX, startY, width, height );
	            startX = location.x + 2*SIZE/5+SIZE/4;
	            page.fillOval(startX, startY, width, height );
	            
	            
	            if(hasOne){page.setColor(Runner.chopStickColor);
	            startX = location.x + 2*SIZE/5;
	            startY = location.y + 7*SIZE/10;
	            width  = -10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            Runner.fatLine(page,spot,new Dimension(3,3));}
	            break;
	         case FAMISHED:
	            startX = location.x + 5*SIZE/16;   // Draw pupils.
	            startY = location.y + 4*SIZE/24;
	            width  = SIZE/7;
	            height = SIZE/7;
	            page.setColor(pupilColor);   
	            page.fillOval(startX, startY, width, height );
	            startX = location.x + 6*SIZE/16+SIZE/4;
	            page.fillOval(startX, startY, width, height );
	            
	            
	            if(hasOne){page.setColor(Runner.chopStickColor);
	            startX = location.x + 2*SIZE/5;
	            startY = location.y + 7*SIZE/10;
	            width  = -10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            Runner.fatLine(page,spot,new Dimension(3,3));}
	            break;
	         default:
	            System.out.println("Illegal philosopher status");
	            System.exit(0);
	      }
	   }


}
