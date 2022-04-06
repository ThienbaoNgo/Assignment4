/* 

	 * Class: CMSC203  

	 * Instructor: Grigory Grinberg

	 * Description: Class definition of a Plot.

	 * Due: 4/05/2022 

	 * Platform/compiler: Eclipse

	 * I pledge that I have completed the programming assignment independently. 

	   I have not copied the code from a student or any source. 

	   I have not given my code to any student. 

	   Print your Name here: Thienbao Ngo

	*/ 

public class Plot{ 

	//Instance variables: 

	private int x, y, length, depth; //Assume they are private 

	//Constructors 
	/**
	 * This is a Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p
	 */
	Plot(Plot p){ 

		//Copy constructor, however you do a copy constructor, use Clone method?- Shallow copy, all primitve variables.

		x = p.getX();
		y = p.getY();
		length = p.getLength();
		depth = p.getDepth();

	} 
	/**
	 *  This is a no-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	Plot(){ 

		this.x = 0; 

		this.y = 0; 

		this.length = 1; 

		this.depth = 1; 

	} 
/**
 * This is a Parameterized Constructor
 * @param x
 * @param y
 * @param width
 * @param depth
 */
	Plot(int x, int y, int width, int depth){ 

		this.x = x; 

		this.y = y;

		this.length = width; 

		this.depth = depth; 

	} 

	//methods 
/**
 * This methods determines if this plot overlaps the parameter,returns true if the two plots overlap, false otherwise
 * @param p
 * @return
 */
	public boolean Overlaps(Plot p){ 

		//Use a for loop (two for loops for a 2D array?) to determine whether or not the plots of land overlap in a 2D array, use an if statement for each element of the 2D array to check if a space is aready “occupied” when placing the second plot. 

		//Create a 2D array of booleans from grabbing the biggest x + width, and the biggest y + depth;
		
		int biggestY;
		int biggestX;
		int smallestY;
		int smallestX;
		
		if((p.getX() + p.getLength()) > (this.getX() + this.getLength())) {
			biggestX = p.getX() + p.getLength();
			smallestX = this.getX() + this.getLength();
		}
		else {
			biggestX = this.getX() + this.getLength();
			smallestX = p.getX() + p.getLength();
		}
		if((p.getY() + p.getDepth()) > (this.getY() + this.getDepth())) {
			biggestY = p.getY() + p.getDepth();
			smallestY = this.getY() + this.getDepth();
		}
		else {
			biggestY = this.getY() + this.getDepth();
			smallestY = p.getY() + p.getDepth();
		}

		boolean[][] map = new boolean[biggestX][biggestY];
		/*
		for(int i = 0; i < biggestX; i++) {
			for(int j = 0; j < biggestY; j++){
				if(map[i][j]==true){
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			}
			System.out.println();
		} */

		//Use a for loop to parse through plot p on the 2D array 

		for(int i = p.getX(); i < (p.getX() + p.getLength()); i++){ 

			for(int j = p.getY(); j < (p.getY() + p.getDepth()); j++){ 

				map[i][j] = true; 

			}
		}
		/*
		for(int i = 0; i < biggestX; i++) {
			for(int j = 0; j < biggestY; j++){
				if(map[i][j]==true){
					System.out.print("1");
				}
				else {
					System.out.print("0");
				}
			} 
			System.out.println();
		} */

		//Use this 

		for(int i = this.getX(); i < (this.getX() + this.getLength()); i++){ 

			for(int j = this.getY(); j < (this.getY() + this.getDepth()); j++){ 

				if(map[i][j] == true){ 

					return true;

					//Otherwise it keeps going.
				}

			} 

		}
		
		

		return false;
		//End of method.

	}
/**
 * This method takes a Plot instance and determines if the current plot contains it.
Note that the determination should be inclusive, in other words, if an edge lies on the edge of the current plot, this is acceptable.
 * @param p
 * @return
 */
	public boolean Encompasses(Plot p){ 

		//Checks to see if plot of land is inside of another one. 

		//Use the for loop structure in the overlap method, but instead of checking to see if all the “blocks” are outside, we’re checking to see if they’re all INSIDE. 

		Boolean answer = true; 

		if(p.getX() + p.getLength() <= this.getX() + this.getLength()){
			//Do nothing.
		} 
		else{ answer = false; } 

		if(p.getY() + p.getDepth() <= this.getY() + this.getDepth()){ 
			//Do nothing.
		} 
		else{ answer = false; } 

		if(p.getX() >= this.getX()){ 
			//Do nothing.
		} 
		else{ answer = false; } 

		if(p.getY() >= this.getY()){ 
			//Do nothing
		}
		else { answer = false; }

		return answer;

	} 

	//Getters 
/**
 * Method returns X
 */
	public int getX(){return this.x;}
	/**
	 * Method returns Y
	 */
	public int getY() {return this.y;}
	/**
	 * Method returns Length
	 */
	public int getLength() {return this.length ;}
	/**
	 * Method returns Depth
	 */
	public int getDepth() {return depth;} 

	//Setters 

	/**
	 * Method sets the X
	 */
	public void setX(int x){this.x = x;}
	/**
	 * Method sets the Y
	 */
	public void setY(int y){this.y = y;}
	/**
	 * Method sets the length
	 */
	public void setLength(int length){this.length = length;}
	/**
	 * Method sets the depth
	 */
	public void setDepth(int depth){this.depth = depth;}
	
	/**
	 * Returns a string with information that represents the plot.
	 */
	public String toString(){
		 //"" + this.getX() + " " + this.getY() + " " + this.getLength() + " " + this.getDepth();
		
		return "Upper left: (" + this.getX() + "," + this.getY() + "); Width: " + this.getWidth() + " Depth: " + this.getDepth();
	}
	/**
	 * Just another way to get the length.
	 * @return
	 */
	public int getWidth() {
		return this.getLength();
	}

} 

 