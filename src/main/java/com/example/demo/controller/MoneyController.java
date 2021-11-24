package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.dto.MoneyDto;
import com.example.demo.service.MoneyService;
import com.example.demo.service.ResponseService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/money")
@Slf4j
public class MoneyController {
	
	private MoneyService moneyService;
	private ResponseService responseService;
	
	@GetMapping("/{id}")
	public SingleResult<MoneyDto> get(@PathVariable Long id) throws Exception {
		return responseService.getSingleResult(moneyService.findById(id));
	}
	
	@GetMapping
	public ListResult<MoneyDto> getAll() throws Exception {
		return responseService.getListResult(moneyService.findAll());
	}
	
	@PostMapping
	public CommonResult save(@RequestBody @Valid MoneyDto money) throws Exception {
		moneyService.save(money);
		log.info("money :{} ",money);
		return responseService.getSuccesResult();
	}
	
	
}
