package tarun.com.arrangements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class AisleTest extends TestCase {
	private Aisle aisle;
	public AisleTest( String testName ) {
        super( testName );
        aisle = new Aisle();
        aisle.setSeatNo(10);
    }
	
	public static Test suite() {
        return new TestSuite( AisleTest.class );
    }

	public void testSeatString() {
		assertEquals(aisle.toString(), "[A- 10]");
	}
}
