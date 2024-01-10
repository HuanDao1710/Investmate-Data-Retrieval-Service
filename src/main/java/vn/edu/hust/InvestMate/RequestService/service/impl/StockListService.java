package vn.edu.hust.InvestMate.RequestService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.CompanyOverviewDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.FinancialRatioDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.IndustryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyOverviewEntity;
import vn.edu.hust.InvestMate.RequestService.domain.entity.TemporaryEntity;
import vn.edu.hust.InvestMate.RequestService.mapper.FinancialRatioMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.OverviewInfoMapper;
import vn.edu.hust.InvestMate.RequestService.mapper.TemporaryMapper;
import vn.edu.hust.InvestMate.RequestService.repository.CompanyOverviewRepository;
import vn.edu.hust.InvestMate.RequestService.repository.CompanyRepository;
import vn.edu.hust.InvestMate.RequestService.repository.FinancialRatioRepository;
import vn.edu.hust.InvestMate.RequestService.repository.TemporaryRepository;
import vn.edu.hust.InvestMate.RequestService.service.IStockListService;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StockListService implements IStockListService {
	private final CompanyOverviewRepository overviewRepository;
	private final TemporaryRepository temporaryRepository;
	private final TemporaryMapper temporaryMapper;

	@Override
	public List<IndustryDTO> getListIndustry() {
		var listIndustry = overviewRepository.findListIndustry();
		return listIndustry.stream().map(i -> new IndustryDTO(i , i)).toList();
	}

	@Override
	public Page<TemporaryDTO> getListStock(String industry, Pageable pageable) {
		Page<TemporaryEntity> queryResults;
		if(industry == "") {
			queryResults = temporaryRepository.findAll(pageable);
		} else {
			queryResults = temporaryRepository
					.findAllByCompanyEntity_OverviewCompanyEntity_Industry(industry, pageable);
		}
		return new PageImpl<>(queryResults.stream().map(temporaryMapper::toDTO).toList()
				, queryResults.getPageable(), queryResults.getTotalElements());
	}
}
