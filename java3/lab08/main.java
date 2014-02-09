import java.applet.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class main extends Applet{

	private static final int APPLET_WIDTH = 400;
	private static final int APPLET_HEIGHT = 400;
	public static Color chopStickColor=Color.red;
	Point [] pts = new Point[5];
	Thread philTreah[]=new Thread[5];
	Thread thisApp;
	philosopher[] p=new philosopher[5];
	chopstick c;
	philosopher pp ,pp2;
	Thread ppt,ppt2;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public main() {
		
		
		
		
		
	
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @return 
	 */
	   public static void fatLine(Graphics page, Rectangle r, Dimension d)
	   { int[] x = {r.x, r.x+d.width, r.x+r.width+d.width, r.x+r.width}; 
	     int[] y = {r.y, r.y, r.y+r.height+d.width, r.y+r.height+d.width};
	     page.fillPolygon(x, y, 4);
	   }
	public void init(){
		   setSize(APPLET_WIDTH, APPLET_HEIGHT);
		   setBackground(new Color(220,255,255));
		  
		   this.start();
		   paintObj(this.getGraphics());
		   drawSticks(this.getGraphics(),c)	;
		  
	}
	public void paintObj(Graphics page){
		drawPoints(pts);
		Random rnd = new Random();
		   p[0] = new philosopher(pts[0],"p1",this);
		   p[1] = new philosopher(pts[1],"p2",this);
		   p[2] = new philosopher(pts[2],"p3",this);
		   p[3] = new philosopher(pts[3],"p4",this);
		   p[4] = new philosopher(pts[4],"p5",this);
		   philTreah[0]= new Thread(p[0]);{
			   philTreah[0].start();
			   
		   }
			philTreah[1]= new Thread(p[1]);{
				philTreah[1].start();
				
			}
			philTreah[2]= new Thread(p[2]);{
				philTreah[2].start();
				
			}
			philTreah[3]= new Thread(p[3]);{
				philTreah[3].start();
				
			}
			philTreah[4]= new Thread(p[4]);{
				philTreah[4].start();
			
			}
			
	}
	
	public void drawPoints(Point[] p){
		int x=0;int y=0;
		int a = getWidth() / 5;
	    int b = getHeight() / 2;
	    int m = Math.min(a, b);
	    int r = 5 * m / 5;
	    int r2 = Math.abs(m - r) / 2;
		for (int i = 0 ; i<=4; i++){
			double t = 2 * Math.PI * i / 5;
	        x = (int) Math.round(a + r * Math.cos(t));
	        y = (int) Math.round(b + r * Math.sin(t));
	        p[i]=(new Point((x - r2)+50,( y - r2)-20));
		}
		
	}
	
	/*public void drawPhilosopher(Graphics page, philosopher[] p){
		int x=0;int y=0;
		int a = getWidth() / 5;
	    int b = getHeight() / 2;
	    int m = Math.min(a, b);
	    int r = 5 * m / 5;
	    int r2 = Math.abs(m - r) / 2;
		for (int i = 0 ; i<=4; i++){
			double t = 2 * Math.PI * i / 5;
	        x = (int) Math.round(a + r * Math.cos(t));
	        y = (int) Math.round(b + r * Math.sin(t));
	     
	        p[i]=new philosopher(new Point((x - r2)+50,( y - r2)-20),("philosopher"+i));
	        philTreah[i] = new Thread(p[i]);
	        p[i].run();
	        p[i].draw(page);
	       
		}
		
	}*/
	
	public void drawSticks(Graphics page, chopstick c){
		
		int x=0;int y=0;
		int a = getWidth()/4;
	    int b = getHeight()/4 ;
	    int m = Math.min(a, b);
	    int r = 5 * m / 5;
	    int r2 = Math.abs(m - r) / 2;
		for (int i = 0 ; i>4; i++){
			double t = 2 * Math.PI * i / 5;
	        x = (int) Math.round(a + r * Math.cos(t));
	        y = (int) Math.round(b + r * Math.sin(t));
	        c = new chopstick(new Rectangle((x - r2),( y - r2),3,70));
	        c.draw(page);
		}
		
	}
	
	public void paint(Graphics page){
		//Rectangle location2 = new Rectangle(100,55,3,70);
		//page.drawOval(APPLET_WIDTH/2-110, APPLET_HEIGHT/2-110, 210, 210);
		
		//c[0]=new chopstick(location2);
		//p[0].draw(this.getGraphics());
		//p[0].changeStatus();
		//
	
		
		
		Random rnd = new Random();
		
		while(true){	
			p[0].setSleep(rnd.nextInt(5000));
			System.out.println(p[0].getSleep());
			p[1].setSleep(rnd.nextInt(5000));
			
			p[2].setSleep(rnd.nextInt(5000));
			p[3].setSleep(rnd.nextInt(5000));
			p[4].setSleep(rnd.nextInt(5000));
			
			repaint();
			
		}
	

	
	}
	
	public void update(){
	
		
		
	}
	
	public void start(){
	
	}
	
	public void run(){
		
	    }
	     
	 
	
		
		


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
