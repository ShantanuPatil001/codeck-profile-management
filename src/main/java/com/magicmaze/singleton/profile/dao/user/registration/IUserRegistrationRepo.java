package com.magicmaze.singleton.profile.dao.user.registration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.magicmaze.singleton.profile.dao.pojo.UserRegistration;

public interface IUserRegistrationRepo extends MongoRepository<UserRegistration, String> {
	
	@Query("{emailId:'?0'}")
	public UserRegistration findItemByEmailId(String emailId);
}
