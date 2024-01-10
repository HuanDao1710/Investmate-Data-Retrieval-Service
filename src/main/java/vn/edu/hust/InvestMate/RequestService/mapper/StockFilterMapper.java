package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.StockFilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.StockFilterEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;

@Component
public class StockFilterMapper {
	public StockFilterDTO stockFilterDTO(TemporaryEntity temporaryEntity, StockFilterEntity stockFilterEntity) {
		StockFilterDTO dto = new StockFilterDTO();
		return dto;
	}
}
