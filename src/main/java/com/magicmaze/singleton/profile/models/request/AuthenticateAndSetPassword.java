package com.magicmaze.singleton.profile.models.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticateAndSetPassword {
	
	@Schema(example = "demotest1@dispostable.com")
	private String emailId;
	@Schema(example = "passWord@123")
	private String passWord;
	@Schema(example = "654321")
	private String mobileOTP;

}
