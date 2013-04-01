package com.bd.spring.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author palani
 * converting from object to json will make duplicate json result when we have the getters and setters along with @JsonProperty
 * removing setters and getters fixed the issue
 */
public class BdJsonResponse {
	@JsonProperty("UserProfileResponse")
	private UserProfileResponse UserProfileResponse;

	public BdJsonResponse(com.bd.spring.rest.domain.UserProfileResponse userProfileResponse) {
		super();
		UserProfileResponse = userProfileResponse;
	}

	@Override
	public String toString() {
		return "BdJsonResponse [UserProfileResponse=" + UserProfileResponse + "]";
	}
	
	
}
