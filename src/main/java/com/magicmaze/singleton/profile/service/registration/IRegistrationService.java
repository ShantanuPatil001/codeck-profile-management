package com.magicmaze.singleton.profile.service.registration;

import java.util.Map;

import com.magicmaze.singleton.profile.exception.ProfileBaseException;

public interface IRegistrationService {

	public Map<String, Object> createNewUserRegistration(String emailId, String userName, String mobileNumber,
			String ApiName) throws ProfileBaseException;

	public Map<String, Object> authenticateUserAndSetPassword(String emailId, String passWord, String apiName)
			throws ProfileBaseException;

}
