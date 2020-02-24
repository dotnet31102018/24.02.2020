
public class Main {

	public static void main(String[] args) {
		
		StockMediator bursa = new StockMediator();
		
		TadiranSlacks tadiranColleague = new TadiranSlacks(bursa);
		
		TLVSlacks tlvColleague = new TLVSlacks(bursa);
		
		tadiranColleague.saleOffer("MS", 100);
		tadiranColleague.saleOffer("GOOGLE", 57);
		
		bursa.presentAllOffers();
		
		tlvColleague.buyOffer("MS", 100);
		
		bursa.presentAllOffers();
		
		tlvColleague.buyOffer("APPLE", 1000);
		
		bursa.presentAllOffers();

	}

}
