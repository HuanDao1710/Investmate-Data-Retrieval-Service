package vn.edu.hust.InvestMate.RequestService.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import vn.edu.hust.InvestMate.RequestService.constant.IndexBody;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndexHistoryOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.SearchDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.service.IHomeService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/home")
public class HomeController {

	private final IHomeService homeService;
	@Autowired
	private final RedisTemplate redisTemplate;

	@GetMapping("/search")
	public List<SearchDTO> search(@RequestParam(name = "keyword") String keyword){
		return homeService.searchStock(keyword);
	}


	@PostMapping("/index")
	public List<IndexHistoryOverviewDTO> indexOverView(@RequestBody IndexBody indexes) {
//		String key = "KeyIndexOverView";
//		List<IndexHistoryOverviewDTO> results = redisTemplate.opsForList().range(key, 0, -1);
//		if(results == null || results.isEmpty()) {
//			var re = List.of(homeService.getOverViewIndex("VNINDEX"), homeService.getOverViewIndex("VN30"));
//			redisTemplate.opsForList().rightPushAll(key, re);
//			return re;
//		}
//		return results;
		return indexes.getIndexes().stream().map(homeService::getOverViewIndex).toList();
//		return List.of(homeService.getOverViewIndex("VNINDEX"), homeService.getOverViewIndex("VN30"));
	}

	@GetMapping("/top_smg")
	public List<TemporaryDTO> getTopTemporary() {
//		String key = "SKeyTopSMG";
//		List<TemporaryDTO> results = redisTemplate.opsForList().range(key, 0, - 1);
//		if(results == null || results.isEmpty()) {
//			var re = homeService.getTop10Temporary();
//			redisTemplate.opsForList().rightPushAll(key, re);
//			return re;
//		}
//		return results;
		return homeService.getTop10Temporary();
	}

	@GetMapping("/get_stock")
	public TemporaryDTO getStock(String code) {
		return homeService.getTemporaryByCode(code);
	}
}
