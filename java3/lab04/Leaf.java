import java.awt.Graphics;


public class Leaf extends NewTree{

	public Leaf() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public void drawLeaf(Graphics p,int xPoints[],int yPoints[],int h,int w,int angle,int order){
		//p.drawOval(xPoints, yPoints, w, h);
		
	//	p.fillPolygon(p.drawPolygon(xPoints, yPoints, 1));
		
		p.fillPolygon(xPoints, yPoints, 1);
		//p.drawOval(xPoints, yPoints, w, h);
	}
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Leaf();

	}

}
