package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;
import java.util.List;

@Repository
public interface TemporaryRepository extends JpaRepository<TemporaryEntity, Long> {
	@Query("SELECT te FROM TemporaryEntity te JOIN FETCH te.timeSeries WHERE " +
			"te.companyEntity.exchange IN ('HOSE', 'HNX') ORDER BY te.smg DESC LIMIT 10")
	List<TemporaryEntity> findTop10ByOrderBySmgDescAndFetchTimeSeriesEagerly();
	TemporaryEntity findOneByCompanyEntity(CompanyEntity companyEntity);
	Page<TemporaryEntity> findAll(Pageable pageable);
	Page<TemporaryEntity> findAllByCompanyEntity_OverviewCompanyEntity_Industry(String industry, Pageable pageable);

}
