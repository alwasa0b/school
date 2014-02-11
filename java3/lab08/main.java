import java.applet.*;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
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
	chopstick c[] = new chopstick[6];
	philosopher pp ,pp2;
	private Image i;
	public Graphics doubleG;
	Thread ppt,ppt2;
	int sleep;
	volatile static int numOfSticks=5;
	
	
	public main() {
	}
	   public static void fatLine(Graphics page, Rectangle r, Dimension d){
		   int[] x = {r.x, r.x+d.width, r.x+r.width+d.width, r.x+r.width}; 
	       int[] y = {r.y, r.y, r.y+r.height+d.width, r.y+r.height+d.width};
	       page.fillPolygon(x, y, 4);
	   }
	   
	public void init(){
		   setSize(APPLET_WIDTH, APPLET_HEIGHT);
		   setBackground(new Color(220,255,255));
		  
		   this.start();
		   paintObj(this.getGraphics());
		   //drawSticks(this.getGraphics(),c);
		
	}
	public void paintObj(Graphics page){
		drawPoints(pts);
		

		Random rnd = new Random();
		   p[0] = new philosopher(pts[0],"0",this);
		   p[1] = new philosopher(pts[1],"1",this);
		   p[2] = new philosopher(pts[2],"2",this);
		   p[3] = new philosopher(pts[3],"3",this);
		   p[4] = new philosopher(pts[4],"4",this);
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
	
	public void drawSticks(Graphics page, chopstick c[]){
		
		int x=0;int y=0;
		int a = getWidth()/4;
	    int b = getHeight()/4 ;
	    int m = Math.min(a, b);
	    int r = 5 * m / 5;
	    int r2 = Math.abs(m - r) / 2;
		for (int i = 0 ; i<=numOfSticks; i++){
			double t = 2 * Math.PI * i / 5;
	        x = (int) Math.round(a + r * Math.cos(t))+50;
	        y = (int) Math.round(b + r * Math.sin(t))+50;
	        c[i] = new chopstick(new Rectangle((x - r2),( y - r2),3,70));
	        c[i].draw(page);
		}
		
	}
	public void clear(Graphics g){
		if(i==null){i=createImage(this.getSize().width,this.getSize().height);doubleG =i.getGraphics();}
		doubleG.setColor(getBackground());
		
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(i,0,0,this);
	}
	
	public void paint(Graphics page){
		Rectangle location2 = new Rectangle(100,55,3,70);
		//page.drawOval(APPLET_WIDTH/2-110, APPLET_HEIGHT/2-110, 210, 210);
		
		
		//p[0].draw(this.getGraphics());
		//p[0].changeStatus();
		//
		
		
		
		Random rnd = new Random();
		
		while(true){	
			
			//System.out.println(c.getAvailable());
			p[4].setSleep(rnd.nextInt(1500));
			p[4].changeStatus(this);
			
			p[1].setSleep(rnd.nextInt(1500));
			p[1].changeStatus(this);
			p[2].setSleep(rnd.nextInt(1500));
			p[2].changeStatus(this);
			p[3].setSleep(rnd.nextInt(1500));
			p[3].changeStatus(this);
			p[0].setSleep(rnd.nextInt(1500));
			p[0].changeStatus(this) ;
			
			repaint();
			}
			
		
	

	
	}
	

	
	public void start(){
		
	}
	
	public void run(){
		
	    }
	     
	 
	
		
		


	
	
	public static void main(String[] args) {

	}

}
