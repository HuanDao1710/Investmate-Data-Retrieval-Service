package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CompanyOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyOverviewEntity;

@Component
public class OverviewInfoMapper {
	public CompanyOverviewDTO toDTO(CompanyEntity companyEntity, CompanyOverviewEntity companyOverviewEntity) {
		CompanyOverviewDTO dto = new CompanyOverviewDTO();
		dto.setCode(companyEntity.getCode());
		dto.setExchange(companyEntity.getExchange());
		dto.setShortName(companyOverviewEntity.getShortName());
		dto.setCompanyName(companyOverviewEntity.getCompanyName());
		dto.setIndustry(companyOverviewEntity.getIndustry());
		dto.setIndustryEn(companyOverviewEntity.getIndustryEn());
		dto.setEstablishedYear(companyOverviewEntity.getEstablishedYear());
		dto.setNoEmployees(companyOverviewEntity.getNoEmployees());
		dto.setNoShareholders(companyOverviewEntity.getNoShareholders());
		dto.setForeignPercent(companyOverviewEntity.getForeignPercent());
		dto.setWebsite(companyOverviewEntity.getWebsite());
		dto.setOutstandingShare(companyOverviewEntity.getOutstandingShare());
		dto.setIssueShare(companyOverviewEntity.getIssueShare());
		dto.setCompanyProfile(companyOverviewEntity.getCompanyProfile());
		dto.setCompanyType(companyOverviewEntity.getCompanyType());
		dto.setBusinessType(companyEntity.getBusinessType());
		dto.setHistoryDev(companyOverviewEntity.getHistoryDev());
		dto.setCompanyPromise(companyOverviewEntity.getCompanyPromise());
		dto.setBusinessRisk(companyOverviewEntity.getBusinessRisk());
		dto.setKeyDevelopments(companyOverviewEntity.getKeyDevelopments());
		dto.setBusinessStrategies(companyOverviewEntity.getBusinessStrategies());
		return dto;
	}
}
