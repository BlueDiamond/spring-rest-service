package com.bd.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bd.spring.rest.domain.BdJsonResponse;
import com.bd.spring.rest.domain.UserProfileResponse;
import com.bd.spring.rest.domain.User_ProfileEntry;

@Controller
@RequestMapping("/rest")
public class UserProfileRestController {
	private static Logger logger = LoggerFactory.getLogger(UserProfileRestController.class);

	@RequestMapping(value = "/userprofiles", method = RequestMethod.GET)
	public @ResponseBody
	BdJsonResponse getAllUserProfile() {
		logger.debug("entering getAllUserProfile rest service...");

		BdJsonResponse bdJsonResponse = getMockBdJsonResponse();

		logger.debug("successfully returning getAllUserProfile rest service...");

		return bdJsonResponse;

	}

	private BdJsonResponse getMockBdJsonResponse() {
		User_ProfileEntry userProfile1 = new User_ProfileEntry("Palanisamy Ramamoorthy", "2013-03-25T08:30:57.000-04:00", "married", "Malvern, PA",
				"rpalanisamy@yahoo.com", 101, "male", "English, Hindi, Tamil");
		User_ProfileEntry userProfile2 = new User_ProfileEntry("Brian Charles", "2013-03-25T20:46:59.000-04:00", "Single", "Orlando, FL", "praharam@gmail.com",
				102, "male", "Spanish, English");

		List<User_ProfileEntry> userProfileList = new ArrayList<User_ProfileEntry>();
		userProfileList.add(userProfile1);
		userProfileList.add(userProfile2);

		UserProfileResponse userProfileResponse = new UserProfileResponse(userProfileList);
		BdJsonResponse bdJsonResponse = new BdJsonResponse(userProfileResponse);

		logger.debug("successfully returning getAllUserProfile rest service...bdJsonResponse: " + bdJsonResponse);

		return bdJsonResponse;

	}

}