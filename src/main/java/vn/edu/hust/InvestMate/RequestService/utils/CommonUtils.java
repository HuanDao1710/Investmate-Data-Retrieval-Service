package vn.edu.hust.InvestMate.RequestService.utils;

import org.springframework.data.domain.Sort;
import vn.edu.hust.InvestMate.RequestService.constant.ConditionType;
import vn.edu.hust.InvestMate.RequestService.constant.SortType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommonUtils {
	public static Sort mapSortTypeToSortDomain(String sortType) {
		if(Objects.equals(sortType, SortType.HIGHEST_RS)) {
			return Sort.by("smg").descending();
		} else if(Objects.equals(sortType, SortType.LOWEST_RS)) {
			return Sort.by("smg").ascending();
		} else if (Objects.equals(sortType, SortType.STRONGEST_POINT_INCREASE)) {
			return Sort.by("percentChangeMonth").descending();
		} else if(Objects.equals(sortType, SortType.STRONGEST_POINT_REDUCTION)) {
			return Sort.by("percentChangeMonth").ascending();
		}
		return Sort.by("smg").descending();
	}


	public static String stringToConditionJPA(ConditionType condition) {
		return  condition.getValue() + " BETWEEN " + condition.getFrom() + " AND " + condition.getTo();
	}

	public static String buildConditionsJPA(List<ConditionType> conditions) {
		return  conditions.stream().map(CommonUtils::stringToConditionJPA).collect(Collectors.joining(" AND "));
	}
}
