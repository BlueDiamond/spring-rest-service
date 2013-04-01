package com.bd.spring.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author palani
 * converting from object to json will make duplicate json result when we have the getters and setters along with @JsonProperty
 * removing setters and getters fixed the issue
 */
public class User_ProfileEntry {
	@JsonProperty("Name")
	private String Name;
	@JsonProperty("Created_TS")
	private String Created_TS;
	@JsonProperty("Relationship_Status")
	private String Relationship_Status;
	@JsonProperty("Lives_in")
	private String Lives_in;
	@JsonProperty("Email_ID")
	private String Email_ID;
	@JsonProperty("Profile_ID")
	private Integer Profile_ID;
	@JsonProperty("Sex")
	private String Sex;
	@JsonProperty("Languages")
	private String Languages;

	@Override
	public String toString() {
		return "User_ProfileEntry [Name=" + Name + ", Created_TS=" + Created_TS + ", Relationship_Status=" + Relationship_Status + ", Lives_in=" + Lives_in
				+ ", Email_ID=" + Email_ID + ", Profile_ID=" + Profile_ID + ", Sex=" + Sex + ", Languages=" + Languages + "]";
	}

	public User_ProfileEntry(String name, String created_TS, String relationship_Status, String lives_in, String email_ID, Integer profile_ID, String sex,
			String languages) {
		super();
		Name = name;
		Created_TS = created_TS;
		Relationship_Status = relationship_Status;
		Lives_in = lives_in;
		Email_ID = email_ID;
		Profile_ID = profile_ID;
		Sex = sex;
		Languages = languages;
	}

}
