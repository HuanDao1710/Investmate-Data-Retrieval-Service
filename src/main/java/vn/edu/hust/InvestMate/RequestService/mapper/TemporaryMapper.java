package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.SearchDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;


@Component
public class TemporaryMapper {
	public TemporaryDTO toDTO(TemporaryEntity entity) {
		TemporaryDTO temp = new TemporaryDTO();
		temp.setId(entity.getId());
		temp.setPrice(entity.getPrice());
		temp.setRsRaw(entity.getRsRaw());
		temp.setSmg(entity.getSmg());
		temp.setPricePreference(entity.getPricePreference());
		temp.setPriceChange(entity.getPriceChange());
		temp.setPercentChangeDay(entity.getPercentChangeDay());
		temp.setPercentChangeWeek(entity.getPercentChangeWeek());
		temp.setPercentChangeMonth(entity.getPercentChangeMonth());
		temp.setUpdateTime(entity.getUpdateTime());
		temp.setTimeSeries(entity.getTimeSeries());
		temp.setCode(entity.getCompanyEntity().getCode());
		temp.setExchange(entity.getCompanyEntity().getExchange());
		temp.setShortName(entity.getCompanyEntity().getFullNameVi());
		return temp;
	}
}
