/**
 * @class CS257 Lab 1
 * @author Saeed Alalwan
 * 
 */

public class Lab1 {
	public double getDistance(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
	}
	public void stringManip(String inString){
		int length=inString.length();
		char c=42;
		System.out.println(inString);
		System.out.println(length);
		System.out.println("First character ="+" "+inString.charAt(0)+","+" Last character ="+" "+inString.charAt(length-1));
	
		System.out.println("'"+inString.replace(inString.charAt(0), c)+"'");
		
	}
	public void growATree(String a, String b, int i) {
		Tree t1= new Tree(a);
		Tree t2= new Tree(b);
		t1.grow(i);
		t2.grow(i);
		if(t1.getHeight()>t2.getHeight()){
			System.out.println("The tree " + t1.getName()+ " is alive at age: "+t1.getAge()+ ", height: "+t1.getHeight());
		}
		else if(t1.getHeight()<t2.getHeight()){
			System.out.println("The tree " + t2.getName()+ " is alive at age "+t2.getAge()+ ", height: "+t2.getHeight());
		}
		else{
			System.out.println("The tree " + t1.getName()+ " is alive at age "+t1.getAge()+ ", height: "+t1.getHeight());
			System.out.println("The tree " + t2.getName()+ " is alive at age "+t1.getAge()+ ", height: "+t2.getHeight());
		}
	}
	public static void main(String[] args) {
		 new Lab1().stringManip("what, where, why, and when");
		 new Lab1().growATree("pine", "spruce", 0);
		 new Lab1().growATree("bob", "mary", 89);
		
	}
	
}
