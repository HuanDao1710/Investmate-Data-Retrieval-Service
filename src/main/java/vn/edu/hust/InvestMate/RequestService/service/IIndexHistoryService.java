package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexHistoryEntity;

import java.util.List;

public interface IIndexHistoryService {
	List<IndexHistoryEntity> getHistoryBetween(String code);
}
