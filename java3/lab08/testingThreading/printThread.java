package testingThreading;

public class printThread implements Runnable{
	String name;
	Thread t;
	int num=0;
	int newPriority;
	public int getNewPriority() {
		return newPriority;
	}

	public void setNewPriority(int newPriority) {
		this.newPriority = newPriority;
	}
	int sleep=0;
	
	boss boss;
	
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
	
	public void setSleep(int sleep){
		this.sleep=sleep;
	}
	
	public int getSleep(){
		return this.sleep;
	}
	
	public void setNum(int n){
		this.num=n;
	}

	/**
	 * @param args
	 */
	public int fib(int n){
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
		
		try {
			   Thread.sleep(getSleep());
			 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		System.out.println(fib(num)+" "+this.name+" "+Thread.currentThread().getPriority());
		
		
	}

}
