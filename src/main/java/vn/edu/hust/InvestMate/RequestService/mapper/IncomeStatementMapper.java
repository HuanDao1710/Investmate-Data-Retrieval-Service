package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IncomeStatementDataChartDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IncomeStatementEntity;

@Component
public class IncomeStatementMapper {
	public IncomeStatementDataChartDTO toDataChartDTO(IncomeStatementEntity incomeStatementEntity) {
		var dto = new IncomeStatementDataChartDTO();
		dto.setRevenue(incomeStatementEntity.getRevenue());
		dto.setYear(incomeStatementEntity.getYear());
		dto.setQuarter(incomeStatementEntity.getQuarter());
		dto.setQuarterRevenueGrowth(incomeStatementEntity.getQuarterRevenueGrowth());
		dto.setYearRevenueGrowth(incomeStatementEntity.getYearRevenueGrowth());
		dto.setYearly(incomeStatementEntity.getYearly());
		dto.setPostTaxProfit(incomeStatementEntity.getPostTaxProfit());
		dto.setPreTaxProfit(incomeStatementEntity.getPreTaxProfit());
		dto.setShareHolderIncome(incomeStatementEntity.getShareHolderIncome());
		dto.setQuarterShareHolderIncomeGrowth(incomeStatementEntity.getQuarterShareHolderIncomeGrowth());
		dto.setYearShareHolderIncomeGrowth(incomeStatementEntity.getYearShareHolderIncomeGrowth());
		return dto;
	}
}
