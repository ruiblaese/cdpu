package com.cdpu.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "buy_option")
public class BuyOption  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8330942088888211092L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JoinColumn(name = "deal", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Deal deal;	
	
	@Column(nullable = false)
	private String title;
	
	@Column(name = "normal_price", nullable = false)
	private Double normalPrice;
	
	@Column(name = "percentage_discount", nullable = false)	
	private Double percentageDiscount;
	
	@Column(name = "sale_price", nullable = false)	
	private Double salePrice;
	
	@Column(name = "quantity_cupom", nullable = false)
	private Long quantityCupom;
	
	@Column(name = "quantity_sold", nullable = false)
	private Long quantitySold;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;

}
