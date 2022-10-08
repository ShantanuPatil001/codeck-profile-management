package com.magicmaze.singleton.profile.models;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePayload {
	private String status;
	private String code;
	private String message;
	private String description;
	@JsonIgnore
	private HttpStatus httpErrorCode;
	private Object data;
}
