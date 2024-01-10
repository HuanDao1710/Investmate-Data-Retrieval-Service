package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.dto.IndexHistoryOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.SearchDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.repository.IndexHistoryRepository;

import java.util.List;

public interface IHomeService {
	IndexHistoryOverviewDTO getOverViewIndex(String code);

	List<TemporaryDTO> getTop10Temporary();

	List<SearchDTO> searchStock(String keyword);

	TemporaryDTO getTemporaryByCode(String code);
}
