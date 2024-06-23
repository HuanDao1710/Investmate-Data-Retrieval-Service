package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;

import java.util.List;

public interface IWatchlistService {
	List<TemporaryDTO> getListStockByListCode(List<String> listCode);

}
