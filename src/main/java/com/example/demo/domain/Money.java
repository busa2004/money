package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.common.BaseTimeEntity;
import com.example.demo.dto.MoneyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="money")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Money extends BaseTimeEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private Long price;
	private String description;
	private Date transactionDt;
	private String actionFg;
	private String category;

}
