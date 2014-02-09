package testingThreading;

public class printThread implements Runnable{
	String name;
	Thread t;
	int num=0;
	int newPriority;
	public printThread(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	
		

	}

	public printThread(String name, Thread t) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.t=t;
		t.setName(name);
		

	}
	public synchronized void setNum(int n){
		this.num=n;
	}

	/**
	 * @param args
	 */
	public synchronized int fib(int n){
		 if (n < 2) {
             return n;
          }
          else {
	   return fib(n-1)+fib(n-2);
          }
	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		t=new Thread(this,name);
	
		System.out.println(fib(num)+" "+t.getName()+" "+t.getPriority());
	}

}
