package vn.edu.hust.InvestMate.RequestService.domain.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashFlowDataChartDTO {
	private String ticker;
	private Integer yearly;
	private Double cash;
	private Integer quarter;
	private Integer year;
	private Double investCost;
	private Double fromInvest;
	private Double fromFinancial;
	private Double fromSale;
	private Double freeCashFlow;
}
