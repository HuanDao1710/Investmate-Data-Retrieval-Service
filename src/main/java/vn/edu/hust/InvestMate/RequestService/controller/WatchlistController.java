package vn.edu.hust.InvestMate.RequestService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vn.edu.hust.InvestMate.RequestService.constant.WatchListBody;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.service.IWatchlistService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/watchlist")
public class WatchlistController {
	private final IWatchlistService watchlistService;

	@PostMapping("/list_stock_watchlist")
	public List<TemporaryDTO> getListStockInfo(@RequestBody WatchListBody body) {
		return watchlistService.getListStockByListCode(body.getListCode());
	}


}
