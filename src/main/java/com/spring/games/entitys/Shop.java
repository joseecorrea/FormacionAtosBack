package com.spring.games.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "SHOPS")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String address;
	
	private String zc;
	
	@OneToMany(mappedBy = "shop",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	private List<Stock> shopStocks;

}
