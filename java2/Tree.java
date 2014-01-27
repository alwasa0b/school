/**
 * @class CS257 Lab 1
 * @author Saeed Alalwan
 * 
 */

import java.util.Random;
public class Tree
{
	// Random number generator for the all objects in the class
	private static Random rg = new Random(0);
	
	// characteristics for this tree
	private int age;
	private int height;
	private boolean isAlive;
	private String name;

	// Constructor for a tree with name nameIn.  Initial age of the new tree is 0 and height is 0.
	public Tree (String nameIn)
	{
		age = 0;
		height = 0;
		isAlive = true;
		name = nameIn;
	}

	/***************************** 
		Methods to return attributes of this tree 
	*****************************/
	// return the age of this tree
	public int getAge() { return age; }
	// return true if this tree is alive, false if it is dead
	public boolean getIsAlive() { return isAlive; }
	// return the height of this tree
	public int getHeight() { return height; }
	// return the name of this tree
	public String getName() { return name; }

	// Simulates this tree growing for numYears years beyond its current age.
	// If the tree dies before the years are completed,
	//		 it will stop growing and its age will reflect when it died.
	public void grow (int numYears)
	{
		int i = 0;
		while (isAlive && i < numYears)
		{
			growOneYear();
			i++;
		}
	}
	
	// support method for the grow method above
	private void growOneYear()
	{
		age++;
		height += rg.nextInt(5);
	
		int diceRoll = rg.nextInt(100);
		if (diceRoll == 0) isAlive = false;
	}
	
	// return a String that summarizes the characteristics of this tree
	public String toString()
	{
		String aliveStr = (isAlive) ? " is alive " : " is dead ";
		String s = new String("The tree " + getName() + aliveStr + "at age: " + getAge()
		                          + " years, height: " + getHeight() + " feet.");
		
		return s;
	}	
}
