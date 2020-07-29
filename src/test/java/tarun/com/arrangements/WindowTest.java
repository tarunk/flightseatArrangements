package tarun.com.arrangements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WindowTest extends TestCase {
	private Windows window;
	public WindowTest( String testName ) {
        super( testName );
        window = new Windows();
        window.setSeatNo(100);
    }
	
	public static Test suite() {
        return new TestSuite( WindowTest.class );
    }

	public void testSeatString() {
		assertEquals(window.toString(), "[W-100]");
	}

}
