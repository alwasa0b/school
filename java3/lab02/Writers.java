// This program writes different types of files.
//    Random, Binary, and Text.
// Created 3/29/2004 for the lab 2 cs258 project.
/**
 * @class CS258 Lab 2 Solution
 * @author Saeed Alalwan
 * 
 */
import java.io.*;
import java.security.*;

public class Writers{  
	private final static int RECORDSIZE = 128;
	private final static int NAME_SIZE  = 30;
	private final static String spaces  = "                              ";

	// Keyboard input stream.
	private final static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String args[]) {
		// File related variables variables.
		Writer out = null;
		String fileType = null, fileName = null;

		// Data variables.
		String  name;
		int     age, recordNumber = 0;
		double  salary;
		String  doMore;
		boolean quit, moreFiles;
		System.out.println("File writer program");
		do{
			try{
				do{
					System.out.print("Enter file type (text, binary, random): ");
					fileType = in.readLine().toLowerCase();
				}
				while ( !("text".startsWith(fileType) || "binary".startsWith(fileType) || "random".startsWith(fileType)));
				System.out.print("Enter the file name: ");
				fileName = in.readLine().toLowerCase();
				switch (fileType.charAt(0)){
				case 't':
					out = new Text(fileName);
					break;
				case 'b':
					out = new Binary(fileName);
					break;
				case 'r': 
					recordNumber = 0;
					out = new Random( fileName, RECORDSIZE);
					break;
				default:  
					throw new InvalidParameterException();
				}

				do{  
					System.out.print("Enter Name: ");
					name = in.readLine() + spaces;
					name = name.substring(0,NAME_SIZE);

					age  = getAge();
					salary = getSalary();
					out.write(name, age, salary, recordNumber);
					recordNumber++;

					System.out.println("\n Type 'quit' to exit: ");

					doMore = in.readLine().toLowerCase();
					quit = (doMore.length()>0 && "quit".startsWith(doMore));
				}  while (!quit);
			}
			catch (InvalidParameterException e){  
				System.out.println("Unknown case");
				System.exit(1);
			}
			catch (IOException e){  
				System.out.println("I/O Error");
			}
			catch (Exception e){  
				System.out.println("Illegal Entry");
			}
			finally { 
					try {
						out.close(); 
						} 
					catch(Exception e) {
						
					} 
				}
			System.out.println("Another file? (y/n) ");

			try{  
				doMore = in.readLine().toLowerCase();
				moreFiles = (doMore.length()>0 && "yes".startsWith(doMore));
			}
			catch (Exception e) {moreFiles = false;}
			}  while (moreFiles);
		System.out.println("File write complete; data is in "+fileName+"\n");
	}   // End void main()
	// Method to input an age.
	private static int getAge(){
		int age = -1;
		String inputString = null;
		do{
			try{
				System.out.print("Enter Age: ");
				inputString = in.readLine();
				age = Integer.parseInt(inputString);
				if (age<0 || age>100) throw new Exception();
				return age;
				}catch (Exception e) {
					System.out.println("Illegal age, try again");
					}
			}while (true);
		}
	// Method to input a salary.
	private static double getSalary(){
		double salary = -1;
		String inputString = null;
		do{
			try{
				System.out.print("Enter Salary: ");
				inputString = in.readLine();
				salary = Double.parseDouble(inputString);
				if (salary<0 || salary>1000000) throw new Exception();
				return salary;
				}
			catch (Exception e){
				System.out.println("Illegal salary, try again");
				}
			}while (true);
		}
	}
	abstract class Writer{
		
		

		public abstract void write(String name, int age, double salary, int record) throws IOException;
		
		public abstract void close();
		
		}
	
	
	
	
	//Random class
	class Random extends Writer{
		RandomAccessFile out;
		int recordSize;
		
		
		public Random(String fileName, int recordSize) throws FileNotFoundException{
			this.recordSize=recordSize;
			this.out = new RandomAccessFile(fileName,"rw");
			
		}
		
		
		public void write(String name, int age, double salary, int record)throws IOException{
			//set file size to record size
			
			
		
			//store record in a String s var
			
			String s= record+" "+name+age+" "+salary+"\n";
		
			System.out.println(this.recordSize);
			out.seek(this.recordSize);
			out.writeUTF(s);
			this.recordSize+=128;
			
		}		
		
		
		public void close(){
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	//Binary class
	class Binary extends Writer{
		DataOutputStream out = null;
		
		public Binary(String fileName) throws IOException{
			this.out= new DataOutputStream(new FileOutputStream(fileName));
		}
		
		
		public void write(String name, int age, double salary, int record) throws IOException{
			
			String s= record+" "+name+age+" "+salary+"\n";
			this.out.write(s.getBytes());
		}
		
		
		public void close(){
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	//Text class
	class Text extends Writer{  
		PrintWriter out = null;
		
		public Text(String fileName) throws IOException{
			this.out= new PrintWriter(new FileOutputStream(fileName));
		}
		
		
		public void write(String name, int age, double salary, int record) throws IOException{
			String s= record+" "+name+age+" "+salary;
			this.out.write(s);
		}
		
		
		public void close(){
			out.close();
		}
	}