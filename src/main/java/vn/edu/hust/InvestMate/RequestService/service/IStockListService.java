package vn.edu.hust.InvestMate.RequestService.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CompanyOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FinancialRatioDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndustryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;

import java.util.List;

public interface IStockListService {
	List<IndustryDTO> getListIndustry();
	Page<TemporaryDTO> getListStock(String industry, Pageable pageable);
}
