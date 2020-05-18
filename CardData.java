
public class CardData 
{
	public enum Typecard {ordinary, preferential};
	protected int idcard;           
	protected Typecard typecard;    
	public boolean blocked=false;  
	public int statrefusals=0;    
	public int statpass    =0;    
	
	public CardData (int idcard, Typecard typecard) {
		this.idcard = idcard;
	    this.typecard = typecard;
	    }
	public boolean Checkcard () 
	{ 
		return !blocked;
	};
	public boolean valid () 
	{ 
		return true;
	};
	public void Setblocked (boolean val) 
	{
		blocked=val;
	};

	public String cardinfo () 
	{
		String ss = "    Card data.\n";
		ss+="Card id "+idcard+".  \n";
		ss+="Card type - ";     
	    if (typecard==Typecard.ordinary) ss+= "ordinary (standard price). \n";
	    else ss+= "preferential (50% discount). \n";
		ss+="Number of passes "  +statpass+".\n";     
	    ss+="Number of refusals "  +statrefusals+".\n";
	    if (blocked) 
	    	ss+= "Card is blocked. \n";
	    return ss;
	};
	
}
