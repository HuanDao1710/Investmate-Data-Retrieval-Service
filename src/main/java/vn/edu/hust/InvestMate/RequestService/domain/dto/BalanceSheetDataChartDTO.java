package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceSheetDataChartDTO {
	private int yearly;
	private int quarter;
	private int year;
	private Double shortAsset;
	private Double longAsset;
}
