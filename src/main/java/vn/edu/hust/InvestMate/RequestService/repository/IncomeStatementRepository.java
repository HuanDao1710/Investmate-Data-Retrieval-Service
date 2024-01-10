package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IncomeStatementEntity;

import java.util.List;

@Repository
public interface IncomeStatementRepository extends JpaRepository<IncomeStatementEntity, Long> {
	@Query("SELECT ic " +
			"FROM IncomeStatementEntity ic " +
			"WHERE ic.companyEntity = :companyEntity AND ic.year >= :year")
	List<IncomeStatementEntity> findAllByCompanyEntityAndYear(@Param("companyEntity") CompanyEntity companyEntity, @Param("year") int year);

}
