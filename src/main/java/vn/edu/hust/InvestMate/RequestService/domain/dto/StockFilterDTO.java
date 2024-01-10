package vn.edu.hust.InvestMate.RequestService.domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockFilterDTO {
	private Integer eps;
	private Double epsGrowth1Year;
	private Double lastQuarterProfitGrowth;
	private Double roe;
	private Double priceNearRealtime;
//	private Double beta;
	private Double grossMargin;
//	private Double netMargin;
	private Double doe;
	private Double pe;
	private Double pb;
	private Double evEbitda;
	private String code;
	private Double percentChangeDay;
	private Double percentChangeWeek;
	private Double percentChangeMonth;
	private Double marketCap;
	private Double avgTradingValue20Day;
	private Double asset;
	private double smg;
}
