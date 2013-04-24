package com.bd.spring.rest.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bd.mybatis.bean.UserProfile;
import com.bd.mybatis.dbservice.UserProfileDBService;
import com.bd.spring.rest.domain.BdJsonResponse;
import com.bd.spring.rest.domain.UserProfileResponse;
import com.bd.spring.rest.domain.User_ProfileEntry;

@Controller
@RequestMapping("/rest")
public class UserProfileRestController {
	private static Logger logger = LoggerFactory.getLogger(UserProfileRestController.class);

	@Autowired
	@Qualifier("userProfileDBService")
	UserProfileDBService userProfileDBService;

	@RequestMapping(value = "/userprofiles", method = RequestMethod.GET)
	public @ResponseBody
	BdJsonResponse getAllUserProfile() {
		logger.debug("entering getAllUserProfile rest service...");

		BdJsonResponse bdJsonResponse = getMockBdJsonResponse();

		logger.debug("successfully returning getAllUserProfile rest service...");

		return bdJsonResponse;

	}

	@RequestMapping(value = "/createuserprofile", method = RequestMethod.POST)
	public @ResponseBody
	// int createUserProfile() {
	int createUserProfile(@RequestBody User_ProfileEntry userProfileEntry) {
		logger.debug("entering createUserProfile rest service...");

		int rowsCreated = 0;
		try {

			UserProfile userProfile = new UserProfile();
			Timestamp ts = new Timestamp(Calendar.getInstance().getTimeInMillis());
			userProfile.setCreatedTS(ts);
			userProfile.setEmailID(userProfileEntry.getEmail_ID());
			userProfile.setLanguages(userProfileEntry.getLanguages());
			userProfile.setLivesIn(userProfileEntry.getLives_in());
			userProfile.setName(userProfileEntry.getName());
			userProfile.setProfileID(userProfileEntry.getProfile_ID());
			userProfile.setRelationshipStatus(userProfileEntry.getRelationship_Status());
			userProfile.setSex(userProfileEntry.getSex());

			rowsCreated = userProfileDBService.createUserProfile(userProfile);
		} catch (Exception e) {
			logger.error("Exception received: ", e);
		}

		logger.debug("successfully created UserProfile in rest service...");

		return rowsCreated;

	}

	private BdJsonResponse getMockBdJsonResponse() {

		User_ProfileEntry userProfile1 = new User_ProfileEntry();
		userProfile1.setCreated_TS("2013-03-25T08:30:57.000-04:00");
		userProfile1.setEmail_ID("rpalanisamy@yahoo.com");
		userProfile1.setLanguages("English, Hindi, Tamil");
		userProfile1.setLives_in("Malvern, PA");
		userProfile1.setName("Palanisamy Ramamoorthy");
		userProfile1.setProfile_ID(101);
		userProfile1.setRelationship_Status("married");
		userProfile1.setSex("male");

		User_ProfileEntry userProfile2 = new User_ProfileEntry();
		userProfile2.setCreated_TS("2013-03-25T20:46:59.000-04:00");
		userProfile2.setEmail_ID("praharam@gmail.com");
		userProfile2.setLanguages("Spanish, English");
		userProfile2.setLives_in("Orlando, FL");
		userProfile2.setName("Brian Charles");
		userProfile2.setProfile_ID(102);
		userProfile2.setRelationship_Status("Single");
		userProfile2.setSex("male");

		List<User_ProfileEntry> userProfileList = new ArrayList<User_ProfileEntry>();
		userProfileList.add(userProfile1);
		userProfileList.add(userProfile2);

		UserProfileResponse userProfileResponse = new UserProfileResponse(userProfileList);
		BdJsonResponse bdJsonResponse = new BdJsonResponse(userProfileResponse);

		logger.debug("successfully returning getAllUserProfile rest service...bdJsonResponse: " + bdJsonResponse);

		return bdJsonResponse;

	}

}