import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Random;

public class NewTree  extends Tree{
	protected final int    APPLET_WIDTH  = 320;
	protected final int    APPLET_HEIGHT = 320;
	protected final double STARTSIZE     = 110.0;
	protected final double STARTANGLE    = 180.0;
	protected final double CHANGEANGLE   =  30.0;
	protected final double FACTOR        =   2.0;
	protected final double MINSIZE       =  8.0;
	int count=0;
	int numberOfTrees=5;


	public NewTree(){
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	public void init(){
		   
		   setSize(APPLET_WIDTH, APPLET_HEIGHT);
		   setBackground(new Color(220,255,255));
		 
		   
	   }
	 public void paint(Graphics page){
		 int i=numberOfTrees;
		 
		 
			
		 page.setColor(Color.green);
		
		 page.fillRect(0, 250, APPLET_WIDTH, APPLET_HEIGHT);
		 drawCloud(page,0,0,1,5,1000);	
		
		 
		 while(i>0){
			 
			 drawTree(page, pickRandom(50,APPLET_WIDTH-50),  pickRandom(255,320), STARTSIZE, STARTANGLE); 
			
			 i--;
			 count=0;
			 }
		

	 }
	   public void drawTree( Graphics page, int x, int y, double size, double angle ){
		   Point endPoint = calculatePoint(pickRandom(x-5,x+5), pickRandom(y-5,y+5), pickRandom((int)size-10,(int)size+10), pickRandom((int)angle-1,(int)angle+1));
		   
		   if(count !=0)drawLeaf(page, endPoint.x, endPoint.y, 8,(int)(size/FACTOR), (int)(angle+CHANGEANGLE),3);
		   page.setColor(new Color(156, 93, 82));
		   page.drawLine(x, y, endPoint.x, endPoint.y);
		  
		   int xPoints[]={x,x+3,endPoint.x+3,endPoint.x};
		   
		   int yPoints[]={y,y,endPoint.y,endPoint.y};
		   
		  // int xlPoints[]={2,3,endPoint.x+2,endPoint.x};
		  // int ylPoints[]={2,3,endPoint.y+1,endPoint.y};
		   
		   drawBranch(page,xPoints,yPoints);
		   Random rnd= new Random();
		   
		   if (size > MINSIZE){
			   
			   drawTree(page, endPoint.x, endPoint.y, size/FACTOR, angle+CHANGEANGLE);
			   
			   //drawLeaf(page, xlPoints, ylPoints, 8,(int)(size/FACTOR), (int)(angle+CHANGEANGLE),1);
			   
			  
			   drawTree(page, endPoint.x, endPoint.y, size/FACTOR, angle-CHANGEANGLE);
			  // drawLeaf(page, endPoint.x, endPoint.y, 8,(int)(size/FACTOR), (int)(angle-CHANGEANGLE),3);
		
			   
		   }count++;
		   
	   }  
	   
	   
	   public void drawBranch(Graphics p,int []xPoints, int []yPoints){
		  p.fillPolygon(xPoints, yPoints, 4);
	   }
	   
	   
	   public void drawCloud(Graphics p, int x, int y, int w, int h, int order){
		   
		   //p.create(x, y, w, h);
		  
		   //
		   int red,grn,blue;
		   red= pickRandom(160,190);
		   grn= pickRandom(160,250);
		   blue= pickRandom(160,250);
		   w=pickRandom(1,15);
		   h=pickRandom(1,10);
		   p.setColor(new Color(red,grn,blue));
		   
		   //p.drawOval(x, y, w, h);
		   p.fillOval(x, y, w, h);
		   
		   
		   if(order==0) return;
		  
		   int newAngle=pickRandom(1,180);
		   
		   Point middle = calculatePoint(x+w/2, y+h/2, pickRandom(35,50), pickRandom((int)0,(int)180));
		   //double dis=middle.distance(pt);
		//   =middle.distance(pickRandom(1,50), pickRandom(1,50));
		   
		   
		  
		   drawCloud(p,middle.x,middle.y,5,5,order-1);
	   }
	   
	   
		public void drawLeaf(Graphics p,int xZero,int yZero,int h,int w,int angle,int order){
			//p.drawOval(xPoints, yPoints, w, h);
			
		//	p.fillPolygon(p.drawPolygon(xPoints, yPoints, 1));
			int [] x={xZero+1,xZero+5,xZero+4,xZero+9,xZero+7,xZero+8,xZero+5,xZero+5,xZero+3,xZero+4,xZero+2,xZero,xZero-2,xZero-4,xZero-3,xZero-5,xZero-8,xZero-7,xZero-7,xZero-4,xZero-5,xZero,xZero+2,xZero+2,xZero+1};
		    int [] y={yZero-3,yZero-4,yZero-3,yZero+1,yZero+2,yZero+5,yZero+4,yZero+5,yZero+4,yZero+9,yZero+7,yZero+10,yZero+7,yZero+8,yZero+3,yZero+6,yZero+4,yZero+5,yZero+2,yZero+1,yZero-3,yZero-7,yZero-6,yZero-3};
		    int red=34;
		    int grn=139;
		    int blue=34;
		    
		    //p.drawPolygon(x, y, 24);
		    
			p.fillPolygon(x, y, 24);
			
		    if (order==0) return;
		    
		    p.setColor(new Color(red+60,grn+10,blue+3));
		    drawLeaf(p, xZero, yZero, h/2,(int)w/2, (int)(angle),order-1);
		   
			
			//p.drawOval(xPoints, yPoints, w, h);
		}
	   
	 public int pickRandom(int min, int max){
		 Random rnd= new Random();
		 return min + (int)(rnd.nextFloat() * ((max - min) + 1));
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
