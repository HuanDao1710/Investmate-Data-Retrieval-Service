package vn.edu.hust.InvestMate.RequestService.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_history")
public class StockHistoryEntity extends  BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "time")
	private Long time;
	@Column(name = "open")
	private double open;
	@Column(name = "high")
	private double high;
	@Column(name = "low")
	private double low;
	@Column(name = "close")
	private double close;
	@Column(name = "volume")
	private double volume;
	@ManyToOne
	@JoinColumn(name="code", nullable=false)
	private CompanyEntity companyEntity;
}
