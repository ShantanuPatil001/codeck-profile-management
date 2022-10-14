package com.magicmaze.singleton.profile.dao.user.registration;

import com.magicmaze.singleton.profile.exception.ProfileBaseException;

public interface IUserRegistration {

	public boolean createNewUserRegistration(String emailId, String userName, String mobileNumber, String apiName)
			throws ProfileBaseException;

	public boolean checkForDuplicateUser(String emailId, String userName, String mobileNumber, String apiName)
			throws ProfileBaseException;
	
	public boolean addNewUserToUserDetailsWithCredentials(String passsWord, String emailId, String apiName)
			throws ProfileBaseException;
}
