
public class Passnumbercard extends CardData {
	private int passcount;             
	public Passnumbercard (int idcard, Typecard typecard, int passcount) {
		super(idcard,typecard);
	    this.passcount = passcount;
	    }
	@Override
	public boolean Checkcard () 
	{ 
		if (!blocked &&  valid ()) {
			passcount--;
			return true;
		} 
		return false;
	};

	public boolean valid () 
	{	
		return	passcount>0;
	}
	
	public String cardinfo () 
	{ 
		String ss="";	 
    	if (valid())  		   
  		   ss= "The card is not expired. \n";
     	else				
			ss= "The card is expired. \n";
		return super.cardinfo()+ 
				"Card type - limited number of rides. \nRides left " + passcount+". \n"+ss;
	};

}

