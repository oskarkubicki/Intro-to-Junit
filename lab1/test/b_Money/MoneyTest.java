package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	Currency SEK, DKK, NOK, EUR;
	Money SEK100, EUR10, SEK200, EUR20, SEK0, EUR0, SEKn100;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		DKK = new Currency("DKK", 0.20);
		EUR = new Currency("EUR", 1.5);
		SEK100 = new Money(10000, SEK);
		EUR10 = new Money(1000, EUR);
		SEK200 = new Money(20000, SEK);
		EUR20 = new Money(2000, EUR);
		SEK0 = new Money(0, SEK);
		EUR0 = new Money(0, EUR);
		SEKn100 = new Money(-10000, SEK);
	}

	@Test
	public void testGetAmount() {
		try {
			
			assertEquals(SEK100.getAmount(), 10000,0.1);
			
		} catch (Exception e) {
			// TODO: handle exception
			fail("Write test case here");
		}
	}

	@Test
	public void testGetCurrency() {
		
		try {
			assertNotNull(EUR10.getCurrency());
		} catch (Exception e) {
			fail("Write test case here");
		}
	}

	@Test
	public void testToString() {
		
		try {
			assertEquals("1000 EUR", EUR10.toString());
		} catch (Exception e) {
			fail("Write test case here");
		}
	}

	@Test
	public void testGlobalValue() {
		
		try {
			
			assertEquals(1500, EUR10.getAmount()*EUR10.getCurrency().getRate(),0.1);
			
		} catch (Exception e) {
			fail("Write test case here");
		}
		
	}

	@Test
	public void testEqualsMoney() {
	assertFalse(EUR0.equals(EUR20));
	}

	@Test
	public void testAdd() {
		assertNotNull(EUR10.add(SEK100));
	}

	@Test
	public void testSub() {
		assertNotNull(EUR10.sub(SEK100));
	}

	@Test
	public void testIsZero() {
		assertTrue(EUR0.isZero());
	}

	@Test
	public void testNegate() {
		
	 boolean negated;
	 
	 if (EUR10.negate().getAmount()<0) {
		 
		 negated = true;
	 }else {
		negated= false;
	}
		assertTrue(negated);
	}

	@Test
	public void testCompareTo() {
		
		
		try {
			
			assertEquals(1, EUR20.compareTo(EUR10));
			
		} catch (Exception e) {
			fail("Write test case here");
		}
		
		
		
		
	}
}
