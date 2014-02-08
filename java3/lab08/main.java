import java.applet.*;
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
	chopstick [] c=new chopstick[5];
	
	
	
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
		   
			
			
		  
	}
	public void paintObj(Graphics page){
		drawPoints(pts);
		   p[0] = new philosopher(pts[0],"p1");
		   p[1] = new philosopher(pts[1],"p2");
		   p[2] = new philosopher(pts[2],"p3");
		   p[3] = new philosopher(pts[3],"p4");
		   p[4] = new philosopher(pts[4],"p5");
		   philTreah[0]= new Thread(p[0]);{
		         philTreah[0].start();
		         p[0].draw(page);
			}
			
			philTreah[1]= new Thread(p[1]);{
		         philTreah[1].start();
		         p[1].draw(page);
			}
			
			philTreah[2]= new Thread(p[2]);{
		         philTreah[2].start();
		         p[2].draw(page);
			}
			
			philTreah[3]= new Thread(p[3]);{
		         philTreah[3].start();
		         p[3].draw(page);
		         
			}
			
			philTreah[4]= new Thread(p[4]);{
			
		         philTreah[4].start();
		         p[4].draw(page);
			
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
	
	public void drawPhilosopher(Graphics page, philosopher[] p){
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
		
	}
	
	public void drawSticks(Graphics page, chopstick[] c){
		int x=0;int y=0;
		int a = getWidth()/4;
	    int b = getHeight()/4 ;
	    int m = Math.min(a, b);
	    int r = 5 * m / 5;
	    int r2 = Math.abs(m - r) / 2;
		for (int i = 0 ; i<=3; i++){
			double t = 2 * Math.PI * i / 5;
	        x = (int) Math.round(a + r * Math.cos(t));
	        y = (int) Math.round(b + r * Math.sin(t));
	        c[i]=new chopstick(new Rectangle((x - r2),( y - r2),3,70));
	        c[i].draw(page);
		}
		
	}
	
	public void paint(Graphics page){
		//Rectangle location2 = new Rectangle(100,55,3,70);
		//page.drawOval(APPLET_WIDTH/2-110, APPLET_HEIGHT/2-110, 210, 210);
		
		//c[0]=new chopstick(location2);
		//p[0].draw(this.getGraphics());
		//p[0].changeStatus();
		//
		
		paintObj(page);
		
		while(true){
			paintObj(page);
			update(page);
		}
	

	
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void start(){
		
	
			
		
	
		
		
		
	
		
		
	}
	public void run(){
	    }
	     
	 
	
		
		


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		

	}

}
