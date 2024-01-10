package vn.edu.hust.InvestMate.RequestService.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "overview_companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOverviewEntity extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name="code", referencedColumnName = "code")
	@OneToOne
	private CompanyEntity companyEntity;
	@Column(name="company_name")
	private  String companyName;
	@Column(name="short_name")
	private String shortName;
	@Column(name="industry_id")
	private int industryId;
	@Column(name="industry_idv2")
	private String industryIdv2;
	@Column(name="industry_idv4")
	private String industryIdLevel2;
	@Column(name="industry_id_level4")
	private String industryIdLevel4;
	@Column(name="industry")
	private String industry;
	@Column(name="industry_en")
	private String industryEn;
	@Column(name="established_year")
	private String establishedYear;
	@Column(name="no_employees")
	private int noEmployees;
	@Column(name="no_shareholders")
	private int noShareholders;
	@Column(name="foreign_percent")
	private double foreignPercent;
	@Column(name = "website")
	private String website;
	@Column(name = "stock_rating")
	private double stockRating;
	@Column(name="delta_in_week")
	private double deltaInWeek;
	@Column(name="delta_in_month")
	private double deltaInMonth;
	@Column(name="delta_in_year")
	private double deltaInYear;
	@Column(name = "outstanding_share")
	private double outstandingShare;
	@Column(name = "issue_share")
	private double issueShare;
	@Column(name = "company_profile", columnDefinition = "TEXT")
	private String companyProfile;
	@Column(name = "company_type")
	private String companyType;
	@Column(name = "history_dev", columnDefinition = "TEXT")
	private String historyDev;
	@Column(name = "company_promise", columnDefinition = "TEXT")
	private String companyPromise;
	@Column(name = "business_risk", columnDefinition = "TEXT")
	private String businessRisk;
	@Column(name = "key_developments", columnDefinition = "TEXT")
	private String keyDevelopments;
	@Column(name="business_strategies", columnDefinition = "TEXT")
	private String businessStrategies;
}
