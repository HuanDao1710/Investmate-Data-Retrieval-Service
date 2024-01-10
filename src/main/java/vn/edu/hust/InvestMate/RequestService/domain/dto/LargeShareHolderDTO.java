package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LargeShareHolderDTO {
	private int no;
	private String ticker;
	private String name;
	private double ownPercent;
	private String code;
}
