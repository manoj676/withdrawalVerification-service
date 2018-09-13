package com.playfantasy.gameplay.verification.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.playfantasy.gameplay.verification.service.CashWithdrawRequestDAOService;

@RestController
public class CashWithdrawRequestController {


	
	@Autowired
	private CashWithdrawRequestDAOService service;

	@GetMapping("/withdraw/bank/userid")
	public List<?> getBankWithdrawIds() {
		List<?> list = service.getWithdrawIDs();
		return list;
	}
	
	@GetMapping(path="/withdraw/user/referral/{user_id}")
	public List<?> getUserReferrals(@PathVariable int user_id){
		 List<BigInteger> lis = service.getUserReferrals(user_id);
		return lis;
		
	}
	
	@GetMapping(path="/withdraw/user/woncontest/{user_id}")
	public List<Integer> getUserWonContests(@PathVariable int user_id){
		List<Integer> li = service.contestsWonByUser(user_id);
		return li;
		
	}
	
	@GetMapping(path="/withdraw/usercheck/{user_id}")
	public String testContestGameplay(@PathVariable  int user_id){
		String fraud = service.gamePlayCheck(user_id);
		return fraud;
		
	}
	
}