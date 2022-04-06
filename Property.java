/* 

	 * Class: CMSC203  

	 * Instructor: Grigory Grinberg

	 * Description: Class definition of a Property.

	 * Due: 4/05/2022 

	 * Platform/compiler: Eclipse

	 * I pledge that I have completed the programming assignment independently. 

	   I have not copied the code from a student or any source. 

	   I have not given my code to any student. 

	   Print your Name here: Thienbao Ngo

	*/ 

public class Property { 

	//Instance variables: 

	private String name, city, owner; private double rental_Amount;
	private Plot plot; //Assume they are private
	public final boolean D_VAR;

	//Constructor 

	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot (sets the x, y values to zero, depth and width to 1)
	 */
	Property(){ 

		this.name = ""; 

		this.city = ""; 

		this.owner = ""; 

		this.rental_Amount = 0.0; 

		this.plot = new Plot(); //Assume default constructor

		this.D_VAR = true;

	} 
	/**
	 * Parameterized Constructor, no Plot information provided
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	Property(String propertyName, String city, double rentAmount, String owner){ 

		this.name = propertyName; 

		this.city = city; 

		this.owner = owner; 

		this.rental_Amount = rentAmount; 

		this.plot = new Plot(); //Assume default constructor

		this.D_VAR = false;

	} 
	/**
	 * Constructor, Parameterized constructor, 8 arguments.
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth){ 

		this.name = propertyName; 

		this.city = city; 

		this.owner = owner; 

		this.rental_Amount = rentAmount; 

		this.plot = new Plot(x, y, width, depth);

		this.D_VAR = false;

	} 
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it.
	 * @param p
	 */
	Property(Property p){ 

		//Copy constructor, however you do a copy constructor, use Clone method?- } 

		//Getters, assume public

		this.city = p.getCity();
		this.name = p.getPropertyName();
		this.owner = p.getOwner();
		this.rental_Amount = p.getRentalAmount();
		this.plot = new Plot(p.getPlot().getX(),p.getPlot().getY(),p.getPlot().getLength(),p.getPlot().getDepth());

		this.D_VAR = false;

		//WORK ON THIS - finished.

	}
	/**
	 * Method returns the property Name
	 * @return
	 */
	public String getPropertyName(){ 

		return this.name; 

	}
	/**
	 * Method gets the City Name
	 * @return
	 */
	String getCity(){ 

		return this.city; 

	} 
	/**
	 * Method gets the Owner name.
	 * @return
	 */
	String getOwner(){ 

		return this.owner; 

	} 
	/**
	 * Method gets the RentalAmount
	 * @return
	 */
	double getRentalAmount(){ 

		return this.rental_Amount; 

	} 
	/**
	 * Method returns Plot
	 * @return
	 */
	Plot getPlot(){ 

		return this.plot; 

	} 

	//Setters 
	/**
	 * Method sets the name variable.
	 * @param name
	 */
	void setName(String name){ 

		this.name = name;

	} 
	/**
	 * Method sets the Plot values and return the Plot instance
	 * @param city
	 */
	void setCity(String city){ 

		this.city = city; 

	} 
	/**
	 * Method sets the Owner name.
	 * @param owner
	 */
	void setOwner(String owner){ 

		this.owner = owner;

	} 
	/**
	 * Method sets the rent amount.
	 * @param amount
	 */
	void setRentalAmount(double amount){ 

		this.rental_Amount = amount;

	} 
	/**
	 * Method sets the Plot values.
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	void setPlot(int x, int y, int width, int depth){ 

		this.plot = new Plot(x, y, width, depth); //All primitive data 

	}

	//Override 
	/**
	 * Method prints out the name, city, owner and rent amount for a property.
          Example:
              Property Name: Lakewood
               Located in Rockville
               Belonging to: Alex Tan
               Rent Amount: 3000.0
          Be sure the last item is the rent amount, preceded by a space.
	 */
	public String toString(){ 

		String output = "Property Name: " + this.getPropertyName();

		output = "Located in " + this.getCity() + 
				"Belonging to: " + this.getOwner() + 
				"Rent Amount: " + this.getRentalAmount();

		return output;

	} 

} 
