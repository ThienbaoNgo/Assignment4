import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlotTest {
	private Plot plot1, plot2, plot3, plot4, plot5, plot6, plot7, plot8, plot9, 
		plot10, plot11, plot12, plot13;

	@Before
	public void setUp() throws Exception {
		plot1 = new Plot(12,12,6,6); 
		plot2 = new Plot(10,10,2,2);
		plot3 = new Plot(11,11,3,2);
		plot4 = new Plot(16,11,4,2);
		plot5 = new Plot(13,14,4,3);
		plot6 = new Plot(16,15,3,1);
		plot7 = new Plot(11,16,3,3);
		plot8 = new Plot(16,17,4,2);
		plot9 = new Plot(11,14,2,1);
		plot10 = new Plot(19,12,2,2);
		plot11 = new Plot(12,12,3,2);
		plot12 = new Plot(15,17,3,1);
		plot13 = new Plot(15,17,3,1);
	}

	@After
	public void tearDown() throws Exception {
		plot1=plot2=plot3=plot4=plot5=plot6=plot7=plot8=plot9=plot10=plot11=plot12=plot13=null;
	}

	@Test
	public void testOverlaps1() {
		assertTrue(plot1.Overlaps(plot11)); //plot11 is entirely inside plot1
		assertTrue(plot11.Overlaps(plot1));
	}
	@Test
	public void testOverlaps2() {
		assertTrue(plot1.Overlaps(plot3)); //plot3 overlaps the lower left corner of plot1
		assertTrue(plot3.Overlaps(plot1));
		assertTrue(plot1.Overlaps(plot4)); //plot4 overlaps the lower right corner of plot1
		assertTrue(plot4.Overlaps(plot1));
	}
	@Test
	public void testOverlaps3() {
		assertTrue(plot1.Overlaps(plot7)); //plot7 overlaps the upper left corner of plot1
		assertTrue(plot7.Overlaps(plot1));
		assertTrue(plot1.Overlaps(plot8)); //plot8 overlaps the upper right corner of plot1
		assertTrue(plot8.Overlaps(plot1));
	}
	@Test
	public void testOverlaps4() {
		assertTrue(plot1.Overlaps(plot9)); //plot9 overlaps the left side of plot1
		assertTrue(plot9.Overlaps(plot1));
		assertTrue(plot1.Overlaps(plot6)); //plot6 overlaps the right side of plot1
		assertTrue(plot6.Overlaps(plot1));
	}
	@Test
	public void testOverlaps5() {
		assertFalse(plot3.Overlaps(plot9)); //plot9 does not overlap plot3
		assertFalse(plot9.Overlaps(plot3));
		assertFalse(plot5.Overlaps(plot8)); //plot5 does not overlap plot8, but partly share a side
		assertFalse(plot8.Overlaps(plot5));
	}
	@Test
	public void testOverlaps6() {
		assertFalse(plot3.Overlaps(plot4)); //plot4 does not overlap plot3
		assertFalse(plot4.Overlaps(plot3));
		assertFalse(plot1.Overlaps(plot10)); //plot1 does not overlap plot10
		assertFalse(plot10.Overlaps(plot1));
		assertFalse(plot2.Overlaps(plot1));	//plot2 does not overlap plot1
		assertTrue(plot12.Overlaps(plot13)); //plot12 is exactly the same dimensions as plot13
	}
	@Test
	public void testEncompasses1() {
		assertTrue(plot1.Encompasses(plot5)); //plot5 is contained in plot1
		assertFalse(plot5.Encompasses(plot1));
		assertTrue(plot1.Encompasses(plot11)); //plot11 is contained in plot1
		assertFalse(plot11.Encompasses(plot1));
		assertTrue(plot1.Encompasses(plot12)); //plot12 is contained in plot1
		assertFalse(plot12.Encompasses(plot1));		
		
		assertFalse(plot2.Encompasses(plot1));	
		assertFalse(plot3.Encompasses(plot1)); //plot3 overlaps plat1
		assertFalse(plot1.Encompasses(plot3));
		assertFalse(plot7.Encompasses(plot8)); //plot7 overlaps plat8
		assertFalse(plot8.Encompasses(plot7));
	}

	@Test
	public void testToString() {
		System.out.println(plot1);
		assertEquals("Upper left: (12,12); Width: 6 Depth: 6", ""+plot1);
	}
	
	@Test
	public void testGetWidth() {
		assertEquals(2, plot2.getWidth());
	}
	
	@Test
	public void testSetX() {
		plot3.setX(22);
		assertEquals(22, plot3.getX());
	}

}
