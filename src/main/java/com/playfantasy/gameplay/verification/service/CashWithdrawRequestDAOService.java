package com.playfantasy.gameplay.verification.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unchecked")
public class CashWithdrawRequestDAOService {

	@PersistenceContext
	private EntityManager entityManager;


	public List<Integer> contestsWonByUser(int user_id) {

		List<Integer> totalContest = new ArrayList<Integer>();

		List<Integer> Contest_user_won_before_Archive;

		List<Integer> Contest_user_won_afterArchive;

		Query query1 = entityManager
				.createNativeQuery("select DISTINCT sourceid from cash_transaction where uid=5024 and txn_head=3");

		Contest_user_won_afterArchive = query1.getResultList();

		for (int i = 0; i < Contest_user_won_afterArchive.size(); i++) {
			totalContest.add(Contest_user_won_afterArchive.get(i));
		}

		Query query2 = entityManager
				.createNativeQuery("select DISTINCT sourceid from ar_cash_transaction where uid=5024 and txn_head=3");

		Contest_user_won_before_Archive = query2.getResultList();

		for (int j = 0; j < Contest_user_won_before_Archive.size(); j++) {
			totalContest.add(Contest_user_won_before_Archive.get(j));
		}

		System.out.println("contest won by user");
		for (int j1 = 0; j1 < totalContest.size(); j1++) {
			System.out.println(totalContest.get(j1));

		}
		return totalContest;

	}

	public List<BigInteger> getWithdrawIDs() {

		List<BigInteger> WithdrawalsUserId;

		Query query = entityManager
				.createNativeQuery("select id from cash_withdraw_request where type in (0,1) and status=1 and user_id>1000 ");

		WithdrawalsUserId = query.getResultList();

		return WithdrawalsUserId;

	}

	public List<Integer> contestWonByUserId(int user_id) {
		
		List<Integer> totalContest = new ArrayList<Integer>();
        List<Integer> Contest_user_won_before_Archive;
        List<Integer> Contest_user_won_afterArchive;

		Query query1 = entityManager
				.createNativeQuery("select DISTINCT sourceid from cash_transaction where txn_head=3 and uid="+user_id);

		Contest_user_won_afterArchive = query1.getResultList();

		for (int i = 0; i < Contest_user_won_afterArchive.size(); i++) {
			totalContest.add(Contest_user_won_afterArchive.get(i));
		}

		Query query2 = entityManager
				.createNativeQuery("select DISTINCT sourceid from ar_cash_transaction where txn_head=3 and uid="+user_id);

		Contest_user_won_before_Archive = query2.getResultList();

		for (int j = 0; j < Contest_user_won_before_Archive.size(); j++) {
			totalContest.add(Contest_user_won_before_Archive.get(j));
		}

		return totalContest;

	}

	public String gamePlayCheck(int user_id) {
		
		List<Integer> totalContest = new ArrayList<Integer>();
		ArrayList<Integer> fraudContest = new ArrayList<Integer>();

        List<BigInteger> userReferrals;
        List<Integer> Contest_user_won_before_Archive;
        List<Integer> Contest_user_won_afterArchive;

		int fairContestCount = 0;
		int referral_registration_count = 0;
		String status = null;
		
		
		Query query = entityManager
				.createNativeQuery("select referral_id from player_referral_details where referred_id=" + user_id);

		userReferrals = query.getResultList();

		Query query1 = entityManager.createNativeQuery(
				"select DISTINCT sourceid from cash_transaction where txn_head=3 and uid=" + user_id);

		Contest_user_won_afterArchive = query1.getResultList();

		for (int i = 0; i < Contest_user_won_afterArchive.size(); i++) {
			totalContest.add(Contest_user_won_afterArchive.get(i));
		}

		Query query2 = entityManager.createNativeQuery(
				"select DISTINCT sourceid from ar_cash_transaction where txn_head=3 and uid=" + user_id);

		Contest_user_won_before_Archive = query2.getResultList();

		for (int j = 0; j < Contest_user_won_before_Archive.size(); j++) {
			totalContest.add(Contest_user_won_before_Archive.get(j));
		}

		int no_of_total_contest = totalContest.size();

		for (int q = 0; q < totalContest.size(); q++) {

			List<BigInteger> totalUsers = new ArrayList<BigInteger>();
			List<BigInteger> totalUsersAfterArchive;
			List<BigInteger> totalUsersBeforeArchive;

			Query query3 = entityManager.createNativeQuery(
					"select user_id from contest_registrations where contest_id=" + totalContest.get(q));

			totalUsersAfterArchive = query3.getResultList();

			for (int i1 = 0; i1 < totalUsersAfterArchive.size(); i1++) {
				totalUsers.add(totalUsersAfterArchive.get(i1));
			}

			Query query4 = entityManager.createNativeQuery(
					"select user_id from ar_contest_registrations where contest_id=" + totalContest.get(q));

			totalUsersBeforeArchive = query4.getResultList();

			for (int i2 = 0; i2 < totalUsersBeforeArchive.size(); i2++) {
				totalUsers.add(totalUsersBeforeArchive.get(i2));
			}

			int total_contest_registrations = totalUsers.size();

			for (int k1 = 0; k1 < totalUsers.size(); k1++) {

				for (int k = 0; k < userReferrals.size(); k++) {

					if (userReferrals.get(k).equals(totalUsers.get(k1))) {

						referral_registration_count++;

					}

				}

			}

			if (referral_registration_count < total_contest_registrations / 2 || referral_registration_count == 0) {
				fairContestCount++;
				

			}

			else {


				fraudContest.add(totalContest.get(q));

			}

			referral_registration_count = 0;

		}

		if (fairContestCount == no_of_total_contest && referral_registration_count == 0) {

			status = "true";
			return status;

		}

		else {

			Float amountPayed = 0f;
			Float amountWon = 0f;
			List<BigDecimal> bonusAllowed;
			List<BigInteger> visibility;
			int pluscnt=0;
			int negcnt=0;

			for (int n = 0; n < fraudContest.size(); n++) {
				System.out.println(fraudContest.get(n));

				Query query4 = entityManager
						.createNativeQuery("select visibility_id from contest where id =" + fraudContest.get(n));

				visibility = query4.getResultList();
				
				
				int contest_visibility=visibility.get(0).intValueExact();
				int bonus_allowed=0;
				
				if (contest_visibility==1) {

					Query query5 = entityManager
							.createNativeQuery("select bonus_allowed from contest where id =" + fraudContest.get(n));

					bonusAllowed = query5.getResultList();
					
					
                bonus_allowed=bonusAllowed.get(0).intValueExact();

					if (bonus_allowed==0) {
						status = "PASSED";
						System.out.println(" contest " + fraudContest.get(n) + " visibility " + contest_visibility + " bonus " + bonus_allowed );

						continue;
					} 
					else {

						Query query6 = entityManager
								.createNativeQuery("select sum(txn_amt) from cash_transaction where uid=" + user_id
										+ " and txn_head=1 and sourceid=" + fraudContest.get(n));

						List<Float> list2 = query6.getResultList();
						for (int g2 = 0; g2 < list2.size(); g2++) {
							amountPayed = list2.get(g2);
						}

						Query query7 = entityManager
								.createNativeQuery("select sum(txn_amt) from cash_transaction where uid=" + user_id
										+ " and  txn_head=3 and sourceid=" + fraudContest.get(n));

						List<Float> list3 = query7.getResultList();
						for (int g3 = 0; g3 < list3.size(); g3++) {
							amountWon = list3.get(g3);
						}

					}

				}

			else {

					status = "PASSED";

					return status;
				}

				float totalAmountPlayed = (amountPayed * 2);

				if (amountWon < totalAmountPlayed) {
					
					pluscnt++;
					
				}

				else {
					negcnt++;
					
				}
				
				
				System.out.println(" contest " + fraudContest.get(n) + " visibility " + visibility.get(0)+ " bonus " + bonusAllowed.get(0) + " amount played "+ totalAmountPlayed + " won " + amountWon);
			}
			
			if(negcnt==0) {
				status="PASSED";
			}
			else {
				status="FAILED";
			}

		}
		return status;
	}

	public List<BigInteger> getUserReferrals(int user_id) {

		List<BigInteger> userReferrals;

		Query query = entityManager
				.createNativeQuery("select referral_id from player_referral_details where referred_id=" + user_id);

		userReferrals = query.getResultList();

		System.out.println("referrals of users");
		for (int c = 0; c < userReferrals.size(); c++) {
			System.out.println(userReferrals.get(c));
		}

		return userReferrals;
	}

}