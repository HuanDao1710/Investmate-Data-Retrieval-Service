package vn.edu.hust.InvestMate.RequestService.constant;

import lombok.Getter;

import java.util.List;

@Getter
public class FilterBody {
	List<ConditionType> conditions;
	String exchange;;
	String industry;
}
