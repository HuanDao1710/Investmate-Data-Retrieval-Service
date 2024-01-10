package vn.edu.hust.InvestMate.RequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.LargeShareHolderEntity;

import java.util.List;

@Repository
public interface LargeShareHolderRepository extends	JpaRepository<LargeShareHolderEntity, String> {
	List<LargeShareHolderEntity> findAllByCompanyEntity(CompanyEntity companyEntity);
}
