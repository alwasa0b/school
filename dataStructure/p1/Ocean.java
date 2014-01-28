

import java.lang.reflect.Array;
import java.util.ArrayList;

/* Ocean.java */

/**
 *  The Ocean class defines an object that models an ocean full of sharks and
 *  fish.  Descriptions of the methods you must implement appear below.  They
 *  include a constructor of the form
 *
 *      public Ocean(int i, int j, int starveTime);
 *
 *  that creates an empty ocean having width i and height j, in which sharks
 *  starve after starveTime timesteps.
 *
 *  See the README file accompanying this project for additional details.
 */

public class Ocean {

  /**
   *  Do not rename these constants.  WARNING:  if you change the numbers, you
   *  will need to recompile Test4.java.  Failure to do so will give you a very
   *  hard-to-find bug.
   */

  public final static int EMPTY = 0;
  public final static int SHARK = 1;
  public final static int FISH = 2;
  

  /**
   *  Define any variables associated with an Ocean object here.  These
   *  variables MUST be private.
   */

  private int width;
  private int height;
  private int starveTime;
  private int[][] ocean;
  private int[] fed;
  private static int oceans=0;
 
  /**
   *  The following methods are required for Part I.
   */

  /**
   *  Ocean() is a constructor that creates an empty ocean having width i and
   *  height j, in which sharks starve after starveTime timesteps.
   *  @param i is the width of the ocean.
   *  @param j is the height of the ocean.
   *  @param starveTime is the number of timesteps sharks survive without food.
   */

  public Ocean(int i, int j, int starveTime) {
    // Your solution here.
	  this.width=i;
	  this.height=j;
	  this.starveTime=starveTime;
	  ocean = new int[width][height];
	  
	  fed = new int[width*height];
	  if(oceans==0){
		  for(int x = 0; x<fed.length;x++){
			  fed[x]=this.starveTime;
		  }
	  }
	  oceans++;
  }

  /**
   *  width() returns the width of an Ocean object.
   *  @return the width of the ocean.
   */

  public int width() {
    // Replace the following line with your solution.
    return this.width;
  }

  /**
   *  height() returns the height of an Ocean object.
   *  @return the height of the ocean.
   */

  public int height() {
    // Replace the following line with your solution.
    return this.height;
  }

  /**
   *  starveTime() returns the number of timesteps sharks survive without food.
   *  @return the number of timesteps sharks survive without food.
   */

  public int starveTime() {
    // Replace the following line with your solution.
    return this.starveTime;
  }

  /**
   *  addFish() places a fish in cell (x, y) if the cell is empty.  If the
   *  cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a fish in.
   *  @param y is the y-coordinate of the cell to place a fish in.
   */

  public void addFish(int x, int y) {
    // Your solution here.
	  if(ocean[x][y]==EMPTY){
		  ocean[x][y]=FISH;
	  }
  }

  /**
   *  addShark() (with two parameters) places a newborn shark in cell (x, y) if
   *  the cell is empty.  A "newborn" shark is equivalent to a shark that has
   *  just eaten.  If the cell is already occupied, leave the cell as it is.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   */

  public void addShark(int x, int y) {
    // Your solution here.
	  if(ocean[x][y]==EMPTY){
		  ocean[x][y]=SHARK;
	  }
  }

  /**
   *  cellContents() returns EMPTY if cell (x, y) is empty, FISH if it contains
   *  a fish, and SHARK if it contains a shark.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int cellContents(int x, int y) {
    // Replace the following line with your solution.
	  if(ocean[x][y]==EMPTY){
		  return EMPTY;
	  }
	  
	  if(ocean[x][y]==SHARK){
		  return SHARK;
	  }
	  if(ocean[x][y]==FISH){
		  return FISH;
	  }
	  else{
		  return ocean[x][y];
	  }
    
  }

  /**
   *  timeStep() performs a simulation timestep as described in README.
   *  @return an ocean representing the elapse of one timestep.
   */
public int getxPos(int x){
	int pos=0;
	if (x<0){
		pos=this.width+x;
	}
	else{
		pos= x%this.width;
	}
	return pos;
}
public int getyPos(int y){
	int pos=0;
	if (y<0){
		pos=this.height+y;
	}
	else{
		pos= y%this.height;
	}
	return pos;
}
  public Ocean timeStep() {
    // Replace the following line with your solution.
	  int w=this.width;
	  int h= this.height;
	  int temp[][]=ocean;
	  int fedShark[]=fed;
	  for(int i=0;i<this.width;i++){
		  for(int j=0;j<this.height;j++){
			  
			  if(ocean[i][j]==SHARK){
				 
				  if(ocean[getxPos(i)][getyPos(j+1)]==FISH){
					  temp[getxPos(i)][getyPos(j+1)]=EMPTY;
					  fedShark[i*j]+=1;
					 
				  }
				  else if(ocean[getxPos(i)][getyPos(j-1)]==FISH){
					  temp[getxPos(i)][getyPos(j-1)]=EMPTY;
					  fedShark[i*j]+=1;
					
				  }
				  
				  else if(ocean[getxPos(i+1)][getyPos(j)]==FISH){
					  temp[getxPos(i+1)][getyPos(j)]=EMPTY;
					  fedShark[i*j]+=1;
					  
				  }
				  
				  else if(ocean[getxPos(i+1)][getyPos(j-1)]==FISH){
					  temp[getxPos(i+1)][getyPos(j-1)]=EMPTY;
					  fedShark[i*j]+=1;
					 
				  }
				  
				  else if(ocean[getxPos(i+1)][getyPos(j+1)]==FISH){
					  temp[getxPos(i+1)][getyPos(j+1)]=EMPTY;
					  fedShark[i*j]+=1;
					  
				  }
				  
				  
				  
				  else if(ocean[getxPos(i-1)][getyPos(j+1)]==FISH){
					  temp[getxPos(i-1)][getyPos(j+1)]=EMPTY;
					  fedShark[i*j]+=1;
					  
				  }
				  else if(ocean[getxPos(i-1)][getyPos(j-1)]==FISH){
					  temp[getxPos(i-1)][getyPos(j-1)]=EMPTY;
					  fedShark[i*j]+=1;
					  
				  }
				  else if(ocean[getxPos(i-1)][getyPos(j)]==FISH){
					  temp[getxPos(i-1)][getyPos(j)]=EMPTY;
					  fedShark[i*j]+=1;
					
				  }
				  
				  
				  else{
					  fedShark[i*j]=fedShark[i*j]-1;
					  if(fedShark[i*j]<1){
						  temp[i][j]=EMPTY;
					  }
				  }
				  continue;
			  }
			  
			  else if(ocean[i][j]==FISH){
				  int numOfSarks=0;
				  if(ocean[getxPos(i)][getyPos(j+1)]==SHARK){
					  numOfSarks++;
				  }
				  if(ocean[getxPos(i)][getyPos(j-1)]==SHARK){
					  numOfSarks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j)]==SHARK){
					  numOfSarks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j-1)]==SHARK){
					  numOfSarks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j+1)]==SHARK){
					  numOfSarks++;;
				  }
				  
				  if(ocean[getxPos(i-1)][getyPos(j+1)]==SHARK){
					  numOfSarks++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j-1)]==SHARK){
					  numOfSarks++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j)]==SHARK){
					  numOfSarks++;;
				  }
				  else if(numOfSarks>=2){
					  temp[i][j]=SHARK;
					  
				  }
				  else{
					  continue;
				  }
				  
			  }else if(ocean[i][j]==EMPTY){
				  int numOfFish=0;
				  int numOfSharks=0;
				  
				  if(ocean[getxPos(i)][getyPos(j+1)]==SHARK){
					  numOfSharks++;
				  }
				  if(ocean[getxPos(i)][getyPos(j-1)]==SHARK){
					  numOfSharks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j)]==SHARK){
					  numOfSharks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j-1)]==SHARK){
					  numOfSharks++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j+1)]==SHARK){
					  numOfSharks++;;
				  }
				  
				  if(ocean[getxPos(i-1)][getyPos(j+1)]==SHARK){
					  numOfSharks++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j-1)]==SHARK){
					  numOfSharks++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j)]==SHARK){
					  numOfSharks++;;
					
				  }


				  
				  
				  
				  if(ocean[getxPos(i)][getyPos(j+1)]==FISH){
					  numOfFish++;
				  }
				  if(ocean[getxPos(i)][getyPos(j-1)]==FISH){
					  numOfFish++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j)]==FISH){
					  numOfFish++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j-1)]==FISH){
					  numOfFish++;;
				  }
				  
				  if(ocean[getxPos(i+1)][getyPos(j+1)]==FISH){
					  numOfFish++;;
				  }
				  
				  if(ocean[getxPos(i-1)][getyPos(j+1)]==FISH){
					  numOfFish++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j-1)]==FISH){
					  numOfFish++;;
				  }
				  if(ocean[getxPos(i-1)][getyPos(j)]==FISH){
					  numOfFish++;;
				  }
				  else if(numOfSharks<=2&&numOfFish>=2){
					  temp[i][j]=FISH;
					  
					  
				  }
			  }
		  }
	  }
	 
	  
	 
	Ocean n = new Ocean(this.width, this.height, this.starveTime);
	n.ocean=temp;
	n.fed=fedShark;
    return n;
  }

  /**
   *  The following method is required for Part II.
   */

  /**
   *  addShark() (with three parameters) places a shark in cell (x, y) if the
   *  cell is empty.  The shark's hunger is represented by the third parameter.
   *  If the cell is already occupied, leave the cell as it is.  You will need
   *  this method to help convert run-length encodings to Oceans.
   *  @param x is the x-coordinate of the cell to place a shark in.
   *  @param y is the y-coordinate of the cell to place a shark in.
   *  @param feeding is an integer that indicates the shark's hunger.  You may
   *         encode it any way you want; for instance, "feeding" may be the
   *         last timestep the shark was fed, or the amount of time that has
   *         passed since the shark was last fed, or the amount of time left
   *         before the shark will starve.  It's up to you, but be consistent.
   */

  public void addShark(int x, int y, int feeding) {
    // Your solution here.
	  if (ocean[x][y]==0) this.ocean[x][y]=SHARK; this.fed[x*y]=feeding;
  }

  /**
   *  The following method is required for Part III.
   */

  /**
   *  sharkFeeding() returns an integer that indicates the hunger of the shark
   *  in cell (x, y), using the same "feeding" representation as the parameter
   *  to addShark() described above.  If cell (x, y) does not contain a shark,
   *  then its return value is undefined--that is, anything you want.
   *  Normally, this method should not be called if cell (x, y) does not
   *  contain a shark.  You will need this method to help convert Oceans to
   *  run-length encodings.
   *  @param x is the x-coordinate of the cell whose contents are queried.
   *  @param y is the y-coordinate of the cell whose contents are queried.
   */

  public int sharkFeeding(int x, int y) {
    // Replace the following line with your solution.
	  if(this.ocean[x][y]!=SHARK) return 0;
	  else return this.fed[x*y];
 
  }

}
