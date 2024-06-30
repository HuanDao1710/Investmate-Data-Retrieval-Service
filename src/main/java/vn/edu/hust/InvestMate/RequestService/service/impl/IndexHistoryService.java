package vn.edu.hust.InvestMate.RequestService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexHistoryEntity;
import vn.edu.hust.InvestMate.RequestService.repository.IndexHistoryRepository;
import vn.edu.hust.InvestMate.RequestService.repository.IndexRepository;
import vn.edu.hust.InvestMate.RequestService.service.IIndexHistoryService;
import vn.edu.hust.InvestMate.RequestService.utils.TimeUtils;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexHistoryService implements IIndexHistoryService {
	private final IndexHistoryRepository indexHistoryRepository;
	private final IndexRepository indexRepository;
	@Override
	public List<IndexHistoryEntity> getHistoryBetween(String code) {
		var IndexEntity = indexRepository.findOneByComGroupCode(code);
		return indexHistoryRepository.findByIndexEntityAndTimeBetweenOrderByTimeAsc(IndexEntity, TimeUtils.getStartOfDay(), TimeUtils.getEndOfDay());
	}
}
