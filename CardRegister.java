import java.util.HashMap;
import java.util.Map;

public class CardRegister 
{
	public  Map<Integer, CardData> lcard = new HashMap<Integer, CardData>();
    
   	public boolean releasePassnumbercard (int id, CardData.Typecard typecard, int passcount) 
   	{   
   	    if (!lcard.containsKey(id)) {  
   		CardData cardData = new Passnumbercard(id, typecard, passcount);
   		lcard.put(id, cardData);
   		return true;
	    };
	    return false;    		
   	}

   	public boolean releasePasstermcard(int id, CardData.Typecard typecard, Passtermcard.Termdata termdata)  
   	{
   	    if (!lcard.containsKey(id)) {  
   		CardData cardData = new Passtermcard (id, typecard, termdata);
   		lcard.put(id, cardData);
   		return true;
	    };
	    return false;    		
   	}
   	
	
   	public boolean releasePasscumulativecard(int id, int counpay, int remainder) 
   	{                                                              
   	    if (!lcard.containsKey(id)) {    
   		CardData cardData = new Passcumulativecard (id, counpay, remainder);  
   		lcard.put(id, cardData);
   		return true;
	    };
	    return false;    		
   	}
   	                
   	public boolean passturnstile (int id)  
   	{   
   	    if (!lcard.containsKey(id)) {  
   		return false;
	    };
   		CardData cardData = lcard.get(id);
   		if (cardData.Checkcard())
   		{
   			if (CardData.Typecard.preferential ==cardData.typecard) 
   			warncontroller();
   			cardData.statpass++;  
   			return true;
   		}
   		else
   		{
   			cardData.statrefusals++; 
   			return false;
   		}
   	}

   	public boolean getvalid (int id)  
   	{   
   	    if (!lcard.containsKey(id))      		
   	    	return false;
   		CardData cardData = lcard.get(id);
   		return cardData.valid();
   	}   	   	   	

   	public boolean getblocked (int id)  
   	{   
   	    if (!lcard.containsKey(id))      		
   	    	return true;
   		CardData cardData = lcard.get(id);
   		return cardData.blocked;
   	}   	   	   	


public boolean addmoneytocard(int id, int pay)
{
	    if (!lcard.containsKey(id))      		
   	    	return false;
   		CardData cardData = lcard.get(id);
   		if (cardData instanceof Passcumulativecard) {
   			((Passcumulativecard) cardData).addmoneycard(pay);
   	    	return true;
   		}	    	
   		return false;   
}
   	
   	private void warncontroller() {
        System.out.println("Preferential card. Prepare your documents.");   
   	}

    public void blockcard(int id, boolean toblock)     
    {
    	CardData cardData = lcard.get(id);
        cardData.Setblocked(toblock);
    }

    public void getcardinfo(int id)     
    { 
    	if (lcard.containsKey(id))
    	{
        	System.out.println(lcard.get(id).cardinfo());   
    	}
    	else
        	System.out.println("Card with id "+id+" is not registered.");   
    }
    
    public void getcardregister(int id)     
    { 
    	if (lcard.containsKey(id)) {
    		    	CardData cardData = lcard.get(id);
    	String s="Card "+id+". Number of passes - " +cardData.statpass+
    			 " refusals - " +cardData.statrefusals+".";     
    	System.out.println(s);   
    	}
    	else
        	System.out.println("Card with id "+id+" is not registered.");   
    }

    public void getallcardregister()     
    { 
    	System.out.println("Passes and refusals for all cards. ");
        for(Map.Entry<Integer, CardData> item : lcard.entrySet()){
        	getcardregister(item.getKey());  
        }
    	System.out.println("");
    }

    public void gettypecardregister(CardData.Typecard tc)     
    { 
    	System.out.println(" Passes and refusals for a card type. "+tc);
        for(Map.Entry<Integer, CardData> item : lcard.entrySet()){
        	if (item.getValue().typecard == tc)
        		getcardregister(item.getKey());  
        }
    	System.out.println("");
    }
}
