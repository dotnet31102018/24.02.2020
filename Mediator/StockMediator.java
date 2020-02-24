import java.util.ArrayList;
import java.util.List;

public class StockMediator implements Mediator {

	private int colleagueCode = 0;
	
	private List<Colleague> colleagues;
	private List<StockOffer> stockBuyOffers;
	private List<StockOffer> stockSellOffers;
	
	public StockMediator() {
		super();
		this.colleagues = new ArrayList<Colleague>();
		this.stockBuyOffers = new ArrayList<StockOffer>();
		this.stockSellOffers = new ArrayList<StockOffer>();
	}
	
	@Override
	public void addColleague(Colleague colleage) {
		colleagues.add(colleage);
		colleage.setColleagecode(++colleagueCode);
	}

	@Override
	public void saleOffer(String stock, int shares, int collCode) {

		StockOffer offertoRemove = null;
		
		for(StockOffer offer : stockBuyOffers)
		{
			if (offer.getStockShares() == shares && offer.getStockSymbol().contentEquals(stock)) {
				System.out.println(shares + " shares of " + stock +
						" sold to colleague code " + offer.getColleagueCode());
				offertoRemove = offer;
				break;
			}
		}
		
		if (offertoRemove != null)
		{
			stockBuyOffers.remove(offertoRemove);
		}
		else
		{
			System.out.println("adding offer to buy stock " + shares + " shares of " + stock + collCode);
			stockBuyOffers.add(new StockOffer(shares, stock, collCode));
		}
		
	}

	@Override
	public void buyOffer(String stock, int shares, int collCode) {
	StockOffer offertoRemove = null;
		
		for(StockOffer offer : stockSellOffers)
		{
			if (offer.getStockShares() == shares && offer.getStockSymbol().contentEquals(stock)) {
				System.out.println(shares + " shares of " + stock +
						" buy to colleague code " + offer.getColleagueCode());
				offertoRemove = offer;
				break;
			}
		}
		
		if (offertoRemove != null)
		{
			stockSellOffers.remove(offertoRemove);
		}
		else
		{
			System.out.println("adding offer to sell stock " + shares + " shares of " + stock + collCode);
			stockBuyOffers.add(new StockOffer(shares, stock, collCode));
		}
		
	}
	
	public void presentAllOffers()
	{
		System.out.println("\nStock offers:");
		
		System.out.println("=================== selling:");
		for(StockOffer offer : stockSellOffers)
		{
			
			System.out.println(offer);
		}
		System.out.println("=================== buying:");
		for(StockOffer offer : stockBuyOffers)
		{
			System.out.println(offer);
		}
	}



}
