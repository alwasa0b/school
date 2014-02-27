package lab05;
import java.awt.*; 
import java.applet.*; 
import java.awt.event.*;
import java.util.Random;

/**
 * @class CS257 Lab 5
 * @author Saeed Alalwan
 * 
 */

public class Lab5 extends Applet implements MouseListener{
	private static final long serialVersionUID = -5868152824137083508L;



		Button okButton; 
		TextField nameField; 
		StringBuffer strBuffer ;
		String guess;
		Random r;
		int num; 
		// used to generate random color
		

		// flag to communicate data from a mouse event method and paint()
		
			   
		/**
		Sets up the basic applet environment.
		*/
		public void init()
		{
			// register the applet as both the listener and the client
			// who will be notified
			//this.addMouseListener(this);
			 okButton = new Button("Lucky!"); 
			 strBuffer= new StringBuffer();
			 r= new Random();
			 num = r.nextInt(100);
			 nameField = new TextField("Type Something",20); 
			 guess="Please pick a random number 1";
			 add(nameField);
			 add(okButton); 
			 okButton.addMouseListener(this);//addActionListener(this); 
			 
			
		}
		    
		/**
		Draws an oval of fixed size (consider using Random for the lab)
		at the location where the user clicks the mouse.
		*/
		public void paint (Graphics g)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0,0,getWidth(),getHeight());
			g.setColor(Color.BLUE);
			g.drawString(guess,10,100); 
					
		}
		void addItem(String word) {
	     
	        repaint();
	    }
		
		void getaNum(){
	
			try {
			if((Integer.parseInt(nameField.getText()))>num){
				guess="Try Lower";
			}
			else if((Integer.parseInt(nameField.getText()))<num){
				guess="Try Higher";
			}
			else{
				guess="Got Lucky!!"+" "+Integer.toString(num);
			}}
			
			catch (NumberFormatException e) {
				guess="Please pick a number 1-100";
			}
			
			repaint();
		}
		
		
		
		/**
		Sets a global variable to cause a new oval to be drawn on the screen
		and calls repaint();
		*/
		public void mousePressed(MouseEvent evt)
		{
			getaNum();
		}
		
		public void mouseReleased(MouseEvent evt) {}
		public void mouseClicked(MouseEvent evt) {
		
		}
		public void mouseEntered(MouseEvent evt) {}
		public void mouseExited(MouseEvent evt) {}

	
	}



