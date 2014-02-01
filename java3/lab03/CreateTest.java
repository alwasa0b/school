

/**
 * @class CS258 Lab 2
 * @author Saeed Alalwan
 * 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class CreateTest {
	static BufferedReader in;
	int  bit;
	static Scanner sc ;
	public CreateTest(String filename) {
		// TODO Auto-generated constructor stub
		
		try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    public static String getChar()
	   {  String bit;
	      System.out.print("Enter bit number: ");
	      bit = readChars(0,BitMap.BITSIZE-1);
	      return bit;
	   }  // End getBit().
    
    
    public static String readChars(int min, int max) 
    {  
       String answers="";
       String  answer = "";
       boolean ok = false;

       while (!ok)
       {  ok = true;
          try 
          {  answer = in.readLine();
          	
              answers +=answer; 
              if (answer!="f" || answer!="t"||answer!="F" || answer!="T") ok = false;
          } 
          catch (Exception exception) {ok = false;}
          if (!ok) 
          {  System.out.print("Illegal input, enter (t) or (T) or (f) or (F) " 
                                + min + " and " + max + ": ");
       }  }
       return answers;
    }  // End readInt().
    
    
    
    public static void qustions(int i){
    	switch(i){
    	case 0:
    		System.out.println("Are you a programmer?");
    		break;
    	case 1:
    		System.out.println("Are you a smart?");
    		break;
    	case 2:
    		System.out.println("Do you know Java?");
    		break;
    	case 3:
    		System.out.println("Do you like Java?");
    		break;
    	}
		
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="";
		String ans="";
		BitMap a,b;
		String option=null;
		CreateTest ct=new CreateTest("boolean");
		try {
			s+=ct.in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		a= new BitMap(s);
		int i=0;
		while (i<4){
			qustions(i++);
			sc = new Scanner(System.in);
			ans+=sc.nextLine();	
			
		}
		b= new BitMap(ans);
		System.out.println(a.compare(b));
		
		
		
		

	}

}
