package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.CommonResult;
import com.example.demo.common.ListResult;
import com.example.demo.common.SingleResult;
import com.example.demo.dto.MoneyHistoryRequestDto;
import com.example.demo.dto.MoneyHistoryResponseDto;
import com.example.demo.dto.MoneyRequestDto;
import com.example.demo.dto.MoneyResponseDto;
import com.example.demo.service.MoneyHistoryService;
import com.example.demo.service.ResponseService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/moneyHistory")
@Slf4j
public class MoneyHistoryController {
	
	private MoneyHistoryService moneyHistoryService;
	private ResponseService responseService;
	
	@GetMapping("/{id}")
	public SingleResult<MoneyHistoryResponseDto> get(@PathVariable Long id) throws Exception {
		return responseService.getSingleResult(moneyHistoryService.findById(id));
	}
	
	@GetMapping
	public ListResult<MoneyHistoryResponseDto> getAll() throws Exception {
		return responseService.getListResult(moneyHistoryService.findAll());
	}
	
	@PostMapping
	public CommonResult save(@RequestBody @Valid MoneyHistoryRequestDto money) throws Exception {
		moneyHistoryService.save(money);
		log.info("money :{} ",money);
		return responseService.getSuccessResult();
	}
	
	
}
