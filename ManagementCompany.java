/* 

	* Class: CMSC203  

	 * Instructor: Grigory Grinberg

	 * Description: Class definition of a Management Company.

	 * Due: 4/05/2022 

	 * Platform/compiler: Eclipse

	 * I pledge that I have completed the programming assignment independently. 

	   I have not copied the code from a student or any source. 

	   I have not given my code to any student. 

	   Print your Name here: Thienbao Ngo

	*/ 

public class ManagementCompany{ 

	//Instance Variables 

	final private int MAX_PROPERTY = 5; 

	private double mgmFeePer; 

	private String name; 

	private Property[] properties; 

	private String taxID; 

	private int MGMT_WIDTH = 10; 

	private int MGMT_DEPTH = 10; 

	private Plot plot;
	
	/**
	 * No-Arg Constructor that creates a ManagementCompany object using empty strings and the plot set to a Plot with x, y set to 0 , width and depth set to 10.
properties array is initialized here as well.
	 */

	ManagementCompany(){ 

		mgmFeePer = 0.0; 

		name = ""; 

		taxID = ""; 

		this.plot = new Plot(0, 0 , MGMT_WIDTH, MGMT_DEPTH);
		//Create an empty array of properties.

		this.properties = new Property[this.MAX_PROPERTY];
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();

	} 
	
	/**
	 * Constructor Creates a ManagementCompany object using the passed information.
plot is set to a Plot with x, y set to 0 , width and depth set to 10
properties array is initialized here as well
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */

	ManagementCompany(String name, String taxID, double mgmFee){ 

		this.mgmFeePer = mgmFee; 

		this.name = name; 

		this.taxID = taxID; 

		this.plot = new Plot(0, 0 , MGMT_WIDTH, MGMT_DEPTH);
		//Create an empty array of properties. 

		this.properties = new Property[this.MAX_PROPERTY];
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();
	} 
/**
 * Constructor Creates a ManagementCompany object using the passed information.
 * @param name
 * @param taxID
 * @param mgmFee
 * @param x
 * @param y
 * @param length
 * @param depth
 */
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int length, int depth){ 

		this.name = name; 

		this.taxID = taxID; 

		this.mgmFeePer = mgmFee;
		
		this.plot = new Plot();

		this.plot.setX(x);

		this.plot.setY(y); 

		this.plot.setLength(length); 

		this.plot.setDepth(depth); 

		//Create an empty array of properties.

		this.properties = new Property[this.MAX_PROPERTY];
		properties[0] = new Property();
		properties[1] = new Property();
		properties[2] = new Property();
		properties[3] = new Property();
		properties[4] = new Property();

	} 
/**
 * Copy Constructor that creates a ManagementCompany object from another ManagementCompany object
 * @param othercompany
 */
	ManagementCompany(ManagementCompany othercompany){ 

		this.name = othercompany.getName(); 

		this.taxID = othercompany.getTaxID(); 

		this.mgmFeePer = othercompany.getMgmFeePer(); 

		this.plot.setX(othercompany.getPlot().getX()); 

		this.plot.setY(othercompany.getPlot().getY()); 

		this.plot.setLength(othercompany.getPlot().getLength()); 

		this.plot.setDepth(othercompany.getPlot().getDepth()); 

		//Copy array of properties. 

		this.properties = new Property[5]; 

		for(int i = 0; i < othercompany.properties.length; i++){ 

			this.properties[i] = new Property(othercompany.properties[i]); 

		} 

	} 
/**
 * Method returns the plot incstance variable.
 * @return
 */
	public Plot getPlot() {
		// TODO Auto-generated method stub
		return this.plot;
	}
/**
 * Method returns the Management Fee Percentage.
 * @return
 */
	public double getMgmFeePer() {
		// TODO Auto-generated method stub
		return this.mgmFeePer;
	}
/**
 * Method returns TaxID.
 * @return
 */
	public String getTaxID() {
		// TODO Auto-generated method stub
		return this.taxID;
	}
/**
 * Methods returns Management Company's name.
 * @return
 */
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
/**
 * Creates a property object by copying from another property and adds it to the "properties" array.
 * 
 * return -1 if the array is full ,
-2 if the Property object is null
-3 if if management company does not encompass the property plot
-4 if property plot overlaps ANY of properties in array
otherwise return the index of the array where the property was added.
 * @param property
 * @return
 */
	int addProperty(Property property){ 

		//instantiate integer as a very large number

		int smallest = 10000;
		
		//Check condition
		
		/*
		
		if((property instanceof Property) == false || (name instanceof String) == false || (city instanceof String) == false || ((Double)rent instanceof Double) == false || (owner instanceof String) == false || ((Integer)x instanceof Integer) == false || ((Integer)y instanceof Integer) == false || ((Integer)width instanceof Integer == false|| ((Integer)depth instanceof Integer) == false)){ 

			return -2; 
		}  */
		
		if(this.plot.Encompasses(property.getPlot()) == false){ 
			
			return -3; 

		}
		
		//Have a for loop find the smallest “empty” element.

		for(int i = 0; i < this.properties.length; i++) {

			if(properties[i].D_VAR == true && i < smallest){
				properties[i] = new Property(property);
				smallest = i;
				
				break;
			}
			else if(property.getPlot().Overlaps(this.properties[i].getPlot())==true){
				
				if(this.properties[i].D_VAR == true) {
					break;
				}
				
				//System.out.println(property.getPlot().toString());
				//System.out.println(this.properties[i].getPlot().toString());
				//debug
				
				return -4;
			}
		}
		
		if(smallest == 10000){
			smallest = -1;
		}

		//Smallest is needed, because you need to return the int of the position for whatever reason.

		//store int value in integer if an empty element is found 

		//store property at element [smallest “empty” element] 

		return smallest; 

	} 
/**
 * Creates a property object with a default plot and adds it to the "properties" array.
 * 
 * return -1 if the array is full ,
-2 if the Property object is null
-3 if if management company does not encompass the property plot
-4 if property plot overlaps ANY of properties in array
otherwise return the index of the array where the property was added.
 * @param name
 * @param city
 * @param rent
 * @param owner
 * @return
 */
	int addProperty(String name,String city,double rent,String owner){

		Property addedProperty = new Property(name, city, rent, owner);

		//instantiate integer as large number.
		//Have a for loop find the smallest “empty” element.
		
		/*

		int smallest = 10000;

		for(int i = 0; i < this.properties.length; i++) {

			if(properties[i].D_VAR == true && i < smallest){
				properties[i] = addedProperty;
				smallest = i; //store int value in integer if an empty element is found
			}
		} */
		
		return this.addProperty(addedProperty);

	} 
/**
 * Creates a property object and adds it to the "properties" array.
return -1 if the array is full ,
-2 if the Property object is null
-3 if if management company does not encompass the property plot
-4 if property plot overlaps ANY of properties in array
otherwise return the index of the array where the property was added.
 * @param name
 * @param city
 * @param rent
 * @param owner
 * @param x
 * @param y
 * @param width
 * @param depth
 * @return
 */
	int addProperty( String name, String city, double rent, String owner, int x, int y, int width, int depth){

		/*
		
		int smallest = 10000;

		int place = -1; */

		Property newProperty = new Property(city,owner,rent,name,x,y,width,depth); 
		
		/*

		if((newProperty instanceof Property) == false || (name instanceof String) == false || (city instanceof String) == false || ((Double)rent instanceof Double) == false || (owner instanceof String) == false || ((Integer)x instanceof Integer) == false || ((Integer)y instanceof Integer) == false || ((Integer)width instanceof Integer == false|| ((Integer)depth instanceof Integer) == false)){ 

			return -2; 
		} 

		System.out.println(this.plot);
		System.out.println(newProperty.getPlot());
		System.out.println(this.plot.Encompasses(newProperty.getPlot()));
		
		if(this.plot.Encompasses(newProperty.getPlot()) == false){ 
			
			return -3; 

		} 

		for(int i = 0; i < this.properties.length; i++){ 

			if(this.properties[i].D_VAR == true){ 
				place = i; }
			else if(newProperty.getPlot().Overlaps(this.properties[i].getPlot())==true){ 
				return -4;
			}

		} 

		if(place != -1){
			this.properties[place] = newProperty; } 

		return place; 

		//Do they want me to place it anyway?- Update: What the hell was I asking myself?
		 * 
		
		 */
		 return this.addProperty(newProperty);

	} 
/**
 * Method displays the information of the property at index i
 * @param i
 * @return
 */
	String displayPropertyatIndex(int i){
		
		String returned = "";
		
		returned += "Property Name: " + properties[i].getPropertyName() + "\n";
		returned += "Located in " + properties[i].getCity() + "\n";
		returned += "Belonging to: " + properties[i].getOwner() + "\n";
		returned += "Rent Amount: " + properties[i].getRentalAmount() + "\n";
		
		

		//return one long string with the property’s information by using a combination of getters, this, “ “, and +; WORK ON THIS

		return returned;

	} 

	/**
	 * Methods return the MAX_PROPERTY constant that represents the size of the "properties" array.
	 * @return
	 */
	
	public int getMAX_PROPERTY(){ 

		return MAX_PROPERTY; 

	} 

	//Override 

	
	/**
	 * Method displays the information of all the properties in the "properties" array.
	 */
	public String toString(){ 

		//return one long string with all the properties information by using a combination of getters, this, “ “, and +;
		
		String returned = "";
		
		returned += "List of properties for " + this.getName() + ", taxID: " + this.getTaxID() + "\n";
		
		returned += "---------\n";
		
		for(int i = 0; i < this.properties.length; i++) {
		
		if(this.properties[i].D_VAR == true) {
				break;
			}
			
		returned += this.displayPropertyatIndex(i);
			
		}
		
		returned += "---------\n";
		
		returned += "Management fee: " + (this.totalRent() * (this.getPercentage() / 100)) + "\n";
		

		return returned;

	} 

	
	/**
	 * This method finds a property within the properties array that has the maximum rent amount and returns the rent amount.
	 * @return
	 */
	public double maxRentProp(){ 

		//Use a for loop and an instantiated value to compare with all other elements with an if statement to see which one has the highest rent, make sure to check for null spaces, store the highest rent in the instantiated value. Return instantiated value; 

		return properties[this.MaxRentPropertyIndex()].getRentalAmount();

	} 
	/**
	 * This method finds the index of the property with the maximum rent amount.
	 * @return
	 */
	public int MaxRentPropertyIndex(){ 

		//Use a for loop and an instantiated value to compare with all other elements with an if statement to see which one has the highest rent, make sure to check for null spaces, store element of the property with the highest rent in the instantiated value. Return instantiated value; 
		double maxRent = -20000;
		int memory = 0;
		for(int i = 0; i < this.properties.length; i++) {
			if(properties[i].getRentalAmount() > maxRent) {
				maxRent = properties[i].getRentalAmount();
				memory = i;
			}
		}
		return memory;
	} 
	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * @return
	 */
	public double totalRent() { 

		return this.properties[0].getRentalAmount() + this.properties[1].getRentalAmount() + this.properties[2].getRentalAmount() + this.properties[3].getRentalAmount() + this.properties[4].getRentalAmount(); 

	}
	/**
	 * Method returns the percentage fee of the Company class.
	 * @return
	 */
	public double getPercentage() {
		return mgmFeePer;
		
	}
	

	//Instiate double or int; 

	//Use a for loop to parse through the properties array, making sure not to try and grab any null elements, add up all the rents values to the instantiated variable. 

} 



