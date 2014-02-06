import java.util.Scanner;
import java.util.StringTokenizer;

import javax.xml.stream.events.Characters;


public class Calculator {
	
	Stack<String> operand;
	Stack<String> operator;

	
	public Calculator(StringTokenizer st) throws StackException {
		// TODO Auto-generated constructor stub
		
		operand  = new Stack<String>();
		operator = new Stack<String>();
		
		while (st.hasMoreElements()) { //more tokens exist
			String nextToken = st.nextToken();
			switch(nextToken){ //switch nextToken			
			case "(": //if left paren

				operator.push("("); //push "("
				break;

			case ")": //if left paren

				while (operator.look()!="("){
					//System.out.println("opr "+operator.look());
					eval(operand.pop(),operand.pop(),operator.pop());
					//System.out.println("opr "+operator.look());
				}operator.pop();break;


			case "+": //if left
				if(!operator.isEmpty())
					while ((operator.look()=="+"||operator.look()=="*" || operator.look()=="*")){eval(operand.pop(),operand.pop(),operator.pop());}
				//System.out.println("+: "+nextToken);
				operator.push(nextToken);
				break;
			case "-": //if -
				if(!operator.isEmpty())
					while ((operator.look()=="+"||operator.look()=="*" || operator.look()=="*")){eval(operand.pop(),operand.pop(),operator.pop());}
				//System.out.println("-: "+nextToken);
				operator.push(nextToken);
				break;


			case "*": //if *
				if(!operator.isEmpty())
					while ((operator.look()=="*" || operator.look()=="*")){eval(operand.pop(),operand.pop(),operator.pop());}
				//System.out.println("*: "+nextToken);
				operator.push(nextToken);
				break;

			case "/": //if /
				if(!operator.isEmpty())
					while ((operator.look()=="/"|| operator.look()=="*")){eval(operand.pop(),operand.pop(),operator.pop());}
				//System.out.println("/: "+nextToken);
				operator.push(nextToken);
				break;

			default:
				//System.out.println("num: "+nextToken);
				operand.push(nextToken);
				break;
			}
		}
		while(!operator.isEmpty()){
			eval(operand.pop(),operand.pop(),operator.pop());
		}
		System.out.println(operand.look());
	}

	// TODO Auto-generated catch block
	public void eval(String s1, String s2, String operator) throws StackException{
		double result=0;
		/*		System.out.println(s1);
		System.out.println(s2);
		System.out.println(operator);*/
		switch(operator){
		case "+":
			result=Double.valueOf(s1)+Double.valueOf(s2);
			break;
		case "*":
			result=Double.valueOf(s2)*Double.valueOf(s1);
			break;
		case "/":
			result=Double.valueOf(s2)/Double.valueOf(s1);
			break;
		case "-":
			result=Double.valueOf(s1)-Double.valueOf(s2);
			break;
		}
		operand.push(String.valueOf(result));


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a arithmetic expressions: ");
		Scanner s = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(s.next(),"+-/*()",true);
		try {
			new Calculator(st);
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
