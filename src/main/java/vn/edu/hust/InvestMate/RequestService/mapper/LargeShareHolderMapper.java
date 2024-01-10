package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.LargeShareHolderDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.LargeShareHolderEntity;

@Component
public class LargeShareHolderMapper {
	public LargeShareHolderDTO toDTO (LargeShareHolderEntity entity, CompanyEntity companyEntity) {
		LargeShareHolderDTO dto = new LargeShareHolderDTO();
		dto.setCode(companyEntity.getCode());
		dto.setNo(entity.getNo());
		dto.setName(entity.getName());
		dto.setTicker(entity.getTicker());
		dto.setOwnPercent(entity.getOwnPercent());
		return dto;
	}
}
