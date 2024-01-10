package vn.edu.hust.InvestMate.RequestService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.edu.hust.InvestMate.RequestService.constant.ConditionType;
import vn.edu.hust.InvestMate.RequestService.constant.FilterBody;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.StockFilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.service.IStockFilterService;
import vn.edu.hust.InvestMate.RequestService.service.impl.StockFilterService;
import vn.edu.hust.InvestMate.RequestService.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/stock_filter")
public class StockFilterController {
	private final IStockFilterService stockFilterService;
	@PostMapping("/filter")
	public List<TemporaryDTO> getTopTemporary(@RequestBody FilterBody body) {
		String exchange = body.getExchange();
		String industry = body.getIndustry();
		var conditions = body.getConditions();

		String baseQuery = "SELECT tp, sf from TemporaryEntity tp INNER JOIN StockFilterEntity sf " +
				"ON tp.companyEntity = sf.companyEntity";
		StringBuilder stringBuilder = new StringBuilder(baseQuery);
		if(exchange == "" && industry == "" && conditions.isEmpty()) {
			return stockFilterService.filter(stringBuilder.toString());
		}
		stringBuilder.append(" WHERE ");
		List<String> where = new ArrayList<>();
		if(exchange != "") where.add("sf.exchange = " + "'" + exchange + "'");
		if(industry != "") where.add("sf.industry = " + "'" + industry + "'");
		if(!conditions.isEmpty()) where.add(CommonUtils.buildConditionsJPA(conditions));
		 String query = stringBuilder.append(where.stream().collect(Collectors.joining(" AND "))).toString();
		 return stockFilterService.filter(query);
	}


	@GetMapping("/list_criteria")
	public List<CriteriaTypeDTO> getListCriteria() {
		return stockFilterService.getListCriteria();
	}
}
