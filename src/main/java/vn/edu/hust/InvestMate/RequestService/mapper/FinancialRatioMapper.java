package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FinancialRatioChartDataDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FinancialRatioDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.FinancialRatioEntity;

@Component
public class FinancialRatioMapper {
	public FinancialRatioDTO toDTO (CompanyEntity companyEntity, FinancialRatioEntity financialRatioEntity){
		FinancialRatioDTO dto = new FinancialRatioDTO();
		dto.setCode((companyEntity.getCode()));
		dto.setYearly(financialRatioEntity.getYearly());
		dto.setTicker(financialRatioEntity.getTicker());
		dto.setQuarter(financialRatioEntity.getQuarter());
		dto.setYear(financialRatioEntity.getYear());
		dto.setPriceToEarning(financialRatioEntity.getPriceToEarning());
		dto.setPriceToBook(financialRatioEntity.getPriceToBook());
		dto.setValueBeforeEbitda(financialRatioEntity.getValueBeforeEbitda());
		dto.setDividend(financialRatioEntity.getDividend());
		dto.setRoe(financialRatioEntity.getRoe());
		dto.setRoa(financialRatioEntity.getRoa());
		dto.setDaysReceivable(financialRatioEntity.getDaysReceivable());
		dto.setDaysInventory(financialRatioEntity.getDaysInventory());
		dto.setDaysPayable(financialRatioEntity.getDaysPayable());
		dto.setEbitOnInterest(financialRatioEntity.getEbitOnInterest());
		dto.setEarningPerShare(financialRatioEntity.getEarningPerShare());
		dto.setBookValuePerShare(financialRatioEntity.getBookValuePerShare());
		dto.setInterestMargin(financialRatioEntity.getInterestMargin());
		dto.setNonInterestOnToi(financialRatioEntity.getNonInterestOnToi());
		dto.setBadDebtPercentage(financialRatioEntity.getBadDebtPercentage());
		dto.setProvisionOnBadDebt(financialRatioEntity.getProvisionOnBadDebt());
		dto.setCostOfFinancing(financialRatioEntity.getCostOfFinancing());
		dto.setEquityOnTotalAsset(financialRatioEntity.getEquityOnTotalAsset());
		dto.setEquityOnLoan(financialRatioEntity.getEquityOnLoan());
		dto.setCostToIncome(financialRatioEntity.getCostToIncome());
		dto.setEquityOnLiability(financialRatioEntity.getEquityOnLiability());
		dto.setCurrentPayment(financialRatioEntity.getCurrentPayment());
		dto.setQuickPayment(financialRatioEntity.getQuickPayment());
		dto.setEpsChange(financialRatioEntity.getEpsChange());
		dto.setEbitdaOnStock(financialRatioEntity.getEbitdaOnStock());
		dto.setGrossProfitMargin(financialRatioEntity.getGrossProfitMargin());
		dto.setOperatingProfitMargin(financialRatioEntity.getOperatingProfitMargin());
		dto.setPostTaxMargin(financialRatioEntity.getPostTaxMargin());
		dto.setDebtOnEquity(financialRatioEntity.getDebtOnEquity());
		dto.setDebtOnAsset(financialRatioEntity.getDebtOnAsset());
		dto.setDebtOnEbitda(financialRatioEntity.getDebtOnEbitda());
		dto.setShortOnLongDebt(financialRatioEntity.getShortOnLongDebt());
		dto.setAssetOnEquity(financialRatioEntity.getAssetOnEquity());
		dto.setCapitalBalance(financialRatioEntity.getCapitalBalance());
		dto.setCashOnEquity(financialRatioEntity.getCashOnEquity());
		dto.setCashOnCapitalize(financialRatioEntity.getCashOnCapitalize());
		dto.setCashCirculation(financialRatioEntity.getCashCirculation());
		dto.setRevenueOnWorkCapital(financialRatioEntity.getRevenueOnWorkCapital());
		dto.setCapexOnFixedAsset(financialRatioEntity.getCapexOnFixedAsset());
		dto.setRevenueOnAsset(financialRatioEntity.getRevenueOnAsset());
		dto.setPostTaxOnPreTax(financialRatioEntity.getPostTaxOnPreTax());
		dto.setEbitOnRevenue(financialRatioEntity.getEbitOnRevenue());
		dto.setPreTaxOnEbit(financialRatioEntity.getPreTaxOnEbit());
		dto.setPreProvisionOnToi(financialRatioEntity.getPreProvisionOnToi());
		dto.setPostTaxOnToi(financialRatioEntity.getPostTaxOnToi());
		dto.setLoanOnEarnAsset(financialRatioEntity.getLoanOnEarnAsset());
		dto.setLoanOnAsset(financialRatioEntity.getLoanOnAsset());
		dto.setLoanOnDeposit(financialRatioEntity.getLoanOnDeposit());
		dto.setDepositOnEarnAsset(financialRatioEntity.getDepositOnEarnAsset());
		dto.setBadDebtOnAsset(financialRatioEntity.getBadDebtOnAsset());
		dto.setLiquidityOnLiability(financialRatioEntity.getLiquidityOnLiability());
		dto.setPayableOnEquity(financialRatioEntity.getPayableOnEquity());
		dto.setCancelDebt(financialRatioEntity.getCancelDebt());
		dto.setEbitdaOnStockChange(financialRatioEntity.getEbitdaOnStockChange());
		dto.setBookValuePerShareChange(financialRatioEntity.getBookValuePerShareChange());
		dto.setCreditGrowth(financialRatioEntity.getCreditGrowth());
		return dto;
	}


	public FinancialRatioChartDataDTO toChartDataDTO(FinancialRatioEntity entity) {
		FinancialRatioChartDataDTO dto = new FinancialRatioChartDataDTO();
		dto.setEarningPerShare(entity.getEarningPerShare());
		dto.setEpsChange(entity.getEpsChange());
		dto.setYearly(entity.getYearly());
		dto.setQuarter(entity.getQuarter());
		dto.setYear(entity.getYear());
		return dto;
	}
}
