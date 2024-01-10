package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexEntity;
import java.util.List;

@Repository
public interface IndexRepository extends JpaRepository<IndexEntity, String> {
	IndexEntity findOneByComGroupCode(String code);
	List<IndexEntity> findAll();
	@Modifying
	@Query("DELETE FROM IndexEntity")
	void deleteAllData();
}
