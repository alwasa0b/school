import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


public class chopstick {
	Rectangle location;
	int available=-4;
	public chopstick(Rectangle location2) {
		// TODO Auto-generated constructor stub
		this.location=location2;
	}

	public void pick(){
		available+=1;
	}
	public void release(){
		available-=1;
	}
	/**
	 * @param args
	 */
	public void draw(Graphics page) {  
		if (available<0){
			page.setColor(main.chopStickColor);
	        main.fatLine(page, location, new Dimension(5,5));
	    }  
	}

}
