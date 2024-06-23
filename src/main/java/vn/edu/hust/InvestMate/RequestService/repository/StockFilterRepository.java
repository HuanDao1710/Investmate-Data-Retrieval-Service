package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.StockFilterEntity;

import java.util.List;


@Repository
public interface StockFilterRepository extends JpaRepository<StockFilterEntity, Long> {
	List<StockFilterEntity> findAll();
	@Query("SELECT " +
			"max(s.eps) as max_eps, min(s.eps) as min_eps, " +
			"max(s.epsGrowth1Year) as max_eps_growth_1_year, min(s.epsGrowth1Year) as min_eps_growth_1_year, " +
			"max(s.lastQuarterProfitGrowth) as max_last_quarter_profit_growth, min(s.lastQuarterProfitGrowth) as min_last_quarter_profit_growth, " +
			"max(s.roe) as max_roe, min(s.roe) as min_roe, " +
			"max(s.grossMargin) as max_gross_margin, min(s.grossMargin) as min_gross_margin, " +
			"max(s.doe) as max_doe, min(s.doe) as min_doe, " +
			"max(s.pe) as max_pe, min(s.pe) as min_pe, " +
			"max(s.pb) as max_pb, min(s.pb) as min_pb, " +
			"max(s.asset) as max_asset, min(s.asset) as min_asset, " +
			"max(s.evEbitda) as max_ev_ebitda, min(s.evEbitda) as min_ev_ebitda, " +

			"max(s.postTaxProfitYear) as max_post_tax_profit_year, min(s.postTaxProfitYear) as min_post_tax_profit_year, " +
			"max(s.postTaxProfitQuarter) as max_post_tax_profit_quarter, min(s.postTaxProfitQuarter) as min_post_tax_profit_quarter, " +
			"max(s.epsTtm) as max_eps_ttm, min(s.epsTtm) as min_eps_ttm, " +
			"max(s.lastQuarterTradingValue) as max_last_quarter_trading_value, min(s.lastQuarterTradingValue) as min_last_quarter_trading_value, " +
			"max(s.revenueLastQuarterGrowth) as max_revenue_last_quarter_growth, min(s.revenueLastQuarterGrowth) as min_revenue_last_quarter_growth, " +
			"max(s.revenueGrowthLastYear) as max_revenue_growth_last_year, min(s.revenueGrowthLastYear) as min_revenue_growth_last_year, " +
			"max(s.revenueTtm) as max_revenue_ttm, min(s.revenueTtm) as min_revenue_ttm, " +
			"max(s.revenueLastYear) as max_revenue_last_year, min(s.revenueLastYear) as min_revenue_last_year, " +
			"max(s.lastYearPostTaxProfit) as max_last_year_post_tax_profit, min(s.lastYearPostTaxProfit) as min_last_year_post_tax_profit, " +
			"max(s.lastYearCashFlowFromFinancial) as max_last_year_cash_flow_from_financial, min(s.lastYearCashFlowFromFinancial) as min_last_year_cash_flow_from_financial, " +
			"max(s.lastYearCashFlowFromSale) as max_last_year_cash_flow_from_sale, min(s.lastYearCashFlowFromSale) as min_last_year_cash_flow_from_sale, " +
			"max(s.lastYearFreeCashFlow) as max_last_year_free_cash_flow, min(s.lastYearFreeCashFlow) as min_last_year_free_cash_flow, " +
//
			"max(tp.volume) as max_volume, min(tp.volume) as min_volume, " +
			"max(tp.dailyTradingValue) as max_daily_trading_value, min(tp.dailyTradingValue) as min_daily_trading_value, " +
			"max(tp.price) as max_price, min(tp.price) as min_price, " +
			"max(tp.percentChangeDay) as max_percent_change_day, min(tp.percentChangeDay) as min_percent_change_day, " +
			"max(tp.percentChangeWeek) as max_percent_change_week, min(tp.percentChangeWeek) as min_percent_change_week, " +
			"max(tp.percentChangeMonth) as max_percent_change_month, min(tp.percentChangeMonth) as min_percent_change_month, " +
			"max(tp.marketCap) as max_market_cap, min(tp.marketCap) as min_market_cap, " +
			"max(tp.avgTradingValue20Day) as max_avg_trading_value_20_day, min(tp.avgTradingValue20Day) as min_avg_trading_value_20_day, " +
			"max(tp.smg) as max_smg, min(tp.smg) as min_smg " +
			"FROM StockFilterEntity s INNER JOIN TemporaryEntity tp ON tp.companyEntity = s.companyEntity")
	MinMaxValues getMinMaxValues();

}

