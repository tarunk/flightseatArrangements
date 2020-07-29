package tarun.com.arrangements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MiddleTest extends TestCase{
	private Middle middle;
	
	public MiddleTest( String testName ) {
        super( testName );
        middle = new Middle();
    }
	
	public static Test suite() {
        return new TestSuite( WindowTest.class );
    }

	public void testSeatString() {
		assertEquals(middle.toString(), "[W-   ]");
	}
}
