package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class IndexHistoryOverviewDTO implements Serializable {
	private String name;
	private String comGroupCode;
	private long updateTime;
	private List<Double> priceTimeSeries;
	private double preferencePrice;
	private double price;
	private double volume;
	private double transactionValue;
	private double priceChange;
}
