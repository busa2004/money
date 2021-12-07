package com.example.demo.dto;

import com.example.demo.domain.Action;
import com.example.demo.domain.Category;
import com.example.demo.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyResponseDto {
	private Long id;
	private Long price;
	private User user;
	private Action action;
	private Category category;
	private String description;
}
