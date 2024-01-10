package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialRatioChartDataDTO {
	private int yearly;
	private int quarter;
	private int year;
	private Integer earningPerShare;
	private Double epsChange;
}
