package com.playfantasy.gameplay.verification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playfantasy.gameplay.verification.model.RestResponse;
import com.playfantasy.gameplay.verification.service.UserActionsDAOService;

@RestController
public class UsersActionsController {
	
	
	@Autowired
	UserActionsDAOService userActionDAOService;
	
	
	@PostMapping("/update/user/status/{user_id}")
	public RestResponse blockUser(@PathVariable int user_id) {
		RestResponse rest = userActionDAOService.blockUserId(user_id);
		return rest;
	}

}
