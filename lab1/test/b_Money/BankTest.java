package b_Money;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	@Test
	public void testGetName() {
		
		try {
			
			assertEquals("DanskeBank", DanskeBank.getName());
			
		} catch (Exception e) {
			fail("Failed getting banks name");
		}
		
	}

	@Test
	public void testGetCurrency() {
		
		try {
			assertEquals(DKK, DanskeBank.getCurrency());
			
		} catch (Exception e) {
			fail("Write test case here");
		}
		
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
	try {
		
		SweBank.openAccount("Oskar");
		
		assertNotNull(SweBank.getAccountlist().get("Oskar"));
		
		
		
	} catch (Exception e) {
		fail("Write test case here");
	}
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException {
		
		
		try {
			SweBank.deposit("Ulrika", new Money(100, new Currency("SEK",new Double(0.2))));
			
		assertEquals(100, SweBank.getAccountlist().get("Ulrika").getBalance().getAmount(),0.1);	
		} catch (Exception e) {
			
			fail("Write test case here");
		}
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException {
		
		
		try {
			
			SweBank.deposit("Ulrika", new Money(100, new Currency("SEK",new Double(0.2))));
			SweBank.withdraw("Ulrika",new Money(100,new Currency("SEK",new Double(0.2))));
			
			assertEquals(0,SweBank.getAccountlist().get(("Ulrika")).getBalance().getAmount(),0.1);
		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException {
		try {
			
			
			assertNotNull(SweBank.getBalance("Ulrika"));
			
		} catch (Exception e) {
			fail("not");
		}
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException {
		
		
		try {
			SweBank.transfer("Ulrika", "Bob", new Money(100, DKK));
		} catch (Exception e) {
			fail("Write test case here");
		}
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		try {
			
			SweBank.addTimedPayment("Ulrika", "1", 10, 1000, new Money(100, DKK), DanskeBank, "Gertrud");
			
		} catch (Exception e) {
			fail("Write test case here");
		}
		
	}
}
