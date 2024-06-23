package vn.edu.hust.InvestMate.RequestService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.edu.hust.InvestMate.RequestService.constant.FilterBody;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FilterDTO;
import vn.edu.hust.InvestMate.RequestService.service.IStockFilterService;
import vn.edu.hust.InvestMate.RequestService.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/stock_filter")
public class StockFilterController {
	private final IStockFilterService stockFilterService;
	@PostMapping("/filter")
	public List<FilterDTO> getTopTemporary(@RequestBody FilterBody body) {
		String exchange = body.getExchange();
		String industry = body.getIndustry();
		var conditions = body.getConditions();

		String baseQuery = "SELECT tp, sf from TemporaryEntity tp INNER JOIN StockFilterEntity sf " +
				"ON tp.companyEntity = sf.companyEntity";
		StringBuilder stringBuilder = new StringBuilder(baseQuery);
		if(Objects.equals(exchange, "") && Objects.equals(industry, "") && conditions.isEmpty()) {
			return stockFilterService.filter(stringBuilder.toString());
		}
		stringBuilder.append(" WHERE ");
		List<String> where = new ArrayList<>();
		if(!Objects.equals(exchange, "")) where.add("sf.exchange = " + "'" + exchange + "'");
		if(!Objects.equals(industry, "")) where.add("sf.industry = " + "'" + industry + "'");
		if(!conditions.isEmpty()) where.add(CommonUtils.buildConditionsJPA(conditions));
		var query = stringBuilder.append(String.join(" AND ", where)).toString();
		 return stockFilterService.filter(query);
	}


	@GetMapping("/list_criteria")
	public List<CriteriaTypeDTO> getListCriteria() {
		return stockFilterService.getListCriteria();
	}
}
