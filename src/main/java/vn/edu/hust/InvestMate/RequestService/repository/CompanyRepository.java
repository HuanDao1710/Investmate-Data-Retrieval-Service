package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {
	CompanyEntity findOneByCode(String code);
	List<CompanyEntity> findAll();
	@Query("SELECT tp FROM CompanyEntity tp " +
			"WHERE " +
			"(LOWER(tp.code) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(tp.fullNameVi) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
			"ORDER BY CASE WHEN LOWER(tp.code) LIKE LOWER(CONCAT('%', :keyword, '%')) THEN 0 ELSE 1 END")
	List<CompanyEntity> search(@Param("keyword") String keyword);
}

