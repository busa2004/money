package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
	OperationNotAuthorized(6000, "Operation not authorized"),
	DuplicatedIdFound(6001,"Duplicate Id"),
	DuplicatedEmailFound(6002,"Duplicate Email"),
	UnrecognizedRole(6010,"Unrecognized Role"),
	UserNotFoundExcepiton(-999,"UserNotFoundException");
	
	private int code;
	private String description;
}
