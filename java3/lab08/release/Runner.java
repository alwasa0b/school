package release;



import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Runner extends Applet implements Runnable{
	private Random rnd;
	Philosopher p1,p2;
	Point [] pts = new Point[5];
	Philosopher[] p=new Philosopher[5];
	Thread t[]=new Thread[5];
	Chopsticks c[]=new Chopsticks[5];
	private Image im;
	public static final Color chopStickColor = Color.red;
	private Graphics doubleG;

	public Runner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	public void init()  {
		// TODO Auto-generated method stub
		setSize(600, 600);
		setBackground(Color.white);
		this.start();
		drawPoints(pts);
		t[0]= new Thread(this,"p0");{
			if(t[0]==null) t[0].start();
			p[0]=new Philosopher(pts[0]);
			c[0]=new Chopsticks(new Rectangle(pts[0].x-50,pts[0].y+50,50,50));
			System.out.println(t[0].getName());
		}
		
		t[1]= new Thread(this,"p1");{
			if(t[1]==null) t[1].start();
			p[1]=new Philosopher(pts[1]);
			c[1]=new Chopsticks(new Rectangle(pts[1].x,pts[1].y-50,-50,50));
			System.out.println(t[1].getName());
		}
		
		t[2]= new Thread(this);{
			if(t[2]==null) t[2].start();
			p[2]=new Philosopher(pts[2]);
			c[2]=new Chopsticks(new Rectangle(pts[2].x+100,pts[2].y-50,-100,-20));
		}
		
		t[3]= new Thread(this);{
			if(t[3]==null) t[3].start();
			p[3]=new Philosopher(pts[3]);
			c[3]=new Chopsticks(new Rectangle(pts[3].x+50,pts[3].y-50,50,50));
		}
		t[4]= new Thread(this);{
			if(t[4]==null) t[4].start();
			p[4]=new Philosopher(pts[4]);
			c[4]=new Chopsticks(new Rectangle(pts[4].x+50,pts[4].y+90,50,-80));
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
	
	
	
	public static void fatLine(Graphics page, Rectangle r, Dimension d){
		int[] x = {r.x, r.x+d.width, r.x+r.width+d.width, r.x+r.width}; 
	    int[] y = {r.y, r.y, r.y+r.height+d.width, r.y+r.height+d.width};
	    page.fillPolygon(x, y, 4);
	}

	@Override
	public void run() {
	
	
		// TODO Auto-generated method stub
	
	}
	public void clear(Graphics g){
		if(im==null){im=createImage(this.getSize().width,this.getSize().height);doubleG =im.getGraphics();}
		doubleG.setColor(getBackground());
		
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		doubleG.setColor(getForeground());
		paint(doubleG);
		g.drawImage(im,0,0,this);
	}
	
	
	@Override
	public void update(Graphics page){

		while(true){
		
			c[0].draw(page);
			
			p[0].draw(page);
			
		
			p[1].draw(page);
			
			
			p[2].draw(page);
			
		
			p[3].draw(page);	
			
			
			p[4].draw(page);
			clear(page);
			int phil = new Random().nextInt(5);
			
			try {
				
				if(phil==4){p[phil].changeStatus(c[3],c[4],phil);}
				else if(phil==0){p[phil].changeStatus(c[4],c[0],phil);}
				else{
					p[phil].changeStatus(c[phil-1],c[phil],phil);
				}
				
				Thread.sleep(new Random().nextInt(600));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public void start(){
	
	
	}
	
	public void  paint(Graphics page){
		
		c[0].draw(page);
		p[0].draw(page);
		c[1].draw(page);
		p[1].draw(page);
		c[2].draw(page);
		p[2].draw(page);
		c[3].draw(page);
		p[3].draw(page);
		c[4].draw(page);
		p[4].draw(page);
		repaint();
		
		
	}
	

}
