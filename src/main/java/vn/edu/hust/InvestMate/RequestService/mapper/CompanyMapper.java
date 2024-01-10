package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.SearchDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;

@Component
public class CompanyMapper {
	public SearchDTO toSearchDTO(CompanyEntity entity) {
		SearchDTO dto = new SearchDTO();
		dto.setCode(entity.getCode());
		dto.setExchange(entity.getExchange());
		dto.setName(entity.getFullNameVi());
		return dto;
	}

}
