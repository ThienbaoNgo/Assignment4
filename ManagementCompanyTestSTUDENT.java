

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		//student add three properties, with plots, to mgmt co
		
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		
		//Object mgmtCo = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {	

		ManagementCompany mgmtCo = new ManagementCompany("My Management Company", "I totally pay taxes.", (double)16, 0, 0, 1000, 1000);
		
		//System.out.print(mgmtCo);
		Property first = new Property("Me", "SilverSalmon", 1200, "My boss.");
		mgmtCo.addProperty(first);
		
		//System.out.print(mgmtCo.totalRent());
		
		Property second = new Property("You", "SilverSalmon", 1200, "Your boss.", 0, 2, 1, 1);
		mgmtCo.addProperty(second);
		
		//System.out.print(mgmtCo.totalRent());
		
		Property sixth = new Property("Friend", "FarAwayLand", 2000, "SomeLandLord", 10, 10, 10, 10); //Should exceed.
		
		int answer;
		
		Property third;
		
		third = new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 3, 1, 1);
		
		int something = mgmtCo.addProperty(third); //third 
		
		//System.out.print(mgmtCo.totalRent());
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 4, 1, 1)); //fourth
		
		//System.out.print(mgmtCo.totalRent());
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 5, 1, 1)); //fifth
		
		//System.out.print(mgmtCo.totalRent());
		
		answer = mgmtCo.addProperty(sixth);
		
		assertEquals(-1, answer);
		//student should add property with 4 args & default plot (0,0,1,1)
		//student should add property with 8 args
		
		//I added more properties in between these.
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
	}
 
	@Test
	public void testMaxRentProp() {
		
ManagementCompany mgmtCo = new ManagementCompany("My Management Company", "I totally pay taxes.", (double)16, 0, 0, 1000, 1000);
		
		//System.out.print(mgmtCo);
		Property first = new Property("Me", "SilverSalmon", 3000, "My boss.");
		mgmtCo.addProperty(first);
		
		Property second = new Property("You", "SilverSalmon", 1200, "Your boss.", 0, 2, 1, 1);
		mgmtCo.addProperty(second);
		
		Property sixth = new Property("Friend", "FarAwayLand", 2000, "SomeLandLord", 10, 10, 10, 10); //Should exceed.
		
		int answer;
		
		Property third;
		
		third = new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 3, 1, 1);
		
		int something = mgmtCo.addProperty(third); //third 
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 4, 1, 1)); //fourth
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 5, 1, 1)); //fifth
		
		assertEquals(3000, (int)mgmtCo.maxRentProp());
		
		//student should test if maxRentProp contains the maximum rent of properties
		
	}

	@Test
	public void testTotalRent() {
		
ManagementCompany mgmtCo = new ManagementCompany("My Management Company", "I totally pay taxes.", (double)16, 0, 0, 1000, 1000);
		
		//System.out.print(mgmtCo);
		Property first = new Property("Me", "SilverSalmon", 1200, "My boss.");
		mgmtCo.addProperty(first);
		
		Property second = new Property("You", "SilverSalmon", 1200, "Your boss.", 0, 2, 1, 1);
		mgmtCo.addProperty(second);
		
		Property sixth = new Property("Friend", "FarAwayLand", 2000, "SomeLandLord", 10, 10, 10, 10); //Should exceed.
		
		int answer;
		
		Property third;
		
		third = new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 3, 1, 1);
		
		int something = mgmtCo.addProperty(third); //third 
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 4, 1, 1)); //fourth
		
		mgmtCo.addProperty(new Property("SomeGuy", "SilverSalmon", 1200, "Your boss.", 0, 5, 1, 1)); //fifth
		
		assertEquals((1200 * 5), (int)mgmtCo.totalRent());
		//student should test if totalRent returns the total rent of properties
	}

 }
