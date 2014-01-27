package lab05;


/**
 * @class berkeley cs61b Lab 5 Solution
 * @author Saeed Alalwan
 *
 */

public class x{
	String x ="";
	public x() {
		// TODO Auto-generated constructor stub
		this.x="X";
	}
	

	public class y extends x{
		
		
		
		public y(){
			super();
			x="Y";
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		x []xa= new x[1];
		y[] ya= new y[1];
		xa[0]=new x();
		ya[0]=(y) new x();
		System.out.println(xa[0].x);
		
		
	}

}
