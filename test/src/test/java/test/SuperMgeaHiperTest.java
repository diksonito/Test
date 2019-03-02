package test;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

public class SuperMgeaHiperTest extends TestCase {
	
	Logger log = Logger.getLogger(this.getClass());
	
	public void init() {
		
	}
	
	
	public void testPostive() {
		SuperMegaHiper superMegaHiper = new SuperMegaHiper();
		boolean result;
		try {
			log.trace("Test: testPostive ");
			result = superMegaHiper.isMoreThenZero(1, 2);
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
	}

	public void testNegative() {
		SuperMegaHiper superMegaHiper = new SuperMegaHiper();
		boolean result;
		try {
			result = superMegaHiper.isMoreThenZero(1, -2);
			assertEquals(false, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testZero() {
		SuperMegaHiper superMegaHiper = new SuperMegaHiper();
		boolean result;
		try {
			result = superMegaHiper.isMoreThenZero(1, -1);
			assertEquals(true, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testFirstIsNull() {
		SuperMegaHiper superMegaHiper = new SuperMegaHiper();
		try {
			boolean result = superMegaHiper.isMoreThenZero(null, -1);
		} catch (Exception e) {
			assertEquals(true, e.getClass().equals(NullPointerException.class));
		}

	}

	public void testSecondIsNull() {
		SuperMegaHiper superMegaHiper = new SuperMegaHiper();
		try {
			boolean result = superMegaHiper.isMoreThenZero(1, null);
		} catch (Exception e) {
			assertEquals(true, e.getClass().equals(NullPointerException.class));
		}
	}
}
