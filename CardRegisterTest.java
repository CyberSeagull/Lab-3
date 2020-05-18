import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardRegisterTest 
{
	@Test
	void testreleasePassnumbercard() {
		CardRegister regcard = new CardRegister();
		int idcard=9;		
		regcard.releasePassnumbercard (idcard, CardData.Typecard.preferential, 2); 
		assertTrue(regcard.lcard.containsKey(idcard));
		assertTrue(regcard.passturnstile(idcard));    
		assertTrue(regcard.getvalid(idcard)&&!regcard.getblocked(idcard));
		assertTrue(regcard.passturnstile(idcard));    
		assertFalse(regcard.passturnstile(idcard));   
	}
	@Test	
	void testreleasePasstermcard() {			
		CardRegister regcard = new CardRegister();			
		int idcard=9;
			 			
		boolean newrcard = regcard.releasePasstermcard(idcard, CardData.Typecard.ordinary, Passtermcard.Termdata.day); 									
		assertEquals(newrcard, regcard.lcard.containsKey(idcard)); 			
		assertTrue(regcard.passturnstile(idcard));			
		assertFalse(regcard.releasePasstermcard(idcard, CardData.Typecard.ordinary, Passtermcard.Termdata.day));
		}
	@Test	
	void testreleasePasscumulativecard() {			
		CardRegister regcard = new CardRegister();			
		int idcard=9;
		regcard.releasePasscumulativecard (idcard, 10, 23); 
		assertTrue(regcard.lcard.containsKey(idcard));
		assertTrue(regcard.passturnstile(idcard));    
		assertTrue(regcard.getvalid(idcard)&&!regcard.getblocked(idcard));
		assertTrue(regcard.passturnstile(idcard));    
		assertFalse(regcard.passturnstile(idcard));   
		assertTrue(regcard.addmoneytocard(idcard, 22)); 
		assertTrue(regcard.passturnstile(idcard));   
		}
	@Test	
	void testreleasepassturnstile() {			
	CardRegister regcard = new CardRegister();
	int idcard=9;	
	regcard.releasePassnumbercard (idcard, CardData.Typecard.ordinary, 2); 
	assertTrue(regcard.passturnstile(idcard));    
	assertTrue(regcard.passturnstile(idcard));    
	assertFalse(regcard.passturnstile(idcard));   
	}
	@Test
	void testgetvalid() {			
	CardRegister regcard = new CardRegister();
	int idcard=9;	
	regcard.releasePassnumbercard (idcard, CardData.Typecard.ordinary, 1); 
	assertTrue(regcard.getvalid(idcard));
	regcard.passturnstile(idcard);    
	assertFalse(regcard.getvalid(idcard));
	}
	@Test	
	void testblockcard() {			
	CardRegister regcard = new CardRegister();
	int idcard=9;	
	regcard.releasePassnumbercard (idcard, CardData.Typecard.ordinary, 1); 
	assertFalse(regcard.getblocked(idcard));
	regcard.blockcard(idcard,true);
	assertTrue(regcard.getblocked(idcard));
	}
	

}
