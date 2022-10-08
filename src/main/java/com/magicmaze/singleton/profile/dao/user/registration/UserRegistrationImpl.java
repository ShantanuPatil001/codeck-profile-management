package com.magicmaze.singleton.profile.dao.user.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.magicmaze.singleton.profile.exception.ErrorMapConstants;
import com.magicmaze.singleton.profile.exception.ProfileBaseException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserRegistrationImpl {
	
	@Autowired
	private IUserRegistration userRegistration;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public boolean createNewUserRegistration(String emailId, String userName, String mobileNumber, String ApiName) throws ProfileBaseException {
		boolean isDuplicateUser = checkForDuplicateUser(emailId, userName, mobileNumber);
		log.error("Duplicate User check ::::: "+isDuplicateUser);
		if (isDuplicateUser) {
			UserRegistration user = UserRegistration.builder().userName(userName).emailId(emailId)
					.mobileNumber(mobileNumber).build();
			userRegistration.save(user);
			return true;
		} else 
			throw new ProfileBaseException(ErrorMapConstants.DUPLICATE_USER, ApiName, null, null);

	}
	
	public boolean checkForDuplicateUser(String emailId, String userName, String mobileNumber) {
		Query query = new Query().addCriteria(Criteria.where("emailId").is(emailId))
				.addCriteria(Criteria.where("userName").is(userName))
				.addCriteria(Criteria.where("mobileNumber").is(mobileNumber));
		List<UserRegistration> users = mongoTemplate.find(query, UserRegistration.class);
		if (users == null || users.isEmpty())
			return true;
		return false;
	}

}
