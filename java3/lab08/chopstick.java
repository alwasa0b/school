import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;


class chopstick {
	Rectangle location;
	int available=-4;
	
	synchronized int getAvailable() {
		return available;
	}

	synchronized void setAvailable(int available) {
		this.available = available;
	}

	public chopstick(Rectangle location2) {
		// TODO Auto-generated constructor stub
		this.location=location2;
	}

	synchronized public void pick(int i){
		available=available+i;
	}
	synchronized public void release(){
		available=available-2;
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
