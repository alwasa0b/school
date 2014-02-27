package lab03;

import java.util.Scanner;
/**
 * @class CS257 Lab 3
 * @author Saeed Alalwan
 * 
 */
public class Lab3 {
	String aLong="";
	String sLong="";
	Scanner s;

	void printCardinals() {
		while(true){	
			System.out.print("Please Choose: \n(1) To enter a number\n(2) To exit ");
			int n= s.nextInt();
			if (n==2){
				return;
			}
			if(n==1){
			System.out.print("Please enter a number: ");
			String temp= s.next();
			
			
			System.out.println("You entered "+intToString (temp,temp.length()));}
			System.out.println("press any key to continue....");
			try{System.in.read();}  
			catch(Exception e){}  
			
		}
	}

	public String intToString(String c, int length){
		int i=0;
		String s ="";
		while(i<length){
			if(i>0){
				s+="-";
			}
			switch (c.charAt(i)) {
			case '0': s += "zero";
			break;
			case '1': s += "one";
			break;
			case '2':  s += "two";
			break;
			case '3':  s += "three";
			break;
			case '4':  s += "four";
			break;
			case '5':  s += "five";
			break;
			case '6':  s += "six";
			break;
			case '7':  s += "seven";
			break;
			case '8':  s += "eight";
			break;
			case '9':  s += "nine";
			break;
			default: s = "Invalid month";
			break;
			}i++;

		}
		return s;

	}


	Lab3(){
		

		s = new Scanner(System.in);
		while(true){
			System.out.println("please Choose a program: \n(1) Print the Cardinals\n(2) Calculate product and sum\n(3) To exit ");
			int temp =s.nextInt();
			
			if(temp==3){
				thankYou();
				return;				
			}

			if(temp==1){
				printCardinals();
				
			}


			if(temp==2){
				sumOrProd();
			}

			else{
				continue;
			}

		}

	}

	public void thankYou(){
		System.out.println("Thanks for playing!! \nGoodbye!!");
	}



	void sumOrProd() {
		int howFar;
		int sOrP;
		double p=0.0;
		
		while(true){
			System.out.println("Please Choose: \n(1) for sum  \n(2) for product\n(3) to exit");
			sOrP = s.nextInt();
			
			if(sOrP==3){
				return;
			}
			
		
			
			System.out.println("Please Choose a number between 1 and 30");
			howFar = s.nextInt();
			
			if(howFar>30 || howFar < 0){
				System.out.println("Please Choose a number between 1 and 30");
				howFar = s.nextInt();
			}
			
			
			int i=1;
			
			
			if(sOrP==1){
				p=0.0;
				
				while(i<=howFar){
					p=p+(i);
					i++;			
				}
				
							
			}

			if(sOrP==2){
				p=1.0;
				
				while(i<=howFar){
					p=p*(i);
					i++;			
				}
				
			

			}System.out.println("Total is "+p);
		}


	}
	
	public static void main(String[] args) {
		new Lab3();


	}
}
