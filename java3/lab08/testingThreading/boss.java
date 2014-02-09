package testingThreading;

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
	
	static printThread p1 = new printThread("saeed");
	printThread p2 = new printThread("bess");
	printThread p3 = new printThread("david");
	printThread p4 = new printThread("mike");
	
	Thread pt1 = new Thread(p1);{
		
		pt1.setPriority(pt1.MAX_PRIORITY);
		p1.setNum(20);
	
	
		
	}
	Thread pt2 = new Thread(p2);{
		pt2.setPriority(pt1.MIN_PRIORITY);
		p2.setNum(43);
	}
	Thread pt3 = new Thread(p3);{
		pt3.setPriority(pt1.MIN_PRIORITY);
		p3.setNum(19);
	}
	Thread pt4 = new Thread(p4);{
		pt4.setPriority(pt1.MAX_PRIORITY);
		p4.setNum(47);
	}
		
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boss b= new boss();
		b.pt1.start();
		b.pt2.start();
		b.pt3.start();
		b.pt4.start();
		
	}

}
