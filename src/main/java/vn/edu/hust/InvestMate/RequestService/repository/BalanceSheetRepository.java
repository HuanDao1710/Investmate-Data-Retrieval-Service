package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.BalanceSheetEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CashFlowEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;

import java.util.List;

@Repository
public interface BalanceSheetRepository extends JpaRepository<BalanceSheetEntity, Long> {
	@Query("SELECT ic " +
			"FROM BalanceSheetEntity ic " +
			"WHERE ic.companyEntity = :companyEntity AND ic.year >= :year")
	List<BalanceSheetEntity> findAllByCompanyEntityAndYear(@Param("companyEntity") CompanyEntity companyEntity, @Param("year") int year);
}
