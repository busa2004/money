package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Action;
import com.example.demo.domain.Category;
import com.example.demo.domain.Money;
import com.example.demo.domain.MoneyHistory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MoneyHistoryResponseDto {
	private Long id;
	@NotNull(message="가격은 필수입니다.")
	private Long price;
	private Action action;
	private Date transactionDt;
	private Money money;
	private String description;
	
	public MoneyHistoryResponseDto(MoneyHistory moneyHistory) {
        this.id = moneyHistory.getId();
        this.price = moneyHistory.getPrice();
        this.action = moneyHistory.getAction();
        this.transactionDt = moneyHistory.getTransactionDt();
        this.money = moneyHistory.getMoney();
        this.description = moneyHistory.getDescription();
    }
}
