package com.magicmaze.singleton.profile.models.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateNewUser {

	@Schema(example = "demotest1@dispostable.com")
	private String emailId;
	@Schema(example = "demotest123")
	private String userName;
	@Schema(example = "+91-9876543210")
	private String mobileNumber;
}
