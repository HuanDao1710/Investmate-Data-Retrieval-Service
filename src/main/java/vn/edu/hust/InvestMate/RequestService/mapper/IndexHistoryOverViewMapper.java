package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndexHistoryOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexHistoryEntity;

import java.util.List;

@Component
public class IndexHistoryOverViewMapper {
	public IndexHistoryOverviewDTO toDTO(List<IndexHistoryEntity> historyEntityList, IndexHistoryEntity before) {
		var dto = new IndexHistoryOverviewDTO();
		var lastEntity = historyEntityList.get(historyEntityList.size() - 1);
		dto.setName(lastEntity.getIndexEntity().getComGroupCode());
		dto.setPrice(lastEntity.getClose());
		long volume = 0;
		for (var e : historyEntityList) {
			volume += e.getVolume();
		}
		dto.setVolume(volume);
		dto.setUpdateTime(lastEntity.getTime());
		dto.setPreferencePrice(before.getClose());
		dto.setPriceTimeSeries(historyEntityList.stream().map(IndexHistoryEntity::getClose).toList());
		dto.setPriceChange(lastEntity.getClose() - before.getClose());
		return dto;
	}

}
