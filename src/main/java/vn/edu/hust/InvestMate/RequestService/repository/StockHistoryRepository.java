package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.StockHistoryEntity;

@Repository
public interface StockHistoryRepository extends JpaRepository<StockHistoryEntity, Long> {
	@Query("SELECT MAX(sh.time) FROM StockHistoryEntity sh WHERE sh.companyEntity.code = :code")
	Long findMaxTimeByCode(@Param("code") String code);
}
