package vn.edu.hust.InvestMate.RequestService.domain.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockFilterDTO {
	private String industry;
	private String exchange;
	private int eps;
	private Double epsGrowth1Year;
	private Double lastQuarterProfitGrowth;
	private Double roe;
	private Double grossMargin;
	private Double doe; // lastquarter
	private Double pe; // lastquarter
	private Double pb; // lastquarter
	private Double asset; // lastquarter
	private Double evEbitda; // lastquarter
	private Double postTaxProfitYear;
	private Double postTaxProfitQuarter;
	private Double epsTtm; //
	private Double lastQuarterTradingValue;
	private Double revenueLastQuarterGrowth;
	private Double revenueGrowthLastYear;//
	private Double revenueTtm; //
	private Double revenueLastYear; //
	private Double lastYearPostTaxProfit; //
	private Double lastYearCashFlowFromFinancial;
	private Double lastYearCashFlowFromSale;
	private Double lastYearFreeCashFlow;
	private String code;
}
