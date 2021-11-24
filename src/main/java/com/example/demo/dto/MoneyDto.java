package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	@NotBlank(message="설명은 필수입니다.")
	private String description;
	private Date transactionDt;
	private Date modifiedDt;
	private Date createdDt;
}
