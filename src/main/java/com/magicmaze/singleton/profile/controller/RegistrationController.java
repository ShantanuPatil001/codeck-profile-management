package com.magicmaze.singleton.profile.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicmaze.singleton.profile.exception.ProfileBaseException;
import com.magicmaze.singleton.profile.models.ResponsePayload;
import com.magicmaze.singleton.profile.models.request.AuthenticateAndSetPassword;
import com.magicmaze.singleton.profile.models.request.CreateNewUser;
import com.magicmaze.singleton.profile.service.registration.IRegistrationService;

@RestController("/registration")
public class RegistrationController {

	@Autowired
	private IRegistrationService registrationImpl;

	@PostMapping("/createNewUser")
	public ResponseEntity<ResponsePayload> createNewUser(@RequestBody CreateNewUser user) throws ProfileBaseException {
		ResponsePayload response = new ResponsePayload();
		Map<String, Object> data = registrationImpl.createNewUserRegistration(user.getEmailId(), user.getUserName(),
				user.getMobileNumber(), "createNewUser");
		response.setCode("000");
		response.setData(data);
		response.setHttpErrorCode(HttpStatus.OK);
		return new ResponseEntity<ResponsePayload>(response, response.getHttpErrorCode());
	}

	@PostMapping("/authenticateAndSetPassword")
	public ResponseEntity<ResponsePayload> authenticateAndSetPassword(@RequestBody AuthenticateAndSetPassword auth)
			throws ProfileBaseException {
		ResponsePayload response = new ResponsePayload();
		Map<String, Object> data = registrationImpl.authenticateUserAndSetPassword(auth.getEmailId(),
				auth.getPassWord(), "authenticateAndSetPassword");
		response.setCode("000");
		response.setData(data);
		response.setHttpErrorCode(HttpStatus.OK);
		return new ResponseEntity<ResponsePayload>(response, response.getHttpErrorCode());
	}

}
