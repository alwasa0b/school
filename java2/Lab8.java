

import java.util.Random;
/**
 * @class CS257 Lab 5
 * @author Saeed Alalwan
 * 
 */

public class Lab8 extends Lab4{
	
	long getUnits(Worker b){
		return b.getUnitsWorked();
	}
	public class sort extends mergSort<Worker>{
		public sort(){
		
		}

		@Override
		String leftList(Worker l) {
			// TODO Auto-generated method stub
			return l.getName();
		}

		@Override
		String rightList(Worker r) {
			// TODO Auto-generated method stub
			return r.getName();
		}
/*
		@Override
		long leftList(Worker l) {
			// TODO Auto-generated method stub
			return l.getUnitsWorked();
		}

		@Override
		long rightList(Worker r) {
			// TODO Auto-generated method stub
			return r.getUnitsWorked();
		}*/


		
	}
	
	public Lab8() {

		
		
	}
	
	static Worker[] insertionSort(Worker[] A) {
	      // Sort the array A into increasing order.
	      
	   int itemsSorted; // Number of items that have been sorted so far.
	 
	   for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
	         // Assume that items A[0], A[1], ... A[itemsSorted-1] 
	         // have already been sorted.  Insert A[itemsSorted]
	         // into the sorted part of the list.
	         
	      Worker temp = A[itemsSorted];  // The item to be inserted.
	      int loc = itemsSorted - 1;  // Start at end of list.
	      
	      while (loc >= 0 && A[loc].getUnitsWorked() > temp.getUnitsWorked()) {
	         A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
	         loc = loc - 1;       // Go on to next location.
	      }
	      
	      A[loc + 1] = temp; // Put temp in last vacated space.
	   }
	   return A;
	}
	
	
	/**
	 * @param args
	 */
	public Worker[] sortByUnitsWorked(Worker[] wa){
		return  new sort().merge_sort(wa);
	}
	
	public Worker[] sortByName(Worker[] wa){
		return new sort().merge_sort(wa);
	}
	public Worker binarySearch(Worker[] wa, String target){
		
		int mid=wa.length/2;
		int min=0;
		int max=wa.length;
		while(max>=min){
			if(wa[mid].getName().compareTo(target)==0){
				System.out.println(mid);
				System.out.println(wa[mid]);
				return wa[mid];
				
			}
			else if( wa[mid].getName().compareTo(target)<0){
				//System.out.println(min);
				min= mid+1;
				mid=(max+min)/2;
			
				
			}
			else if( wa[mid].getName().compareTo(target)>0){
				
				max=mid-1;
				mid=(max+min)/2;
			
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Lab8 l =new Lab8();
		
		int sizeOfArray=100000;
		Worker[] wl = new Worker[sizeOfArray];;
	

		
		for (int i=0;i<wl.length;i++){
			
			wl[i]= l.new Worker(Integer.toString(new Random().nextInt(503)));
			
			wl[i].work(new Random().nextInt(100)+1);
		}
		
		

	
		Worker [] wa=l.sortByUnitsWorked(wl);
		
		
		l.binarySearch(wa,"80");
	}

}
