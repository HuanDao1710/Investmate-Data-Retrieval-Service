package vn.edu.hust.InvestMate.RequestService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.hust.InvestMate.RequestService.domain.dto.*;
import vn.edu.hust.InvestMate.RequestService.service.IStockDetailService;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/invest_mate/api/stock_detail")
public class StockDetailController {

	private final IStockDetailService stockDetailService;

	@GetMapping("/overview_info")
	public CompanyOverviewDTO getOverviewInfo(@RequestParam(name = "code") String code) {
		return stockDetailService.getOverviewInfo(code);
	}

	@GetMapping("/financial_ration_info")
	public FinancialRatioDTO getFinancialRatioInfo(@RequestParam(name = "code") String code){
		return stockDetailService.getFinancialRatioInfo(code);
	}

	@GetMapping("/large_share_holder")
	public List<LargeShareHolderDTO> getListLargeShareHolder(@RequestParam(name ="code") String code) {
		return stockDetailService.getListLargeShareHolder(code);
	}

	@GetMapping("/income_statement_data")
	public List<IncomeStatementDataChartDTO> getIncomeStatementChartData(@RequestParam(name = "code") String code) {
		return stockDetailService.getIncomeStatementChartData(code);
	}
	@GetMapping("/balance_sheet_data")
	public List<BalanceSheetDataChartDTO> getBalanceChartData(@RequestParam(name = "code") String code) {
		return stockDetailService.getBalanceSheetChartData(code);

	}

	@GetMapping("/cash_flow_data")
	public List<CashFlowDataChartDTO> getCashFlowData(@RequestParam(name = "code") String code) {
		return stockDetailService.getCashFlowChartData(code);

	}

	@GetMapping("/financial_data")
	public List<FinancialRatioChartDataDTO> getFinancialData(@RequestParam(name = "code") String code) {
		return stockDetailService.getFinancialChartData(code);
	}
}
