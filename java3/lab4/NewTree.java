import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class NewTree  extends Tree{
	protected final int    APPLET_WIDTH  = 320;
	protected final int    APPLET_HEIGHT = 320;
	protected final double STARTSIZE     = 110.0;
	protected final double STARTANGLE    = 180.0;
	protected final double CHANGEANGLE   =  30.0;
	protected final double FACTOR        =   2.0;
	protected final double MINSIZE       =  10.0;


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
		 int i=5;
		 		 
		 page.setColor(Color.green);
		 
		 page.fillRect(0, 250, APPLET_WIDTH, APPLET_HEIGHT);
		 
		
		 
		 while(i>0){
			 drawTree(page, pickRandom(50,APPLET_WIDTH-50),  pickRandom(251,320), STARTSIZE, STARTANGLE); 
			 i--;
			 }
		

	 }
	   public void drawTree( Graphics page, int x, int y, double size, double angle ){
		   Point endPoint = calculatePoint(pickRandom(x-5,x+5), pickRandom(y-5,y+5), pickRandom((int)size-10,(int)size+10), pickRandom((int)angle-1,(int)angle+1));
		   page.setColor(new Color(156, 93, 82));
		   page.drawLine(x, y, endPoint.x, endPoint.y);
		 
		   Random rnd= new Random();
		   if (size > MINSIZE){
			   
			   drawTree(page, endPoint.x, endPoint.y, size/FACTOR, angle+CHANGEANGLE);
			   drawTree(page, endPoint.x, endPoint.y, size/FACTOR, angle-CHANGEANGLE);
			   
		   }
		   
	   }  
	 public int pickRandom(int min, int max){
		 Random rnd= new Random();
		 return min + (int)(rnd.nextFloat() * ((max - min) + 1));
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
