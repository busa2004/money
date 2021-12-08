package com.example.demo.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.common.BaseTimeEntity;
import com.example.demo.dto.CategoryRequestDto;
import com.example.demo.dto.MoneyHistoryRequestDto;
import com.example.demo.dto.MoneyRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name="money")
@NoArgsConstructor
public class Money extends BaseTimeEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "money_id")
	private Long id;
	private Long price;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Builder
    public Money(Long price,User user,String description,Category category) {
		this.price = price;
		this.user = user;
		this.description = description;
		this.category = category;
    }
	
	public void update(MoneyRequestDto moneyRequestDto) {
        this.price = moneyRequestDto.getPrice();
        this.description = moneyRequestDto.getDescription();
    }

	public void updateMoney(MoneyHistoryRequestDto moneyHistoryRequestDto) {
		switch(moneyHistoryRequestDto.getAction()) {
		case ADD :
			this.price = price + moneyHistoryRequestDto.getPrice();
			break;
		case UPDATE :
			this.price = moneyHistoryRequestDto.getPrice();
			break;
		}
		
	}
}
