/**
 * @class CS257 Lab 4
 * @author Saeed Alalwan
 * 
 */

public class Lab4 extends Object{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*	Lab4 l= new Lab4();
		Worker w = l.new Worker("Saee");
		Worker p = l.new Producer("Fred", 50);
		Worker m = l.new Manager("Pete",10,false);
		w.work(40);
		p.work(40);
		m.work(40);
		System.out.println(w+" paid "+w.pay(20));
		System.out.println(p+" paid "+p.pay(20));
		System.out.println(m+" paid "+m.pay(20));*/
		
	}

	public class Worker{
		String name;
		long unitsWorked;

		public Worker(String name) {
			this.name=name;
			this.unitsWorked=0;
			// TODO Auto-generated constructor stub
		}
		public long getUnitsWorked() {
			return this.unitsWorked;
		}
		public String getName() {
			return this.name;
		}
	
		
		public long work(long units){
			if(units<0){this.unitsWorked=0;}
			else{
				this.unitsWorked=units;
			}
			return this.getUnitsWorked();
		}
		public double pay(double multiplier) {
			long units=this.getUnitsWorked();
			unitsWorked=0;
			return units*multiplier;
		}
		public String toString(){
			return "name: "+ this.name+" unitsWorked: "+ this.unitsWorked;

		}
		
	}
	public class Producer extends Worker{
		int productionTarget=1;
		public Producer(String name,int productionTarget) {
			super(name);
			this.productionTarget=productionTarget;
			// TODO Auto-generated constructor stub
		}
		public int getProductionTarget(){
			return productionTarget;
		}
		public long work(long units){
			if(units<0){this.unitsWorked=0;}
			else{
				this.unitsWorked=this.getProductionTarget() * units * 1/2;
			}
			return this.getUnitsWorked();
			
		}
		public String toString(){
			return "name: "+ this.name+" unitsWorked: "+ this.unitsWorked+ //
					" productionTarget: "+this.productionTarget;

		}

	}
	public class Manager extends Worker{
		boolean wellLiked;
		int numberSubordinates=1;
		public Manager(String name,int numberSubordinates, boolean wellLiked) {
			super(name);
			this.wellLiked=wellLiked;
			this.numberSubordinates=numberSubordinates;
			// TODO Auto-generated constructor stub
		}
		
		public long work(long units){
			if(units<0){this.unitsWorked=0;}
			else{
				this.unitsWorked=this.numberSubordinates * units * 3/4;
			}
			return this.getUnitsWorked();
		}
		public String toString(){
			return "name: "+ this.name+" unitsWorked: "+ this.unitsWorked+ //
					" numberSubordinates: " + this.numberSubordinates+" wellLiked: "+this.wellLiked;

		}
	}


}
