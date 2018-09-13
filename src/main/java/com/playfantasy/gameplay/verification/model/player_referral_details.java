package com.playfantasy.gameplay.verification.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class player_referral_details {
	
	@Id
	private BigInteger id;
	
	private BigInteger referral_id;
	private BigInteger referred_id;
	
	
	protected player_referral_details() {
		
	}


	public player_referral_details(BigInteger referral_id, BigInteger referred_id) {
		super();
		this.referral_id = referral_id;
		this.referred_id = referred_id;
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
		this.id = id;
	}


	public BigInteger getReferral_id() {
		return referral_id;
	}


	public void setReferral_id(BigInteger referral_id) {
		this.referral_id = referral_id;
	}


	public BigInteger getReferred_id() {
		return referred_id;
	}


	public void setReferred_id(BigInteger referred_id) {
		this.referred_id = referred_id;
	}


	@Override
	public String toString() {
		return "player_referral_details [id=" + id + ", referral_id=" + referral_id + ", referred_id=" + referred_id
				+ "]";
	}
	
	

}
