import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @class CS258 Lab 2
 * @author Saeed Alalwan
 * 
 */

public class BinReader {
	FileInputStream in;
	public BinReader(FileInputStream in) {
		BufferedReader d = new BufferedReader(new InputStreamReader(in));
		try {
			String s;
			while((s=d.readLine())!=null){
				System.out.println(s);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
		/*BufferedReader d = null;
		try {
			
		 d = new BufferedReader(new InputStreamReader(in));
		}catch (java.lang.NullPointerException e) {
			
		}
		
		String s = null;
		
		boolean more= true;
		do {
			try {
				s=d.;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found");
			}catch (java.lang.NullPointerException e) {
				
			}
			if(s==null){
				more=false;
				break;
			}
			System.out.println(s);
		}while(more);
		
		
		
		*/
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream file = null;
		try {
			file = new FileInputStream("testing");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} catch (java.lang.NullPointerException e) {
			
		}
		new BinReader(file);
	}

}
