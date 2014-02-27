package lab08;

import java.util.Arrays;

/**
 * @class CS257 Lab 8
 * @author Saeed Alalwan
 * 
 */



public abstract class mergSort<T> {
	
	/**
	 * @param args
	 */
	
	
    T[] m;
    @SuppressWarnings("unchecked")
    
	T[] merge_sort(T[] m){
		if(m.length<=1){
			
			return m;
		}
	
		
		int middle= m.length/2;
		int rest= m.length-middle;
		T [] left=(T[])new Object[middle];
		T [] right=(T[])new Object[rest];
	
		
		for(int x=0;x<middle;x++){
			left[x]=m[x];
			
		}
		
		for(int x=middle;x<rest+middle;x++){
			right[x-middle]=m[x];
		;
		}
	
		left=merge_sort(left);
		right=merge_sort(right);
		merge(left,right,m);
		return m;
	}
	
	private void merge(T[] left, T[] right, T[] m) {
		
		int count=0;
		
		while(left.length>0||right.length>0){
			
			
			
			if(left.length>0&&right.length>0){
				
				//if((long)leftList(left[0])<=(long)rightList(right[0])){ for unit worked
				if(leftList(left[0]).compareTo(rightList(right[0]))<0){ // for name
					m[count++]=left[0];
					
					left=Arrays.copyOfRange(left, 1, left.length);
				}
				else{
					
					m[count++]=right[0];
					right=Arrays.copyOfRange(right, 1, right.length);
				}
			}
			else if(left.length>0){
		
			
				m[count++]=left[0];
				left=Arrays.copyOfRange(left, 1, left.length);
			}
			else{
			
				
				m[count++]=right[0];
				right=Arrays.copyOfRange(right, 1, right.length);
			}
		}
		// TODO Auto-generated method stub
		
	}

	abstract String leftList(T l);

	abstract String rightList(T r);
	
}
