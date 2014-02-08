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
	
	
		
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boss b= new boss();
	    p1.fib(500);
		
	}

}
