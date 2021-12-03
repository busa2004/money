package com.example.demo.dto;

import java.util.Date;

import com.example.demo.domain.Action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyHistoryRequestDto {
	private Long price;
	private Action action;
	private Date transactionDt;
	private Long moneyId;
	private String description;
}
