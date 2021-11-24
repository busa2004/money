package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.common.CommonResponse;
import com.example.demo.common.CommonResult;
import com.example.demo.common.ListResult;
import com.example.demo.common.SingleResult;
import com.example.demo.dto.MoneyDto;

@Service
public class ResponseService {
	
	public <T> SingleResult<T> getSingleResult(T data){
		SingleResult<T> result = new SingleResult<>();
		result.setData(data);
		setSuccessResult(result);
		return result;
	}
	
	public <T> ListResult<T> getListResult(List<T> list){
		ListResult<T> result = new ListResult<>();
		result.setData(list);
		setSuccessResult(result);
		return result;
	}
	
	public CommonResult getSuccesResult() {
		CommonResult result = new CommonResult();
		setSuccessResult(result);
		return result;
	}
	
	public CommonResult getFailResult() {
		CommonResult result = new CommonResult();
		setFailResult(result);
		return result;
	}
	
	public CommonResult getFailResult(String msg) {
		CommonResult result = new CommonResult();
		setFailResult(result,msg);
		return result;
	}

	private void setSuccessResult(CommonResult result) {
		result.setSuccess(true);
		result.setCode(CommonResponse.SUCCESS.getCode());
		result.setMsg(CommonResponse.SUCCESS.getMsg());
	}
	
	private void setFailResult(CommonResult result) {
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(CommonResponse.FAIL.getMsg());
	}
	
	private void setFailResult(CommonResult result, String msg) {
		result.setSuccess(false);
		result.setCode(CommonResponse.FAIL.getCode());
		result.setMsg(msg);
	}
	
	
}
