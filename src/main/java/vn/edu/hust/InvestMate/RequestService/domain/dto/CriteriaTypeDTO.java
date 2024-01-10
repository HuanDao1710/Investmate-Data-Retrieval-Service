package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CriteriaTypeDTO {
	private String name;
	private String key;
	private double minValue;
	private double maxValue;
	private double currentMinValue;
	private double currentMaxValue;

	public CriteriaTypeDTO setName(String name){
		this.name = name;
		return this;
	}
	public CriteriaTypeDTO setIKey(String iKey){
		this.key = iKey;
		return this;
	}
	public CriteriaTypeDTO setMinValue(double minValue){
		this.minValue = Math.floor(minValue);
		this.currentMinValue = Math.floor(minValue);
		return this;
	}
	public CriteriaTypeDTO setMaxValue(double maxValue){
		this.maxValue = Math.ceil(maxValue);
		this.currentMaxValue = Math.ceil(maxValue);
		return this;
	}
}
