package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
	String code;
	String name;
	String exchange;
}
