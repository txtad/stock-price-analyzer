package net.tadland.stockpriceanalyzer;

import java.util.TreeSet;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StockPriceAnalyzer {

	public static void main(String[] args) {
		var spa = new StockPriceAnalyzer();
		spa.doit();
	}

	private void doit() {
		var prices  = StockPriceProvider.getPrices();
		var buySell = new TreeSet<StockPriceDelta>();

		for (int buy = 0; buy < prices.size(); buy++) {
			StockPrice buyPrice = prices.get(buy);
			for (int sell = buy + 1; sell < prices.size(); sell++) {
				StockPrice sellPrice = prices.get(sell);
				buySell.add(new StockPriceDelta(buyPrice, sellPrice));
			}
		}

		log.info("Analyzed {} buy/sell date pairs.", buySell.size());
		StockPriceDelta bestDelta = buySell.last();
		log.info("The best buy/sell closing dates for the period of {} to {}",
			prices.get(0).getDate(), prices.get(prices.size() - 1).getDate());
		log.info("are to buy on {} at ${} then sell on {} at ${}",
			bestDelta.getBuy().getDate(), bestDelta.getBuy().getPrice(), bestDelta.getSell().getDate(), bestDelta.getSell().getPrice());
		log.info("for a gain of ${}.", bestDelta.getDelta());
	}
}
