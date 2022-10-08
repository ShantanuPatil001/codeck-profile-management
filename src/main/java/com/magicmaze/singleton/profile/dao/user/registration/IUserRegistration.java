package com.magicmaze.singleton.profile.dao.user.registration;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRegistration extends MongoRepository<UserRegistration, String> {

	
}
