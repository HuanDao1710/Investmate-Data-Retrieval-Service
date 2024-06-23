package vn.edu.hust.InvestMate.RequestService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.*;
import vn.edu.hust.InvestMate.RequestService.domain.entity.*;
import vn.edu.hust.InvestMate.RequestService.mapper.*;
import vn.edu.hust.InvestMate.RequestService.repository.*;
import vn.edu.hust.InvestMate.RequestService.service.IStockDetailService;
import vn.edu.hust.InvestMate.RequestService.utils.TimeUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockDetailService implements IStockDetailService {
	private final CompanyOverviewRepository companyOverviewRepository;
	private final CompanyRepository companyRepository;
	private final OverviewInfoMapper overviewInfoMapper;
	private final FinancialRatioRepository financialRatioRepository;
	private final FinancialRatioMapper financialRatioMapper;
	private final LargeShareHolderRepository largeShareHolderRepository;
	private final LargeShareHolderMapper largeShareHolderMapper;
	private final IncomeStatementRepository incomeStatementRepository;
	private final IncomeStatementMapper incomeStatementMapper;
	private final BalanceSheetRepository balanceSheetRepository;
	private final BalanceSheetMapper balanceSheetMapper;
	private final CashFlowRepository cashFlowRepository;
	private final CashFlowMapper cashFlowMapper;

	@Override
	public CompanyOverviewDTO getOverviewInfo(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		CompanyOverviewEntity companyOverview = companyOverviewRepository.findOneByCompanyEntity(companyEntity);
		return overviewInfoMapper.toDTO(companyEntity, companyOverview);
	}

	@Override
	public FinancialRatioDTO getFinancialRatioInfo(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		var entities = financialRatioRepository.findTopByYearlyOrderByYearDescQuarterDesc(companyEntity);
		//Exception handle
		if(entities.size() < 1) return null;
		return financialRatioMapper.toDTO(companyEntity, entities.get(0));
	}

	@Override
	public List<LargeShareHolderDTO> getListLargeShareHolder(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		return largeShareHolderRepository
				.findAllByCompanyEntity(companyEntity).stream()
				.map(e -> largeShareHolderMapper.toDTO(e, companyEntity))
				.toList();
	}

	@Override
	public List<CashFlowDataChartDTO> getCashFlowChartData(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		var results =
				cashFlowRepository
						.findData(companyEntity, TimeUtils.getCurrentYear() - 5);
		return results
				.stream()
				.map(obj ->
					cashFlowMapper.toChartDataDTO((CashFlowEntity) obj[0], (Double) obj[1])
				).toList();
	}

	@Override
	public List<FinancialRatioChartDataDTO> getFinancialChartData(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		List<FinancialRatioEntity> entityList =
				financialRatioRepository
						.findAllByCompanyEntityAndYear(companyEntity, TimeUtils.getCurrentYear() - 5);
		return entityList
				.stream()
				.map(financialRatioMapper::toChartDataDTO).toList();
	}

	@Override
	public List<BalanceSheetDataChartDTO> getBalanceSheetChartData(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		List<BalanceSheetEntity> entityList =
				balanceSheetRepository
						.findAllByCompanyEntityAndYear(companyEntity, TimeUtils.getCurrentYear() - 5);
		return entityList
				.stream()
				.map(balanceSheetMapper::toDataChartDTO).toList();
	}

	@Override
	public List<IncomeStatementDataChartDTO> getIncomeStatementChartData(String code) {
		CompanyEntity companyEntity = companyRepository.findOneByCode(code);
		List<IncomeStatementEntity> entityList =
				incomeStatementRepository
				.findAllByCompanyEntityAndYear(companyEntity, TimeUtils.getCurrentYear() - 5);
		return entityList
				.stream()
				.map(incomeStatementMapper::toDataChartDTO).toList();
	}
}
