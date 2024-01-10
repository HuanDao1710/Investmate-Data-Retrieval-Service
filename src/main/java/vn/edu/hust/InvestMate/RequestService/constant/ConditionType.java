package vn.edu.hust.InvestMate.RequestService.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionType {
	private String value;
	private double from;
	private double to;
}
