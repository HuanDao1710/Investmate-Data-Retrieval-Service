package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.StockFilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.StockFilterEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;

@Component
public class StockFilterMapper {
	public StockFilterDTO toDTO(StockFilterEntity stockFilterEntity) {
		StockFilterDTO dto = new StockFilterDTO();
		dto.setIndustry(stockFilterEntity.getIndustry());
		dto.setExchange(stockFilterEntity.getExchange());
		dto.setEps(stockFilterEntity.getEps());
		dto.setEpsGrowth1Year(stockFilterEntity.getEpsGrowth1Year());
		dto.setLastQuarterProfitGrowth(stockFilterEntity.getLastQuarterProfitGrowth());
		dto.setRoe(stockFilterEntity.getRoe());
		dto.setGrossMargin(stockFilterEntity.getGrossMargin());
		dto.setDoe(stockFilterEntity.getDoe());
		dto.setPe(stockFilterEntity.getPe());
		dto.setPb(stockFilterEntity.getPb());
		dto.setAsset(stockFilterEntity.getAsset());
		dto.setEvEbitda(stockFilterEntity.getEvEbitda());
		dto.setPostTaxProfitYear(stockFilterEntity.getPostTaxProfitYear());
		dto.setPostTaxProfitQuarter(stockFilterEntity.getPostTaxProfitQuarter());
		dto.setEpsTtm(stockFilterEntity.getEpsTtm());
		dto.setLastQuarterTradingValue(stockFilterEntity.getLastQuarterTradingValue());
		dto.setRevenueLastQuarterGrowth(stockFilterEntity.getRevenueLastQuarterGrowth());
		dto.setRevenueGrowthLastYear(stockFilterEntity.getRevenueGrowthLastYear());
		dto.setRevenueTtm(stockFilterEntity.getRevenueTtm());
		dto.setRevenueLastYear(stockFilterEntity.getRevenueLastYear());
		dto.setLastYearPostTaxProfit(stockFilterEntity.getLastYearPostTaxProfit());
		dto.setLastYearCashFlowFromFinancial(stockFilterEntity.getLastYearCashFlowFromFinancial());
		dto.setLastYearCashFlowFromSale(stockFilterEntity.getLastYearCashFlowFromSale());
		dto.setLastYearFreeCashFlow(stockFilterEntity.getLastYearFreeCashFlow());

		if (stockFilterEntity.getCompanyEntity() != null) {
			dto.setCode(stockFilterEntity.getCompanyEntity().getCode());
		}

		return dto;
	}

}
