package tarun.com.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import tarun.com.arrangements.SeatsArrangements;

public class AeroplaneTest extends TestCase {
	private int [][]arrangements = {{2,3}, {3,4}};
	private Aeroplane aeroplane;
	
	public AeroplaneTest( String testName ) {
        super( testName );
        aeroplane = new Aeroplane(arrangements);
    }
	
	public static Test suite() {
        return new TestSuite( AeroplaneTest.class );
    }
	
	public void testNoOfColArrangements() {
		assertEquals(aeroplane.getColOfArr(), 2);
	}
	
	public void testMaxRows() {
		assertEquals(aeroplane.getMaxRows(), 4);
	}
	
	public void testFirstSeatsArrangements() {
		aeroplane.defineSeats();
		SeatsArrangements[] seatArr = aeroplane.getSeats();
		assertEquals(seatArr[0].status(), "FIRST");
		
	}
	public void testLastSeatsArrangements() {
		aeroplane.defineSeats();
		SeatsArrangements[] seatArr = aeroplane.getSeats();
		assertEquals(seatArr[1].status(), "LAST");
		
	}
}
