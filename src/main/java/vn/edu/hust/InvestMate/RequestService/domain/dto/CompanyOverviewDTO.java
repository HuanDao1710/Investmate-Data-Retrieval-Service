package vn.edu.hust.InvestMate.RequestService.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOverviewDTO {
	private String code;
	private String exchange;
	private String shortName;
	private  String companyName;
	private String industry;
	private String industryEn;
	private String establishedYear;
	private Integer noEmployees;
	private Integer noShareholders;
	private Double foreignPercent;
	private String website;
	private Double outstandingShare;
	private Double issueShare;
	private String companyProfile;
	private String companyType;
	private String businessType;
	private String historyDev;
	private String companyPromise;
	private String businessRisk;
	private String keyDevelopments;
	private String businessStrategies;
}
