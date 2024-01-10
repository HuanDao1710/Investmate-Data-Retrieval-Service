package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CashFlowDataChartDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CashFlowEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IncomeStatementEntity;

import java.util.List;
import java.util.Objects;

@Repository
public interface CashFlowRepository extends JpaRepository<CashFlowEntity, Long> {
	@Query("SELECT ic " +
			"FROM CashFlowEntity ic " +
			"WHERE ic.companyEntity = :companyEntity AND ic.year >= :year")
	List<CashFlowEntity> findAllByCompanyEntityAndYear(@Param("companyEntity") CompanyEntity companyEntity, @Param("year") int year);

	@Query("SELECT cf, bs.cash FROM CashFlowEntity cf " +
			"INNER JOIN BalanceSheetEntity bs ON bs.companyEntity = cf.companyEntity AND cf.year = bs.year AND cf.quarter = bs.quarter " +
			"WHERE cf.companyEntity = :companyEntity AND cf.year >= :year")
	List<Object[]> findData(@Param("companyEntity") CompanyEntity companyEntity, @Param("year") int year);
}
