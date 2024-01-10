package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import java.util.List;

public interface IStockFilterService {
	List<TemporaryDTO> filter(String query);
	List<CriteriaTypeDTO> getListCriteria();
}