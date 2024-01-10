package vn.edu.hust.InvestMate.RequestService.mapper;

import org.springframework.stereotype.Component;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CashFlowDataChartDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.BalanceSheetEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CashFlowEntity;

import java.util.Objects;

@Component
public class CashFlowMapper {
	public CashFlowDataChartDTO toChartDataDTO(CashFlowEntity entity,Double cash) {
		Objects.requireNonNull(entity, "CashFlowEntity cannot be null.");
		CashFlowDataChartDTO dto = new CashFlowDataChartDTO();
		dto.setYearly(entity.getYearly());
		dto.setTicker(entity.getTicker());
		dto.setQuarter(entity.getQuarter());
		dto.setCash(cash);
		dto.setYear(entity.getYear());
		dto.setInvestCost(entity.getInvestCost());
		dto.setFromInvest(entity.getFromInvest());
		dto.setFromFinancial(entity.getFromFinancial());  //
		dto.setFromSale(entity.getFromSale());
		dto.setFreeCashFlow(entity.getFreeCashFlow());
		return dto;
	}
}
