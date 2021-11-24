package com.example.demo.common;

import com.example.demo.service.MoneyService;
import com.example.demo.service.ResponseService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
	private boolean success;
	private int code;
	private String msg;
}
