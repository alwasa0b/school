package testingThreading;

import java.util.Random;

public class boss{
	

/*	Thread pt1 = new Thread( new printThread("saeed"));{
		this.pt1.setPriority(6);
		pt1.start();
		
	}
	
	Thread pt2 =  new Thread(new printThread("bess!"));{
		this.pt2.setPriority(10);
		pt2.start();
	}
	Thread pt3 = new Thread(new printThread("slow"));{
		this.pt3.setPriority(4);
		pt3.run();
	}
	
	
	Thread pt4 = new Thread(new printThread("norm"));{
		pt4.setPriority(5);
		pt4.run();
	}
	*/
	
	printThread p1 = new printThread("saeed");
	printThread p2 = new printThread("bess");
	printThread p3 = new printThread("david");
	printThread p4 = new printThread("mike");
	
	
	
	
	
	Random rnd = new Random(900);
	Thread pt1 = new Thread(p1);{
		pt1.setPriority(pt1.MAX_PRIORITY);
		p1.setNum(15);
		pt1.start();
	}
	Thread pt2 = new Thread(p2);{
		pt2.setPriority(pt1.MIN_PRIORITY);
		p2.setNum(40);
		pt2.start();
	}
	Thread pt3 = new Thread(p3);{
		pt3.setPriority(pt1.MIN_PRIORITY);
		p3.setNum(50);
		pt3.start();	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new boss();
	}

}
