package com.magicmaze.singleton.profile.dao.user.registration;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.magicmaze.singleton.profile.dao.pojo.UserDetails;
import com.magicmaze.singleton.profile.dao.pojo.UserRegistration;
import com.magicmaze.singleton.profile.exception.ErrorMapConstants;
import com.magicmaze.singleton.profile.exception.ProfileBaseException;
import com.magicmaze.singleton.profile.security.BCryptPasswordEncod;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserRegistrationImpl implements IUserRegistration {

	@Autowired
	private IUserRegistrationRepo userRegistration;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private BCryptPasswordEncod encoder;

	@Override
	public boolean createNewUserRegistration(String emailId, String userName, String mobileNumber, String apiName)
			throws ProfileBaseException {
		try {
			UserRegistration user = UserRegistration.builder().userName(userName).emailId(emailId)
					.mobileNumber(mobileNumber).build();
			userRegistration.save(user);
			return true;
		} catch (Exception e) {
			log.error("createNewUserRegistration :: " + apiName + " ::: ", e);
			throw new ProfileBaseException(ErrorMapConstants.EXCEPTION, apiName, null, null);
		}
	}

	@Override
	public boolean checkForDuplicateUser(String emailId, String userName, String mobileNumber, String apiName)
			throws ProfileBaseException {
		Query query = new Query().addCriteria(Criteria.where("emailId").is(emailId))
				.addCriteria(Criteria.where("userName").is(userName))
				.addCriteria(Criteria.where("mobileNumber").is(mobileNumber));
		List<UserRegistration> users = mongoTemplate.find(query, UserRegistration.class);
		if (users == null || users.isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean addNewUserToUserDetailsWithCredentials(String passsWord, String emailId, String apiName)
			throws ProfileBaseException {
		UserRegistration user = getUserInfoFromRegistration(emailId);
		if (user != null) {
			UserDetails userD = new UserDetails();
			userD.setCreatedOn(Date.from(Instant.now()));
			userD.setEmailId(user.getEmailId());
			userD.setMobileNumber(user.getMobileNumber());
			userD.setPassWord(encoder.encode(passsWord));
			userD.setUserName(user.getUserName());
			mongoTemplate.save(userD);
			return true;
		} else {
			throw new ProfileBaseException(ErrorMapConstants.NO_SUCH_RECORD_FOUND, apiName, null, null);
		}
	}

	private UserRegistration getUserInfoFromRegistration(String emailID) {
		if (!StringUtils.isBlank(emailID)) {
			UserRegistration user = userRegistration.findItemByEmailId(emailID);
			if (user != null) {
				return user;
			}
		} else {
			throw new NullPointerException();
		}
		return null;
	}

}
