package com.example.demo.dto;

import java.util.Date;

import com.example.demo.domain.Action;
import com.example.demo.domain.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryResponseDto {
	private Long id;
	private String nm;
}
