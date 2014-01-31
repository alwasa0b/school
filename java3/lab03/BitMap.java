import java.io.Serializable;


public class BitMap implements Comparable, Serializable{
	
	public static final int  BITSIZE = 64;
	private long bitString;
	
	public BitMap() {
		// TODO Auto-generated constructor stub
		clearAll();
	}
	
	public  BitMap(String s) throws IndexOutOfBoundsException,ArithmeticException{
		for(int i=s.length()-1,c=0;i>=0;i--){
			
			if(s.charAt(i)=='f'||s.charAt(i)=='F'){
				
			}
			
			else if(s.charAt(i)=='t'||s.charAt(i)=='T'){
				setBit(i);
			}
			else if (s.length()>BITSIZE){
				throw new IndexOutOfBoundsException();
			}
			
			else {
				throw new ArithmeticException();
			}
			
/*			if(s.charAt(i)=='f'||s.charAt(i)=='F'){
				
			}
			
			else if(s.charAt(i)=='t'||s.charAt(i)=='T'){
				bitString^=(1<<c);
			}
			
			
			else if (s.length()>BITSIZE){
				throw new IndexOutOfBoundsException();
			}
			
			else {
				throw new ArithmeticException();
			}c++;*/
		}
	}
	
	public  BitMap(boolean[] bits) throws IndexOutOfBoundsException{
		
	}
	
	
	private long bitMask(int b){
		return ~bitString;
	}
	
	
    public void setBit(int b){
    	bitString |= (1 << b);
    }
    
    
    public  void clearBit(int b){
    	bitString &= ~(1 << b);
    }
    
    
    public boolean checkBit(int b){
    	return (bitString&(1 << b)) != 0;
    	
    }
    
    
    public int countTrue(){
		return 0;
    	
    }
    
    public void clearAll(){
    	bitString&=0;
    }
    
    
    public void setAll(){
    	for(int i=0,c=0;i<=BITSIZE;i++){
    		setBit(i);
    	
    	}clearBit(BITSIZE-1);
    }
 
    
    public  int compareTo(Object bm){
    	
		return 0;//For Comparable.
    	
    }
    
    
    public  boolean equals(BitMap bm){
		return this==bm;
    	
    }
    
    
    public  String  toString()  {
		return Long.toString(bitString);
    	
    }

}
