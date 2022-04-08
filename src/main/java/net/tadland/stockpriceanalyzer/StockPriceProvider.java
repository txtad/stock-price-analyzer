package net.tadland.stockpriceanalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import lombok.SneakyThrows;

public class StockPriceProvider {

	private StockPriceProvider() {}

	@SneakyThrows
	public static List<StockPrice> getPrices() {
		List<StockPrice> rc = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("data/aws-2021-price-data.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("Date")) continue;
				String[] values = line.split(",");
				rc.add(new StockPrice(values));
			}
		}
		return rc;
	}
}
