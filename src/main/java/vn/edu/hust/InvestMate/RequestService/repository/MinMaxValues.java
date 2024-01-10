package vn.edu.hust.InvestMate.RequestService.repository;

public interface MinMaxValues {
	Double getMax_eps();

	Double getMin_eps();

	Double getMax_eps_growth_1_year();

	Double getMin_eps_growth_1_year();

	Double getMax_last_quarter_profit_growth();

	Double getMin_last_quarter_profit_growth();

	Double getMax_roe();

	Double getMin_roe();

	Double getMax_gross_margin();

	Double getMin_gross_margin();

	Double getMax_doe();

	Double getMin_doe();

	Double getMax_pe();

	Double getMin_pe();

	Double getMax_pb();

	Double getMin_pb();

	Double getMax_asset();

	Double getMin_asset();

	Double getMax_ev_ebitda();

	Double getMin_ev_ebitda();
	Double getMax_percent_change_day();
	Double getMin_percent_change_day();
	Double getMax_percent_change_week();
	Double getMin_percent_change_week();
	Double getMax_percent_change_month();
	Double getMin_percent_change_month();
	Double getMax_market_cap();
	Double getMin_market_cap();
	Double getMax_avg_trading_value_20_day();
	Double getMin_avg_trading_value_20_day();
	Double getMin_smg();
	Double getMax_smg();
	Double getMax_price();
	Double getMin_price();
}
