/**
 * @class CS257 Lab 2
 * @author Saeed Alalwan
 * 
 */

public class Building extends Object{
	Classroom[] c;
	String bName=null;
	int index=0;

	public Building(int iNumClassrooms, String name) {
		// TODO Auto-generated constructor stub
		c=new Classroom[iNumClassrooms];
		bName=name;
		
	}

	public Classroom addClassroom(String label, int iWhiteboards, int iSeats) {
		Classroom c1= new Classroom(label, iWhiteboards, iSeats);
		if(index<c.length){
			return c[index++]=c1;
			
		}return null;
		
		
		
	}
	
	
	
	Classroom find(java.lang.String searchFor) {
		for(int i= 0;i<c.length;i++){
			if(c[i].getLabel()==searchFor){
				return c[i];
			}
		}
		return null;
	}
	
	String getLabel() {
		return this.bName;
	}
	
	int maximumCapacity() {
		int numClass=0;
		for(int i= 0;i<c.length;i++){
			if(c[i]!=null)
			numClass+=c[i].getSeats();
		}
		return numClass;
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Building b= new Building(1,"white Hall");
		b.addClassroom("wh100", 5, 29);
		b.addClassroom("wh101", 5, 30);
		//System.out.println(b.addClassroom("wh101", 5, 30));
		///System.out.println(b.c[0]);
		//System.out.println(b.c[1]);
		System.out.println(b.find("wh100"));
		System.out.println(b.getLabel());
		
		// TODO Auto-generated method stub

	}

}
