package vn.edu.hust.InvestMate.RequestService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndexHistoryOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.SearchDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.IndexHistoryEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;
import vn.edu.hust.InvestMate.RequestService.exception.TransactionException;
import vn.edu.hust.InvestMate.RequestService.mapper.CompanyMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.IndexHistoryOverViewMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.TemporaryMapper;
import vn.edu.hust.InvestMate.RequestService.repository.CompanyRepository;
import vn.edu.hust.InvestMate.RequestService.repository.IndexHistoryRepository;
import vn.edu.hust.InvestMate.RequestService.repository.IndexRepository;
import vn.edu.hust.InvestMate.RequestService.repository.TemporaryRepository;
import vn.edu.hust.InvestMate.RequestService.service.IHomeService;
import vn.edu.hust.InvestMate.RequestService.utils.TimeUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService implements IHomeService {
	private final IndexHistoryRepository indexHistoryRepository;
	private final IndexRepository indexRepository;
	private final IndexHistoryOverViewMapper indexHistoryOverViewMapper;
	private final TemporaryMapper temporaryMapper;
	private final TemporaryRepository temporaryRepository;
	private final CompanyRepository companyRepository;
	private final CompanyMapper companyMapper;

	@Override
	public IndexHistoryOverviewDTO getOverViewIndex(String code) {
		var time = indexHistoryRepository.findMaxTimeByCode(code);
		IndexEntity entity = indexRepository.findOneByComGroupCode(code);
		if(entity == null) throw new TransactionException("No data");
		List<IndexHistoryEntity> results  =
				indexHistoryRepository.findByIndexEntityAndTimeBetweenOrderByTimeAsc(entity, TimeUtils.getStartOfDay(time), TimeUtils.getEndOfDay(time));
		var lastEntityDayBefore = indexHistoryRepository.findLatestBeforeTime(entity.getComGroupCode(), results.get(0).getTime());
		return indexHistoryOverViewMapper.toDTO(results, lastEntityDayBefore);
	}

	@Override
	public List<TemporaryDTO> getTop10Temporary() {
		List<TemporaryEntity> results = temporaryRepository.findTop10ByOrderBySmgDescAndFetchTimeSeriesEagerly();
		return results.stream().map(temporaryMapper::toDTO).toList();
	}

	@Override
	public List<SearchDTO> searchStock(String keyword) {
		return companyRepository.search(keyword).stream().map(companyMapper::toSearchDTO).toList();
	}

	@Override
	public TemporaryDTO getTemporaryByCode(String code) {
		var company = companyRepository.findOneByCode(code);
		if(company == null) throw new TransactionException("Company not found!");
		return temporaryMapper.toDTO(temporaryRepository.findOneByCompanyEntity(company));
	}

}
