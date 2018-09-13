package com.playfantasy.gameplay.verification.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class cash_transaction {
	
     @Id
	private int id;
     
     int uid;
     int txn_head;
     int txn_amount;
     int sourceid;
     
     protected cash_transaction() {
    	 
     }
     
     
	public cash_transaction(int uid, int txn_head, int txn_amount, int sourceid) {
		super();
		this.uid = uid;
		this.txn_head = txn_head;
		this.txn_amount = txn_amount;
		this.sourceid = sourceid;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUser_id() {
		return uid;
	}


	public void setUser_id(int user_id) {
		this.uid = user_id;
	}


	public int getTxn_head() {
		return txn_head;
	}


	public void setTxn_head(int txn_head) {
		this.txn_head = txn_head;
	}


	public int getTxn_amount() {
		return txn_amount;
	}


	public void setTxn_amount(int txn_amount) {
		this.txn_amount = txn_amount;
	}


	public int getSourceid() {
		return sourceid;
	}


	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}


	@Override
	public String toString() {
		return "cash_transaction [id=" + id + ", user_id=" + uid + ", txn_head=" + txn_head + ", txn_amount="
				+ txn_amount + ", sourceid=" + sourceid + "]";
	}
	
	
	
     
     
}
