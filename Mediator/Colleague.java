
public abstract class Colleague {
	
	private Mediator mediator;
	
	protected int colleagecode;

	public Colleague(Mediator mediator) {
		super();
		this.mediator = mediator;
		this.mediator.addColleague(this);
	}
	
	public void saleOffer(String stock, int shares)
	{
		mediator.saleOffer(stock, shares, this.colleagecode);
	}
	
	public void buyOffer(String stock, int shares)
	{
		mediator.saleOffer(stock, shares, this.colleagecode);
	}

	public int getColleagecode() {
		return colleagecode;
	}

	public void setColleagecode(int colleagecode) {
		this.colleagecode = colleagecode;
	}	
}
