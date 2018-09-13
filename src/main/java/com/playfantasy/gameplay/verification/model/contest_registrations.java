package com.playfantasy.gameplay.verification.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class contest_registrations {
	
	@Id
	private BigInteger id;
	
	private BigInteger user_id;
	private BigInteger contest_id;
	
	protected contest_registrations() {
		
	}

	public contest_registrations(BigInteger user_id, BigInteger contest_id) {
		super();
		this.user_id = user_id;
		this.contest_id = contest_id;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getUser_id() {
		return user_id;
	}

	public void setUser_id(BigInteger user_id) {
		this.user_id = user_id;
	}

	public BigInteger getContest_id() {
		return contest_id;
	}

	public void setContest_id(BigInteger contest_id) {
		this.contest_id = contest_id;
	}

	@Override
	public String toString() {
		return "contest_registrations [id=" + id + ", user_id=" + user_id + ", contest_id=" + contest_id + "]";
	}
	
	

}
