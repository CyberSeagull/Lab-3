import java.time.LocalDate;

public class Passtermcard extends CardData {
    public enum Termdata {day, week, month}; 
    public Termdata termdata;    
    private LocalDate enddate;
    
	public Passtermcard(int idcard, Typecard typecard, Termdata termdata) {
		super(idcard, typecard);
		this.termdata=termdata;
		enddate= getlastdate();
	}
	
	@Override
	public boolean Checkcard () 
	{ 
		return (!blocked &&  valid ()); 
	};
	
	public boolean valid () 
	{	
		return	(LocalDate.now()).isBefore(enddate);
	}
	
	private LocalDate getlastdate()
	{
		int countday=0;
		LocalDate bdate=LocalDate.now();
		switch (termdata) {
		case day:
			countday=1;
			break;
		case week:
			countday=(bdate.getDayOfWeek()).getValue();
			countday=7-countday;
			break;
		case month:
			countday=bdate.lengthOfMonth()- bdate.getDayOfMonth()+1;
			break;
		}
		return bdate.plusDays(countday);
	};

	public String cardinfo () 
	{ 		
		String ss;	 
    	if (valid())  		   
  		   ss= "The card is not expired. \n";
     	else				
     		ss= "The card is expired. \n";
		return super.cardinfo()+
				"Card type - validity card. \nThe card is valid until " + enddate+". \n"+ss;
	};

}       


