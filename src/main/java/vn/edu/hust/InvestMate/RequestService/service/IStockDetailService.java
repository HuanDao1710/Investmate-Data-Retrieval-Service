package vn.edu.hust.InvestMate.RequestService.service;

import vn.edu.hust.InvestMate.RequestService.domain.dto.*;

import java.util.List;

public interface IStockDetailService {
	CompanyOverviewDTO getOverviewInfo(String code);
	FinancialRatioDTO getFinancialRatioInfo(String code);
	List<LargeShareHolderDTO> getListLargeShareHolder(String code);
	List<IncomeStatementDataChartDTO> getIncomeStatementChartData(String code);
	List<CashFlowDataChartDTO> getCashFlowChartData(String code);
	List<FinancialRatioChartDataDTO> getFinancialChartData(String code);
	List<BalanceSheetDataChartDTO> getBalanceSheetChartData(String code);
}
