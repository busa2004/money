package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.dto.CategoryRequestDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.exception.CCategoryNotFoundException;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
	private final ModelMapper modelMapper;
	private final CategoryRepository categoryRepository;
	
	public CategoryResponseDto findById(Long categoryId) {
		return modelMapper.map(categoryRepository.findById(categoryId).orElseThrow(CCategoryNotFoundException::new), CategoryResponseDto.class);
	}
	
	public List<CategoryResponseDto> findAll() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryResponseDto> categoryResponseDtoList = categoryList.stream().map(p -> modelMapper.map(p, CategoryResponseDto.class)).collect(Collectors.toList());
		return categoryResponseDtoList;
	}

	public void create(CategoryRequestDto categoryRequest) {
		Category category = modelMapper.map(categoryRequest, Category.class);
		categoryRepository.save(category);
	}

	public void delete(Long categoryId) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(CCategoryNotFoundException::new);
		categoryRepository.delete(category);
	}
	
	public void update(Long categoryId, CategoryRequestDto categoryRequestDto) {
		Category category = categoryRepository.findById(categoryId).orElseThrow(CCategoryNotFoundException::new);
		category.setNm(categoryRequestDto.getNm());
		categoryRepository.save(category);
	}
	

}
