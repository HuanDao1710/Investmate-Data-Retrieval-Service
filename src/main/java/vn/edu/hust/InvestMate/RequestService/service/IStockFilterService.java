package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import java.util.List;

public interface IStockFilterService {
	List<FilterDTO> filter(String query);
	List<CriteriaTypeDTO> getListCriteria();
}