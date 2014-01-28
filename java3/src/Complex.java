import java.util.NoSuchElementException;

public class Complex{  

	private double real, imaginary;
	
	public Complex(){ 
		this.real=0;
		this.imaginary=0;

	}
	
	public Complex(double real, double imaginary){
		this.real=real;
		this.imaginary=imaginary;
	}
	
	public String toString(){
		return this.real+"+"+this.imaginary+"i";
	}
	
	public Complex add(Complex c){
		return new Complex(real+c.real, imaginary+c.imaginary);
	}
	
	public Complex minus(Complex c){
		
		return new Complex(real-c.real, imaginary-c.imaginary);
	}
	
	public Complex product(Complex c){
		return new Complex(real*c.real, imaginary*c.imaginary);
	}
	
	public Complex div(Complex c){
		return new Complex(real/c.real, imaginary/c.imaginary);
	}
	

	public static Complex parseComplex(String str) throws NumberFormatException, NoSuchElementException {
		Double i1;
		Double i2;
		String s;
		int op;
		op= str.indexOf('+');
		i1= (double)Double.valueOf(str.substring(0, op));
		s = str.substring(op+1, str.length()-1) ;
		i2 = (double)Double. parseDouble((s));
		return new Complex((double)i1,(double)i2);
	}
	
	{
		


	}
	

}