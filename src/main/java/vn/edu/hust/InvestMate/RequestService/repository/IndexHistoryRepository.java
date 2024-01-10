package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexHistoryEntity;

import java.util.List;

@Repository
public interface IndexHistoryRepository extends JpaRepository<IndexHistoryEntity, Long> {
	@Query("SELECT MAX(ih.time) " +
			"FROM IndexHistoryEntity ih " +
			"WHERE ih.indexEntity.comGroupCode = :comGroupCode")
	Long findMaxTimeByCode(@Param("comGroupCode") String code);
	List<IndexHistoryEntity> findByIndexEntityAndTimeBetween(IndexEntity indexEntity, long from, long to);

	@Query("SELECT ih FROM IndexHistoryEntity ih " +
			"WHERE ih.indexEntity.comGroupCode = :comGroupCode AND ih.time < :to " +
			"ORDER BY ih.time DESC LIMIT 1")
	IndexHistoryEntity findLatestBeforeTime(@Param("comGroupCode") String code, @Param("to") long to);
}
