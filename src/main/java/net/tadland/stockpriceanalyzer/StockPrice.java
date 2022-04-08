package net.tadland.stockpriceanalyzer;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class StockPrice {
	private Date       closingDate;
	private BigDecimal price;

	private static final FastDateFormat DATE_FORMAT      = FastDateFormat.getInstance("MM/dd/yyyy HH:mm:ss");
	private static final FastDateFormat DATE_ONLY_FORMAT = FastDateFormat.getInstance("MM/dd/yyyy");

	@SneakyThrows
	public StockPrice(String[] data) {
		if (data == null || data.length != 2) throw new RuntimeException("I need a two element array.");
		String closingDateStr = data[0];
		String priceStr       = data[1];
		closingDate = DATE_FORMAT.parse(closingDateStr);
		price       = new BigDecimal(priceStr);
	}

	public String getDate() {
		return DATE_ONLY_FORMAT.format(closingDate);
	}
}
