package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Action;
import com.example.demo.domain.Category;
import com.example.demo.domain.Money;
import com.example.demo.domain.MoneyHistory;
import com.example.demo.dto.MoneyHistoryRequestDto;
import com.example.demo.dto.MoneyHistoryResponseDto;
import com.example.demo.dto.MoneyRequestDto;
import com.example.demo.dto.MoneyResponseDto;
import com.example.demo.exception.CCategoryNotFoundException;
import com.example.demo.exception.CUserNotFoundException;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MoneyHistoryRepository;
import com.example.demo.repository.MoneyRepository;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MoneyHistoryService {
	
	private final MoneyRepository moneyRepository;
	private final MoneyHistoryRepository moneyHistoryRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	
	public MoneyHistoryResponseDto findById(Long id) throws Exception {
		MoneyHistory moneyHistory = moneyHistoryRepository.findById(id).orElseThrow(CUserNotFoundException::new);
		return modelMapper.map(moneyHistory, MoneyHistoryResponseDto.class);
	}
	
	public List<MoneyHistoryResponseDto> findAll() {
		return moneyHistoryRepository.findAll().stream().map(p -> modelMapper.map(p, MoneyHistoryResponseDto.class)).collect(Collectors.toList());

	}
	
	@Transactional
	public void save(MoneyHistoryRequestDto moneyHistoryRequestDto) throws Exception {
		
		Supplier<Money> createMoney = () -> { 
			log.info("money생성");
			return Money.builder().category(Category.builder().nm("주").build()).price(0L).build(); 
			};
		Money money = moneyRepository.findById(moneyHistoryRequestDto.getMoneyId()).orElseGet(createMoney);
		log.info("money생성완");
		
		log.info("moneyHistory생성");
		MoneyHistory moneyHistory = 
				MoneyHistory.builder()
				.price(moneyHistoryRequestDto.getPrice())
				.money(money)
				.transactionDt(moneyHistoryRequestDto.getTransactionDt())
				.action(moneyHistoryRequestDto.getAction())
				.description(moneyHistoryRequestDto.getDescription())
				.build();
		log.info("moneyHistory생성완료");
		
		switch(moneyHistory.getAction()) {
			case ADD :
				money.setPrice(money.getPrice() + moneyHistoryRequestDto.getPrice());
				break;
			case UPDATE :
				money.setPrice(moneyHistoryRequestDto.getPrice());
				break;
		}
		
		log.info("{}", moneyHistory);
		moneyHistoryRepository.save(moneyHistory);
	}


}
