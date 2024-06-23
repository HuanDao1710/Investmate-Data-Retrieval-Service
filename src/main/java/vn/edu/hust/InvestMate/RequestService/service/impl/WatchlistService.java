package vn.edu.hust.InvestMate.RequestService.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.InvestMate.RequestService.domain.dto.TemporaryDTO;
import vn.edu.hust.InvestMate.RequestService.domain.entity.CompanyEntity;
import vn.edu.hust.InvestMate.RequestService.mapper.TemporaryMapper;
import vn.edu.hust.InvestMate.RequestService.repository.CompanyRepository;
import vn.edu.hust.InvestMate.RequestService.repository.TemporaryRepository;
import vn.edu.hust.InvestMate.RequestService.service.IWatchlistService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WatchlistService implements IWatchlistService {
	private final TemporaryRepository temporaryRepository;
	private final CompanyRepository companyRepository;
	private final TemporaryMapper temporaryMapper;
	@Override
	public List<TemporaryDTO> getListStockByListCode(List<String> listCode) {
		List<CompanyEntity> companyEntities = listCode.stream().map(companyRepository::findOneByCode).filter(Objects::nonNull).toList();
		return companyEntities.stream().map(temporaryRepository::findOneByCompanyEntity).filter(Objects::nonNull).map(temporaryMapper::toDTO).toList();
	}
}
