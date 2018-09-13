package com.playfantasy.gameplay.verification.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playfantasy.gameplay.verification.model.cash_withdraw_request;

public interface CashWithdrawRequestRepository extends JpaRepository<cash_withdraw_request, Integer> {

}
