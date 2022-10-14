package com.magicmaze.singleton.profile.service.registration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magicmaze.singleton.profile.dao.user.registration.IUserRegistration;
import com.magicmaze.singleton.profile.exception.ErrorMapConstants;
import com.magicmaze.singleton.profile.exception.ProfileBaseException;

@Service
public class RegistrationServiceIMPL implements IRegistrationService{
	
	@Autowired
	private IUserRegistration userReg;

	@Override
	public Map<String, Object> createNewUserRegistration(String emailId, String userName, String mobileNumber,
			String apiName) throws ProfileBaseException {
		Map<String, Object> result = new HashMap<>();
		boolean isDuplicateUser = userReg.checkForDuplicateUser(emailId, userName, mobileNumber,apiName);
		if(isDuplicateUser) {
			if(userReg.createNewUserRegistration(emailId, userName, mobileNumber, apiName)) {
				result.put("registration", "success");
				result.put("flag", true);
				return result;
			}
		} else
			throw new ProfileBaseException(ErrorMapConstants.DUPLICATE_USER, apiName, null, null);
		return result;
	}

	@Override
	public Map<String, Object> authenticateUserAndSetPassword(String emailId, String passWord,
			String apiName) throws ProfileBaseException {
		Map<String, Object> result = new HashMap<>();
		if(userReg.addNewUserToUserDetailsWithCredentials(passWord, emailId, apiName)) {
			result.put("registration", "success");
			result.put("flag", true);
		}
		return result;
	}
	

}
