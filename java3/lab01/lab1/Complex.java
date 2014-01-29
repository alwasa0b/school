package lab1;
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
	
	{
	}
	public boolean isZero(){
		
		if(this.real==0.0||this.imaginary==0.0){
			return true;
		}else{
			return false;
		}
		
	}
	public String toString(){
		String op = "+";
		String real= String.valueOf(this.real);
		String imaginary= String.valueOf(this.imaginary);
		String i="i";
		if (this.real==0){
			op="";
			real="";
		}
		if (this.imaginary==0&&this.real!=0){
			op="";
			imaginary="";
			i="";
		}
		if (this.imaginary==0&&this.real==0){
			real="0.0";
			op="";
			imaginary="";
			i="";
		}
		if (this.imaginary<=0&& this.real<0){
			op="";
			imaginary=String.valueOf(this.imaginary);
			real=String.valueOf(this.real);
			i="";
			
		}
		
		
		return real+op+imaginary+i;
	}
	
	public Complex add(Complex c){
		return new Complex(real+c.real, imaginary+c.imaginary);
	}
	
	public Complex minus(Complex c){
		
		return new Complex(real-c.real, imaginary-c.imaginary);
	}
	
	public Complex product(Complex c){
		double rN=this.real;
		double iN= this.imaginary;
		double rD=c.real;
		double iD= c.imaginary;
		
		double pR=this.real*c.real;
		double pI=this.imaginary*c.imaginary;
		double r= pR-pI;
		
		double i1=rN*iD;
		double i2=rD*iN;
		double i = i1+i2;
		
		return new Complex(r, i);
	}
	
	public double con(double a){
		return a*-1;
	}
	public Complex div(Complex c){
		if (c.real == 0.0 || c.imaginary==0.0) {
			throw new java.lang.ArithmeticException("/ by zero");
			
			}
		else{
			
		double con=con(c.imaginary);
		
		
		Complex conj = new Complex(c.real,con);
		
		
		Complex curr=this.product(conj);
		
		Complex conj1= c.product(conj);
		
		
			
			
		 return new Complex(curr.real/conj1.real, curr.imaginary/conj1.real);
		}
		
		
		
		
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