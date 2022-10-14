package com.magicmaze.singleton.profile.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProfileBaseException extends Exception {

	private static final long serialVersionUID = 5722683428999476528L;
	private String errorCode;
	private String apiName;
	private Exception e;
	private ProfileCustomException customException;

}
