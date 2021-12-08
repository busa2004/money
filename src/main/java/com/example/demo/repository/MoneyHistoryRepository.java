package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.MoneyHistory;
import com.example.demo.domain.User;
import com.example.demo.dto.MoneyHistoryResponseDto;

public interface MoneyHistoryRepository extends JpaRepository<MoneyHistory,Long> {

	List<MoneyHistory> findAllByUser(User user);
	

}

