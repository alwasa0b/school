/**
 * @class CS257 Lab 2
 * @author Saeed Alalwan
 * 
 */

public class Classroom {
	
	int whiteboards=2;
	int seats;
	String lable;
	Classroom(String label, int iWhiteboards, int iSeats){
		this.lable=label;
		this.whiteboards=iWhiteboards;
		this.seats=iSeats;
	}
	public void setLabel(java.lang.String sLabel){
		lable=sLabel;
	}
	public String getLabel(){
		return lable;
	}
	
	int addSeats(int iSeatsToAdd){
		seats=iSeatsToAdd;
		return seats;
	}
	
	public int removeAllSeats(){
		seats=0;
		return seats;
	}
	public void setWhiteboards(int iWhiteboards){
		if(iWhiteboards>1){
			whiteboards = iWhiteboards;
		}
		else{
			whiteboards=0;
		}
		
	}
	public int getWhiteboards(){
		return whiteboards;
	}
	public int getSeats(){
		return seats;
	}

	public boolean bigEnoughFor(int iStudents) {
		if (seats>=iStudents){
			return true;
		}
		return false;
	}
	public int minimumErasersNeeded() {
		int erasersNeeded=0;
		for (int i=1; i<=whiteboards;){
			erasersNeeded=erasersNeeded+2;
			
			i++;
		}
		int temp=seats;
		while(temp%20!=0){
			temp=temp/20;
			erasersNeeded++;
			
			
		}
		return erasersNeeded;
	}
	
	public java.lang.String toString(){
		return getLabel()+" has "+getWhiteboards()+" whiteboards and "+getSeats()+" seats.";
	}
	
	public static void main(String[] args) {
		/*Classroom c= new Classroom();
		c.setLabel("CS206");
		c.addSeats(26);
		c.setWhiteboards(-5);
		System.out.println(c.bigEnoughFor(99));
		System.out.println(c.minimumErasersNeeded());
		System.out.println(c);*/
		
	}
	
	
}
