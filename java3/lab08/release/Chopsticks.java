package release;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Chopsticks {

	 int available = -1;
	
	 synchronized int getAvailable() {
		return available;
	}
	

	
	 synchronized void setAvailable(int available) {
		this.available = available;
	}
	
	
	private Rectangle location;
	public Chopsticks(Rectangle location) {
		// TODO Auto-generated constructor stub
		this.location=location;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void draw(Graphics page){
		if (available<0){
			page.setColor(Runner.chopStickColor);
	        Runner.fatLine(page, location, new Dimension(5,5));
	    }  
	}

}
