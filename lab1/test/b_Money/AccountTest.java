package b_Money;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
	Currency SEK, DKK;
	Bank Nordea;
	Bank DanskeBank;
	Bank SweBank;
	Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		SweBank.openAccount("Alice");
		testAccount = new Account("Hans", SEK);
		testAccount.deposit(new Money(10000000, SEK));

		SweBank.deposit("Alice", new Money(1000000, SEK));
	}
	
	@Test
	public void testAddRemoveTimedPayment() {
		try {
			testAccount.addTimedPayment("1", 10, 100, new Money(100, DKK), DanskeBank, "Hans");
			
			assertNotNull(testAccount.timedPaymentExists("1"));
		} catch (Exception e) {
			fail("Write test case here");
		}
	}
	
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException {
		
		testAccount.timedPaymentExists("1");
	}

	@Test
	public void testAddWithdraw() {
		
		try {
			testAccount.withdraw(new Money(10, SEK));
			assertEquals(0.0, testAccount.getBalance().getAmount(),0.1);
			
		} catch (Exception e) {
			fail("Write test case here");
		}
	}
	
	@Test
	public void testGetBalance() {
		
		
		try {
			
			assertNotNull(testAccount.getBalance());
			
		} catch (Exception e) {
			fail("Write test case here");
		}
		
	}
}
