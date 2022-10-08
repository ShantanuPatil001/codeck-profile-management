package com.magicmaze.singleton.profile.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileCustomException {

	private String errorCode;
	private String message;
	private String description;

}
