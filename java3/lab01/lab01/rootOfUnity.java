package lab01;



public class rootOfUnity {

	public rootOfUnity(int n) {
		// TODO Auto-generated constructor stub
		double f;
		for(int i =0;i<n;i++){
			double x = Math.cos(2.0 * Math.PI * i / n);
			double y = Math.sin(2.0 * Math.PI * i / n);
			
			System.out.println(new Complex(x,y));
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new rootOfUnity(4);
	}

}
