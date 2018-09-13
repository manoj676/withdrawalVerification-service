package com.playfantasy.gameplay.verification.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@Entity
public class cash_withdraw_request {
	
	@Id
	private int id;
	@ApiModelProperty
	private int user_id;
	
	private int amount;
	private int type;
	private int status;
	
	
	
	protected cash_withdraw_request() {
		
	}



	public cash_withdraw_request(int user_id, int amount, int type, int status) {
		super();
		this.user_id = user_id;
		this.amount = amount;
		this.type = type;
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getUser_id() {
		return user_id;
	}



	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "cash_withdraw_request [id=" + id + ", user_id=" + user_id + ", amount=" + amount + ", type=" + type
				+ ", status=" + status + "]";
	}
	
	
	
	

}
