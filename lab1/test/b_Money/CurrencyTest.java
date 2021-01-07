package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CurrencyTest {
	Currency SEK, DKK, NOK, EUR;
	
	@Before
	public void setUp() throws Exception {
		/* Setup currencies with exchange rates */
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
	}

	@Test
	public void testGetName() {
		
				try {
					assertEquals(SEK.getName(),"SEK");
		
	assertEquals(DKK.getName(),"DKK");
	
	assertEquals(EUR.getName(), "EUR");
				} catch (Exception e) {
					fail("test failed");
				}
	}
	
	@Test
	public void testGetRate() {
		
		try {
		assertNotNull(DKK.getRate());
		assertNotNull(SEK.getRate());
		assertNotNull(EUR.getRate());
			}catch (Exception e) {
		fail("one of the tests failed");
	}
	}
	
	@Test
	public void testSetRate() {
		
		SEK.setRate(0.20);
		DKK.setRate(0.25);
		EUR.setRate(1.00);
		final double DELTA = 0.1;
		try {
			
	    assertEquals(0.20, SEK.getRate().doubleValue(), DELTA);
	    assertEquals(0.25, DKK.getRate().doubleValue(),DELTA);
	    assertEquals(1.00, EUR.getRate().doubleValue(),DELTA);
			
		} catch (Exception e) {
			fail("one test failed");
		}
		
		
	}
	
	@Test
	public void testGlobalValue() {
		final double DELTA = 0.1;
		int amounta = 100;
		int amountb = 100;
		int amountc = 100;
		
		
		amounta = (int)( amounta * SEK.getRate());
		amountb = (int)( amountb * DKK.getRate());
		amountc = (int)( amountc * EUR.getRate());
		
		try {
			assertEquals(15, amounta);
			assertEquals(20, amountb);
			assertEquals(150, amountc);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testValueInThisCurrency() {
		
		int amounta = (int) (100 *EUR.getRate());
		
		try {

			assertEquals(150, amounta);
			
		} catch (Exception e) {
					fail("Write test case here");

		}
		
		
	}

}
