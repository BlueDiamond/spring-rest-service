package com.bd.spring.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

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
