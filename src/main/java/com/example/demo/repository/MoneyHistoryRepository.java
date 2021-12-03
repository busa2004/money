package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.MoneyHistory;

public interface MoneyHistoryRepository extends JpaRepository<MoneyHistory,Long> {
	

}

