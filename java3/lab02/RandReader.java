import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @class CS258 Lab 2
 * @author Saeed Alalwan
 * 
 */

public class RandReader {
	RandomAccessFile in;
	int s;
	String temp;
	byte[] b= new byte[18];
	
	public RandReader(RandomAccessFile i){
		 long counter=128;
		try {
			counter =  (i.length());
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		 String s=null;
		 try {
			while(i.getFilePointer()<i.length())
			{
			   // reads characters encoded with modified UTF-8
			  
			try {
				//i.seek(counter--);
				s = i.readUTF();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  
			   // print
			   
			   if(!s.isEmpty()){
				   System.out.print(s);
			   }
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.EOFException {
		// TODO Auto-generated method stub
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile("test","r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			new RandReader(file);
		

	}

}
