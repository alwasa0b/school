import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class philosopher implements Runnable{
	
	static final int SIZE = 45;
	static final int HUNGRY = 0;
	static final int FAMISHED = 1;
	static final int EAT = 2;
	static final int STARVE = 3;
	static final int THINK = 4;
	Color faceColor=Color.red;
	Color eyeColor=Color.black;
    Color noseColor=Color.gray;
    Color mouthColor=Color.black;
    Color pupilColor=Color.cyan;
    Point location;
    int status=THINK;
    volatile int numOfTries=1;
	public String getStatus() {
		String s = null;
		if(this.status==0) s= "HUNGRY";
		if(this.status==1) s= "FAMISHED";
		if(this.status==2) s= "EAT";
		if(this.status==3) s= "STARVE";
		if(this.status==4) s= "THINK";
		return s;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private String name;
	Thread t;
	volatile int sleep;
	main at;
	

    public philosopher(){
    	this.name=name;
    }
    
	@Override
	public void run() {
		
		while(true){
			
		
		try {
			//this.setSleep(at.sleep);
			//System.out.println("inside Status: "+getStatus()+" Thread: "+name+" #Tries "+this.numOfTries);
			Thread.sleep(this.getSleep());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		
		draw(at.getGraphics());
             
	
		}
		
	}
	synchronized void setSleep(int sleep){
		this.sleep=sleep;
	}
		
	synchronized int getSleep(){
		return this.sleep;
	}	
		
		
	


	public void start() {
		
	}
	
	synchronized void changeStatus(chopstick c,main m){
		
    	if((this.status==THINK)&&c.getAvailable()%2==0&&c.getAvailable()!=0&&numOfTries>0){
    		c.pick(2);    
    		this.status=EAT;
    		numOfTries=1;    		
    	}
    	
    	if((this.status==THINK)&&c.getAvailable()%3==0&&c.getAvailable()!=0&&numOfTries>0){
    		c.pick(2);    
    		this.status=EAT;
    		numOfTries=1;    		
    	}
    	
    	else if(this.status==THINK&&c.getAvailable()==-1&numOfTries>0){
    		c.pick(1); 
    		numOfTries-=1;
    		this.status=HUNGRY;
    			
    			//System.out.println("Number Sticks: "+c.getAvailable());
    	}
    	
    	else if(this.status==HUNGRY&&c.getAvailable()%2==0&&c.getAvailable()!=0&numOfTries>0){
    		c.pick(2); 
    		numOfTries=1;
    		this.status=EAT;
    			
    			//System.out.println("Number Sticks: "+c.getAvailable());
    	}
    	
    	
    	else if(this.status==EAT){
    		c.release();
    		this.status=THINK;
    	}
    	
   
    	else if(this.status==HUNGRY&&numOfTries>0){
    		numOfTries--;
    	}
    	
    	else if(this.status==HUNGRY&&numOfTries<=0){
    		this.status=FAMISHED;
    		System.out.println("bamm");
    	}
    
    	
    	else if(this.status==FAMISHED){
    		this.status=STARVE;
    	}
    	else if(this.status==STARVE){
    		this.status=STARVE;
    	}
    	else{
    		System.err.println("getStatus "+ getStatus()+" numOfTries "+numOfTries+" numSticks "+c.getAvailable());
    	}
   
    	System.out.println("inside Status: "+getStatus()+" Thread: "+name+" #Tries "+this.numOfTries);
    	
    }
    
	public philosopher(Point location,String name,main at) {
		// TODO Auto-generated constructor stub
		this.location=location;
		this.name=name;
		this.at=at;
	}

	/**
	 * @param args
	 */
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
	    	  
	            page.setColor(main.chopStickColor);
	            startX = location.x + 2*SIZE/5;
	            startY = location.y + 7*SIZE/10;
	            width  = -10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            main.fatLine(page,spot,new Dimension(3,3));
	            startX = location.x + 3*SIZE /5;
	            width  = 10;
	            height = 30;
	            spot   = new Rectangle(startX,startY,width,height);
	            main.fatLine(page,spot,new Dimension(3,3)); 
	         case THINK:
	        	
	            startX = location.x + SIZE/4;   // Draw pupils.
	            startY = location.y + SIZE/4;
	            width  = SIZE/10;
	            height = SIZE/10;
	        
	            page.setColor(pupilColor);   
	            page.fillOval(startX, startY, width, height );
	            startX = location.x + 2*SIZE/5+SIZE/4;
	            page.fillOval(startX, startY, width, height );
	           
	           
	      
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
	            break;
	         default:
	            System.out.println("Illegal philosopher status");
	            System.exit(0);
	      }
	   }




}
