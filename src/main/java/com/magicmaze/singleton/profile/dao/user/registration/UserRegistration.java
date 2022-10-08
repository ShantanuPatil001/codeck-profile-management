package com.magicmaze.singleton.profile.dao.user.registration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("user-registration")
public class UserRegistration {

	 @Id
     private String id;
	 private String emailId;
	 private String userName;
	 private String mobileNumber;

}
