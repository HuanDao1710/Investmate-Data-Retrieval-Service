package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.BalanceSheetDataChartDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.BalanceSheetEntity;

@Component
public class BalanceSheetMapper {
	public BalanceSheetDataChartDTO toDataChartDTO(BalanceSheetEntity entity) {
		BalanceSheetDataChartDTO dto = new BalanceSheetDataChartDTO();
		dto.setLongAsset(entity.getLongAsset());
		dto.setShortAsset(entity.getShortAsset());
		dto.setYearly(entity.getYearly());
		dto.setQuarter(entity.getQuarter());
		dto.setYear(entity.getYear());
		return dto;
	}
}
