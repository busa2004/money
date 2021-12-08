package com.example.demo.dto;

import com.example.demo.domain.Category;
import com.example.demo.domain.Money;
import com.example.demo.domain.User;

import lombok.Getter;

@Getter
public class MoneyResponseDto {
	private Long id;
	private Long price;
	private User user;
	private Category category;
	private String description;
	
	public MoneyResponseDto(Money money) {
        this.id = money.getId();
        this.price = money.getPrice();
        this.user = money.getUser();
        this.category = money.getCategory();
        this.description = money.getDescription();
    }
}
