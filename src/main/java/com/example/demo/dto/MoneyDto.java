package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Action;
import com.example.demo.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MoneyDto {
	
	private Long id;
	@NotNull(message="가격은 필수입니다.")
	private Long price;
	private Action action;
	private Date transactionDt;
	private Category category;
	private String description;
}
