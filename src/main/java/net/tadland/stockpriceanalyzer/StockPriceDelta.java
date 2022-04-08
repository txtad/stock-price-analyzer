package net.tadland.stockpriceanalyzer;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class StockPriceDelta implements Comparable<StockPriceDelta> {

	@Getter
	@Setter
	private StockPrice buy;
	@Getter
	@Setter
	private StockPrice sell;
	@Getter
	@Setter
	private BigDecimal delta;

	public StockPriceDelta(StockPrice buy, StockPrice sell) {
		this.buy   = buy;
		this.sell  = sell;
		this.delta = sell.getPrice().subtract(buy.getPrice());
	}

	@Override
	public int compareTo(StockPriceDelta o) {
		return delta.compareTo(o.delta);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof StockPriceDelta))
			return false;
		StockPriceDelta other = (StockPriceDelta) o;
		return delta.equals(other.delta);
	}

	@Override
	public int hashCode() {
		return delta.hashCode();
	}
}
