package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemporaryDTO implements Serializable {
	private Long id;
	private double price;
	private double rsRaw;
	private double smg;
	private String exchange;
	private double pricePreference;
	private double priceChange;
	private double percentChangeDay;
	private double percentChangeWeek;
	private double percentChangeMonth;
	private Long updateTime;
	private List<Double> timeSeries;
	private String code;
	private String shortName;
	private String fullName;
	private Double marketCap;
	private Double avgTradingValue20Day;
	private Double volume;
	private Double dailyTradingValue;

}
