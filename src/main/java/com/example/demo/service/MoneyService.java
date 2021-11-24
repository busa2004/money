package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Money;
import com.example.demo.dto.MoneyDto;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.repository.MoneyRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MoneyService {
	
	private MoneyRepository moneyRepository;
	private ModelMapper modelMapper;
	
	public MoneyDto findById(Long id) throws Exception {
		Money money = moneyRepository.findById(id).orElseThrow(() 
				-> { throw new CustomNotFoundException("존재하지 않는 아이디");});
		return modelMapper.map(money, MoneyDto.class);
	}
	
	public List<MoneyDto> findAll() {
		return moneyRepository.findAll().stream().map(p -> modelMapper.map(p, MoneyDto.class)).collect(Collectors.toList());

	}
	
	@Transactional
	public void save(MoneyDto money) throws Exception {
		moneyRepository.save(modelMapper.map(money, Money.class));
	}


}
