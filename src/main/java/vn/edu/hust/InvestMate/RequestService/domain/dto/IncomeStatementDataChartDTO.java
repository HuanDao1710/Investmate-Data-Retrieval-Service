package vn.edu.hust.InvestMate.RequestService.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatementDataChartDTO {
	private Double revenue;
	private Double yearRevenueGrowth;
	private Double quarterRevenueGrowth;
	private Double yearShareHolderIncomeGrowth;
	private Double quarterShareHolderIncomeGrowth;
	private Double shareHolderIncome;
	private Double preTaxProfit;
	private Double postTaxProfit;
	private Integer quarter;
	private Integer year;
	private Integer yearly;
}
