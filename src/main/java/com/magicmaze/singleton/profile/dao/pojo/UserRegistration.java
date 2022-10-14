package com.magicmaze.singleton.profile.dao.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document("user-registration")
public class UserRegistration {

	 @Id
     private String key;
	 private String emailId;
	 private String userName;
	 private String mobileNumber;

}
