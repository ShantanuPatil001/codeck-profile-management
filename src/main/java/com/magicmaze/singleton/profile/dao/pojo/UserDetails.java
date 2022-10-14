package com.magicmaze.singleton.profile.dao.pojo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Document("user-details")
@Data
public class UserDetails {

	@Id
	private String key;
	private String userName;
	private String passWord;
	private String emailId;
	private String mobileNumber;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdOn;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String lastLoggedIn;
	
}
