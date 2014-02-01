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
				setBit(c);
			}
			else if (s.length()>BITSIZE){
				throw new IndexOutOfBoundsException();
			}
			
			else {
				throw new ArithmeticException();
			}c++;
		}
	}
	
	public  BitMap(boolean[] bits) throws IndexOutOfBoundsException{
		for(int i=bits.length-1,c=0;i>=0;i--){
			
			if(bits[i]==false){
				
			}
			
			else if(bits[i]==true){
				setBit(c);
			}
			else if (bits.length>BITSIZE){
				throw new IndexOutOfBoundsException();
			}
			
			else {
				throw new ArithmeticException();
			}c++;
		}
			
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
    	int t=0;
    	int c=0;
    	for(long i=bitString ;i>0;){
    		if(checkBit(c)){
    			t++;
    		}
    		
    		c++;
    		i=i/2;
    	}
    	
    	
		return t;
    	
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
    	if(this.countTrue()>((BitMap)bm).countTrue()){
    		return 1;
    	}
    	else if(this.countTrue()<((BitMap)bm).countTrue()){
    		return -1;
    	}
    	else return 0;//For Comparable.
    	
    }
    
    
    public  String compare(Object bm){
    	if(this.countTrue()>((BitMap)bm).countTrue()){
    		return "c has more t's";
    		
    	}
    	else if(this.countTrue()<((BitMap)bm).countTrue()){
    		return "a has more t's";
    	}
    	else return "c and a are equal";//For Comparable.
    
    	
    }
    
    public  boolean equals(BitMap bm){
   
		return this.bitString==bm.bitString;
    	
    }
    
    
    public  String  toString()  {
    	
		return Long.toString(bitString);
    	
    }
    
    public static void main(String[] args){
    	boolean [] array = {true,true};
    	BitMap a = new BitMap("tt");
    	BitMap b = new BitMap(array);
    	BitMap c = new BitMap("ttt");
    	
    	System.out.println("a: "+a);
    	System.out.println("aTrues: "+a.countTrue());
    	System.out.println("b: "+b);
    	System.out.println("bTrues: "+b.countTrue());
    	System.out.println("a vs b: " +b.equals(a));
    	System.out.println("a vs b: " +b.compareTo(a));
    	System.out.println("a vs c: " + ((c.compareTo(a)>=1 &&c.compareTo(a)>0) ? "c has more t's" : ((c.compareTo(a)==0) ? "c and a are equal" : "a has more t's")));
    	
    	
    }

}
