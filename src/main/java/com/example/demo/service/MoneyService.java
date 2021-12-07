package com.example.demo.service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Money;
import com.example.demo.domain.User;
import com.example.demo.dto.MoneyRequestDto;
import com.example.demo.dto.MoneyResponseDto;
import com.example.demo.exception.CCategoryNotFoundException;
import com.example.demo.exception.CMoneyNotFoundException;
import com.example.demo.exception.CUserNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MoneyRepository;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MoneyService {
	
	private final ModelMapper modelMapper;
	private final MoneyRepository moneyRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	
	public List<MoneyResponseDto> findAllByUserId(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(CUserNotFoundException::new);
		List<Money> moneyList = moneyRepository.findAllByUser(user);
		return moneyList.stream().map(p -> modelMapper.map(p, MoneyResponseDto.class)).collect(Collectors.toList());
	}
	
	public MoneyResponseDto findById(Long moneyId) {
		Money money = moneyRepository.findById(moneyId).orElseThrow(CMoneyNotFoundException::new);
		MoneyResponseDto moneyResponseDto= modelMapper.map(money, MoneyResponseDto.class);
		return moneyResponseDto;
	}

	public void create(Principal principal, MoneyRequestDto moneyRequestDto) {
		Category category = categoryRepository.findById(moneyRequestDto.getCategoryId()).orElseThrow(CCategoryNotFoundException::new);
		User user = userRepository.findById(Long.parseLong(principal.getName())).orElseThrow(CUserNotFoundException::new);
		Money money = Money.builder().category(category).user(user).description(moneyRequestDto.getDescription()).build();
		moneyRepository.save(money);
	}

	public void delete(Long moneyId) {
		Money money = moneyRepository.findById(moneyId).orElseThrow(CMoneyNotFoundException::new);
		moneyRepository.delete(money);
	}
	
	public void update(Long moneyId, MoneyRequestDto moneyRequestDto) {
		Money money = moneyRepository.findById(moneyId).orElseThrow(CMoneyNotFoundException::new);
		money.setPrice(Optional.of(moneyRequestDto.getPrice()).orElse(money.getPrice()));
		money.setDescription(Optional.of(moneyRequestDto.getDescription()).orElse(money.getDescription()));
		moneyRepository.save(money);
	}

}
