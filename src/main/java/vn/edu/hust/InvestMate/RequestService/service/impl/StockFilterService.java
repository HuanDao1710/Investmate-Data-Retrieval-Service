package vn.edu.hust.InvestMate.RequestService.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CriteriaTypeDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.StockFilterDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;
import vn.edu.hust.InvestMate.RequestService.mapper.StockFilterMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.TemporaryMapper;
import vn.edu.hust.InvestMate.RequestService.repository.StockFilterRepository;
import vn.edu.hust.InvestMate.RequestService.service.IStockFilterService;

import java.lang.reflect.Field;
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
	public List<TemporaryDTO> filter(String query) {
		Query q = entityManager.createQuery(query);
		List<Object[]> a = q.getResultList();
		return a.stream().map(obj -> temporaryMapper.toDTO((TemporaryEntity) obj[0])).toList();
	}

	@Override
	public List<CriteriaTypeDTO> getListCriteria() {
		var minMaxValues = stockFilterRepository.getMinMaxValues();
		List<CriteriaTypeDTO> results = new ArrayList<>();
		results.add(new CriteriaTypeDTO()
				.setName("EPS")
				.setIKey("sf.eps")
				.setMinValue(minMaxValues.getMin_eps())
				.setMaxValue(minMaxValues.getMax_eps()));
		results.add(new CriteriaTypeDTO()
				.setName("Tăng tưởng EPS 1 năm")
				.setIKey("sf.epsGrowth1Year")
				.setMinValue(minMaxValues.getMin_eps_growth_1_year())
				.setMaxValue(minMaxValues.getMax_eps_growth_1_year()));
		results.add(new CriteriaTypeDTO()
				.setName("Tăng trưởng lợi nhuận quý")
				.setIKey("sf.lastQuarterProfitGrowth")
				.setMinValue(minMaxValues.getMin_last_quarter_profit_growth())
				.setMaxValue(minMaxValues.getMax_last_quarter_profit_growth()));
		results.add(createCriteria("ROE", "sf.roe", minMaxValues.getMin_roe(), minMaxValues.getMax_roe()));
		results.add(createCriteria("Tỉ suất lợi nhuận gộp", "sf.grossMargin", minMaxValues.getMin_gross_margin(), minMaxValues.getMax_gross_margin()));
		results.add(createCriteria("DOE", "sf.doe", minMaxValues.getMin_doe(), minMaxValues.getMax_doe()));
		results.add(createCriteria("PE", "sf.pe", minMaxValues.getMin_pe(), minMaxValues.getMax_pe()));
		results.add(createCriteria("PB", "sf.pb", minMaxValues.getMin_pb(), minMaxValues.getMax_pb()));
		results.add(createCriteria("EV/EBITDA", "sf.evEbitda", minMaxValues.getMin_ev_ebitda(), minMaxValues.getMax_ev_ebitda()));
		results.add(createCriteria("% Giá trong ngày", "tp.percentChangeDay", minMaxValues.getMin_percent_change_day(), minMaxValues.getMax_percent_change_day()));
		results.add(createCriteria("% Giá so với đầu tuần", "tp.percentChangeWeek", minMaxValues.getMin_percent_change_week(), minMaxValues.getMax_percent_change_week()));
		results.add(createCriteria("% Giá so với đầu tháng", "tp.percentChangeMonth", minMaxValues.getMin_percent_change_month(), minMaxValues.getMax_percent_change_month()));
		results.add(createCriteria("Vốn hoá thị trường", "tp.marketCap", minMaxValues.getMin_market_cap(), minMaxValues.getMax_market_cap()));
		results.add(createCriteria("Trung bình giá trị giao dịch 20 ngày", "tp.avgTradingValue20Day", minMaxValues.getMin_avg_trading_value_20_day(), minMaxValues.getMax_avg_trading_value_20_day()));
		results.add(createCriteria("SMG", "tp.smg", minMaxValues.getMin_smg(), minMaxValues.getMax_smg()));
		results.add(createCriteria("Giá đóng cửa gần nhất", "tp.price", minMaxValues.getMin_price(), minMaxValues.getMax_price()));
		results.add(createCriteria("Tổng tài sản", "sf.asset", minMaxValues.getMin_asset(), minMaxValues.getMax_asset()));
		return results;
	}

	private CriteriaTypeDTO createCriteria(String name, String iKey, Double minValue, Double maxValue) {
		return new CriteriaTypeDTO()
				.setName(name)
				.setIKey(iKey)
				.setMinValue(minValue)
				.setMaxValue(maxValue);
	}


}
