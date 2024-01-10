package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.BalanceSheetEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.FinancialRatioEntity;

import java.util.List;

@Repository
public interface FinancialRatioRepository extends	JpaRepository<FinancialRatioEntity, Long> {
	FinancialRatioEntity findOneByCompanyEntity(CompanyEntity companyEntity);

	@Query("SELECT fr FROM FinancialRatioEntity fr WHERE fr.companyEntity = :companyEntity AND fr.yearly = 0 ORDER BY fr.year DESC, fr.quarter DESC")
	List<FinancialRatioEntity> findTopByYearlyOrderByYearDescQuarterDesc(@Param("companyEntity") CompanyEntity companyEntity);

	@Query("SELECT ic " +
			"FROM FinancialRatioEntity ic " +
			"WHERE ic.companyEntity = :companyEntity AND ic.year >= :year")
	List<FinancialRatioEntity> findAllByCompanyEntityAndYear(@Param("companyEntity") CompanyEntity companyEntity, @Param("year") int year);

}
