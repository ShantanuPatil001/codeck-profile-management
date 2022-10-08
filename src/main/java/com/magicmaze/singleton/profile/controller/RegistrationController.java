package com.magicmaze.singleton.profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magicmaze.singleton.profile.dao.user.registration.UserRegistrationImpl;
import com.magicmaze.singleton.profile.exception.ProfileBaseException;
import com.magicmaze.singleton.profile.models.ResponsePayload;
import com.magicmaze.singleton.profile.models.request.CreateNewUser;

@RestController("/registration")
public class RegistrationController {
	
	@Autowired
	private UserRegistrationImpl registrationImpl;
	
	@PostMapping("/createNewUser")
	public ResponseEntity<ResponsePayload> createNewUser(@RequestBody CreateNewUser user) throws ProfileBaseException{
		ResponsePayload response = new ResponsePayload();
		boolean data = registrationImpl.createNewUserRegistration(user.getEmailId(), user.getUserName(), user.getMobileNumber(),"createNewUser");
		response.setCode("000");
		response.setData(data);
		response.setHttpErrorCode(HttpStatus.OK);
		return new ResponseEntity<ResponsePayload>(response, response.getHttpErrorCode());
	}
}
