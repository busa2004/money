package com.example.demo.dto;

import com.example.demo.domain.Category;
import com.example.demo.domain.Money;
import com.example.demo.domain.User;

import lombok.Getter;

@Getter
public class MoneyRequestDto {
	
	private Long price;
	private Long categoryId;
	private String description;
	
	public Money toEntity(Category category, User user){
		return Money.builder().price(price).description(description).category(category).user(user).build();
    }
}
