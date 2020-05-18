
public class Passcumulativecard extends CardData {

	private int counpay=0;    
	private int remainder=0;  
	public Passcumulativecard(int idcard, int counpay, int remainder) {
		super(idcard,  Typecard.ordinary); 
	    this.counpay = counpay;
	    this.remainder = remainder;
	}

	public void addmoneycard(int pay) 
	{
		remainder+=pay;
	};

	@Override
	public boolean Checkcard () 
	{ 
		if (!blocked && valid ()) { 
			remainder-=counpay;
			return true;
		} 
		return false;
	};
	public boolean valid () 
	{	
		return	remainder-counpay>=0;
	}

	public String cardinfo () 
	{ 
		String ss="";
    	if (valid())
 		   ss= "The card is not expired. \n";
    	else	
		   ss= "Not enough money. \n";
		return super.cardinfo()+ 
				"Card type - cumulative. \nCard balance " + remainder+
				". \nOne trip payment " + counpay+". \n"+ss;
	};

}

