package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.CommonResult;
import com.example.demo.service.ResponseService;

import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {
	
	private final ResponseService responseService;
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	protected CommonResult defaultException(HttpServletRequest request, Exception e) {
		return responseService.getFailResult(e.getMessage());
	}
	
	@ExceptionHandler(CustomNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	protected CommonResult userNotFoundException(HttpServletRequest request, CustomNotFoundException e) {
		return responseService.getFailResult(e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
        return responseService.getFailResult(errors.toString());
    }
	
	 /***
     * 유저 이메일 로그인 실패 시 발생시키는 예외
     */
    @ExceptionHandler(EmailLoginFailedCException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult emailLoginFailedException(HttpServletRequest request, EmailLoginFailedCException e) {
        return responseService.getFailResult("로그인 실패");
    }
	
	
}
