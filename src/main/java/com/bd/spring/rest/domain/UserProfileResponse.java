package com.bd.spring.rest.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author palani
 * converting from object to json will make duplicate json result when we have the getters and setters along with @JsonProperty
 * removing setters and getters fixed the issue
 */
public class UserProfileResponse {
	@JsonProperty("User_Profile")
	private List<User_ProfileEntry> User_Profile;


	public UserProfileResponse(List<User_ProfileEntry> user_Profile) {
		super();
		User_Profile = user_Profile;
	}


	@Override
	public String toString() {
		return "UserProfileResponse [User_Profile=" + User_Profile + "]";
	}
}
