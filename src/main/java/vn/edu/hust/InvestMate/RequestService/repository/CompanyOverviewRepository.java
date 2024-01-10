package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyOverviewEntity;

import java.util.List;

@Repository
public interface CompanyOverviewRepository extends JpaRepository<CompanyOverviewEntity, String> {
	@Query("SELECT c.industry FROM CompanyOverviewEntity c GROUP BY c.industry")
	List<String> findListIndustry();
	CompanyOverviewEntity findOneByCompanyEntity(CompanyEntity companyEntity);
}
