package vn.edu.hust.InvestMate.RequestService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.InvestMate.RequestService.constant.SortType;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CompanyOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FinancialRatioDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndustryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.service.IStockDetailService;
import vn.edu.hust.InvestMate.RequestService.service.IStockListService;
import vn.edu.hust.InvestMate.RequestService.utils.CommonUtils;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/stock_list")
public class StockListController {
	private final IStockListService stockListService;
	private final RedisTemplate redisTemplate;

	@GetMapping("/list_industry")
	List<IndustryDTO> getListIndustry(){
		String key = "ListIndustry";
		List<IndustryDTO> results = redisTemplate.opsForList().range(key, 0, - 1);
		if(results == null || results.isEmpty()) {
			var re = stockListService.getListIndustry();
			redisTemplate.opsForList().rightPushAll(key, re);
			return re;
		}
		return  results;
	}

//	@Cacheable(value = "ListStock", key = "#industry + #sortBy + #page + #size")
	@GetMapping("/list_stock")
	public Page<TemporaryDTO> getListStock(
			@RequestParam(name = "industry") String industry,
			@RequestParam(name = "sortBy", defaultValue = SortType.HIGHEST_RS) String sortBy,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {

//		String key = "industry:" + industry + "|" + "sortBy:" + sortBy + "|" + "page:" + page + "|" +"size:" + size;
//		Object results =  redisTemplate.opsForValue().get(key);
//		if(results == null) {
//			Pageable pageable = PageRequest.of(page, size, CommonUtils.mapSortTypeToSortDomain(sortBy));
//			var re=  stockListService.getListStock(industry, pageable);
//			redisTemplate.opsForValue().set(key, re);
//			return re;
//		}
			Pageable pageable = PageRequest.of(page, size, CommonUtils.mapSortTypeToSortDomain(sortBy));
			return stockListService.getListStock(industry, pageable);
	}

}
