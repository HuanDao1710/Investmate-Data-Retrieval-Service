package vn.edu.hust.InvestMate.RequestService.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.StockFilterEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;
import vn.edu.hust.InvestMate.RequestService.mapper.StockFilterMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.TemporaryMapper;
import vn.edu.hust.InvestMate.RequestService.repository.StockFilterRepository;
import vn.edu.hust.InvestMate.RequestService.service.IStockFilterService;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockFilterService implements IStockFilterService {
	@PersistenceContext
	EntityManager entityManager;

	private final StockFilterMapper stockFilterMapper;
	private final TemporaryMapper temporaryMapper;
	private final StockFilterRepository stockFilterRepository;

	@Override
	public List<FilterDTO> filter(String query) {
		Query q = entityManager.createQuery(query);
		List<Object[]> a = q.getResultList();
		return a.stream().map(obj -> new FilterDTO(temporaryMapper.toDTO((TemporaryEntity) obj[0]),
				stockFilterMapper.toDTO((StockFilterEntity) obj[1]))).toList();
	}

	@Override
	public List<CriteriaTypeDTO> getListCriteria() {
		var minMaxValues = stockFilterRepository.getMinMaxValues();
		List<CriteriaTypeDTO> results = new ArrayList<>();
		results.add(new CriteriaTypeDTO()
				.setName("EPS(năm gần nhất)")
				.setIKey("sf.eps")
				.setMinValue(minMaxValues.getMin_eps())
				.setMaxValue(minMaxValues.getMax_eps()));
		results.add(new CriteriaTypeDTO()
				.setName("Tăng tưởng EPS (năm gần nhất)")
				.setIKey("sf.epsGrowth1Year")
				.setMinValue(minMaxValues.getMin_eps_growth_1_year())
				.setMaxValue(minMaxValues.getMax_eps_growth_1_year()));
		results.add(new CriteriaTypeDTO()
				.setName("Tăng trưởng lợi nhuận (quý gần nhất)")
				.setIKey("sf.lastQuarterProfitGrowth")
				.setMinValue(minMaxValues.getMin_last_quarter_profit_growth())
				.setMaxValue(minMaxValues.getMax_last_quarter_profit_growth()));
		results.add(createCriteria("ROE (quý gần nhất)", "sf.roe", minMaxValues.getMin_roe(), minMaxValues.getMax_roe()));
		results.add(createCriteria("Lợi nhuận gộp (quý gần nhất)", "sf.grossMargin", minMaxValues.getMin_gross_margin(), minMaxValues.getMax_gross_margin()));
		results.add(createCriteria("DOE (quý gần nhất)", "sf.doe", minMaxValues.getMin_doe(), minMaxValues.getMax_doe()));
		results.add(createCriteria("PE (quý gần nhất)", "sf.pe", minMaxValues.getMin_pe(), minMaxValues.getMax_pe()));
		results.add(createCriteria("PB (quý gần nhất)", "sf.pb", minMaxValues.getMin_pb(), minMaxValues.getMax_pb()));
		results.add(createCriteria("EV/EBITDA", "sf.evEbitda", minMaxValues.getMin_ev_ebitda(), minMaxValues.getMax_ev_ebitda()));
		results.add(createCriteria("% Giá trong ngày", "tp.percentChangeDay", minMaxValues.getMin_percent_change_day(), minMaxValues.getMax_percent_change_day())); // -------
		results.add(createCriteria("% Giá so với đầu tuần", "tp.percentChangeWeek", minMaxValues.getMin_percent_change_week(), minMaxValues.getMax_percent_change_week()));
		results.add(createCriteria("% Giá so với đầu tháng", "tp.percentChangeMonth", minMaxValues.getMin_percent_change_month(), minMaxValues.getMax_percent_change_month()));
		results.add(createCriteria("Vốn hoá thị trường (tỷ)", "tp.marketCap", minMaxValues.getMin_market_cap(), minMaxValues.getMax_market_cap()));
		results.add(createCriteria("Trung bình giá trị giao dịch 20 ngày", "tp.avgTradingValue20Day", minMaxValues.getMin_avg_trading_value_20_day(), minMaxValues.getMax_avg_trading_value_20_day()));
		results.add(createCriteria("SMG", "tp.smg", minMaxValues.getMin_smg(), minMaxValues.getMax_smg()));
		results.add(createCriteria("Giá cổ phiếu", "tp.price", minMaxValues.getMin_price(), minMaxValues.getMax_price()));
		results.add(createCriteria("Tổng tài sản", "sf.asset", minMaxValues.getMin_asset(), minMaxValues.getMax_asset()));
		results.add(createCriteria("Khối lượng giao dịch trong ngày", "tp.volume", minMaxValues.getMin_volume(), minMaxValues.getMax_volume()));
		results.add(createCriteria("Giá trị giao dịch (quý gần nhất)", "sf.lastQuarterTradingValue", minMaxValues.getMin_last_quarter_trading_value(), minMaxValues.getMax_last_quarter_trading_value()));
		results.add(createCriteria("Lợi nhuận sau thuế (năm gần nhất)", "sf.postTaxProfitYear", minMaxValues.getMin_post_tax_profit_year(), minMaxValues.getMax_post_tax_profit_year()));
		results.add(createCriteria("Lợi nhuận sau thuế (quý gần nhất)", "sf.postTaxProfitQuarter", minMaxValues.getMin_post_tax_profit_quarter(), minMaxValues.getMax_post_tax_profit_quarter()));
		results.add(createCriteria("EPS (TTM)", "sf.epsTtm", minMaxValues.getMin_eps_ttm(), minMaxValues.getMax_eps_ttm()));
		results.add(createCriteria("Tăng trưởng doanh thu (quý gần nhất)", "sf.revenueLastQuarterGrowth", minMaxValues.getMin_revenue_last_quarter_growth(), minMaxValues.getMax_revenue_last_quarter_growth()));
		results.add(createCriteria("Tăng trưởng doanh thu (năm gần nhất)", "sf.revenueGrowthLastYear", minMaxValues.getMin_revenue_growth_last_year(), minMaxValues.getMax_revenue_growth_last_year()));
		results.add(createCriteria("Doanh thu (TTM)", "sf.revenueTtm", minMaxValues.getMin_revenue_ttm(), minMaxValues.getMax_revenue_ttm()));
		results.add(createCriteria("Doanh thu (năm gần nhất)", "sf.revenueLastYear", minMaxValues.getMin_revenue_last_year(), minMaxValues.getMax_revenue_last_year()));
		results.add(createCriteria("Dòng tiền từ hoạt động tài chính(năm gần nhất)", "sf.lastYearCashFlowFromFinancial", minMaxValues.getMin_last_year_cash_flow_from_financial(), minMaxValues.getMax_last_year_cash_flow_from_financial()));
		results.add(createCriteria("Dòng tiền từ hoạt động kinh doanh(năm gần nhất)", "sf.lastYearCashFlowFromSale", minMaxValues.getMin_last_year_cash_flow_from_sale(), minMaxValues.getMax_last_year_cash_flow_from_sale()));
		results.add(createCriteria("Dòng tiền tự do(năm gần nhất)", "sf.lastYearFreeCashFlow", minMaxValues.getMin_last_year_free_cash_flow(), minMaxValues.getMax_last_year_free_cash_flow()));
		return results;
	}

	private CriteriaTypeDTO createCriteria(String name, String iKey, Double minValue, Double maxValue) {
		if (minValue == null) minValue = 0.0;
		if(maxValue == null) maxValue = 0.0;
		return new CriteriaTypeDTO()
				.setName(name)
				.setIKey(iKey)
				.setMinValue(minValue)
				.setMaxValue(maxValue);
	}


}
