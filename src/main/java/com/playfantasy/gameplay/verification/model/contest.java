package com.playfantasy.gameplay.verification.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class contest {
	
	@Id
	private int id;
	
	private int status;
	private int min_players;
	private int max_players;
	private int entry_fee;
	private int visibility_id;
    private int bonus_allowed;
    
    protected contest() {
    	
    }

	public contest(int status, int min_players, int max_players, int entry_fee, int visibility_id, int bonus_allowed) {
		super();
		this.status = status;
		this.min_players = min_players;
		this.max_players = max_players;
		this.entry_fee = entry_fee;
		this.visibility_id = visibility_id;
		this.bonus_allowed = bonus_allowed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMin_players() {
		return min_players;
	}

	public void setMin_players(int min_players) {
		this.min_players = min_players;
	}

	public int getMax_players() {
		return max_players;
	}

	public void setMax_players(int max_players) {
		this.max_players = max_players;
	}

	public int getEntry_fee() {
		return entry_fee;
	}

	public void setEntry_fee(int entry_fee) {
		this.entry_fee = entry_fee;
	}

	public int getVisibility_id() {
		return visibility_id;
	}

	public void setVisibility_id(int visibility_id) {
		this.visibility_id = visibility_id;
	}

	public int getBonus_allowed() {
		return bonus_allowed;
	}

	public void setBonus_allowed(int bonus_allowed) {
		this.bonus_allowed = bonus_allowed;
	}

	@Override
	public String toString() {
		return "contest [id=" + id + ", status=" + status + ", min_players=" + min_players + ", max_players="
				+ max_players + ", entry_fee=" + entry_fee + ", visibility_id=" + visibility_id + ", bonus_allowed="
				+ bonus_allowed + "]";
	}
    
    
}
