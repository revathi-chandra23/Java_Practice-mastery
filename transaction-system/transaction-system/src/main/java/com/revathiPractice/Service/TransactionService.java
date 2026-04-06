package com.revathiPractice.Service;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {

	public String deposit(double amount) {
		// Deposit logic
		return "Deposited " + amount + " successfully!";
	}

	public String withdraw(double amount) {
		// Withdrawal logic
		return "Withdrew " + amount + " successfully!";
	}

	public String transfer(double amount, String toAccount) {
		// Transfer logic
		return "Transferred " + amount + " to " + toAccount + " successfully!";
	}

	public String transfer(double amount, double amount2) {
		// TODO Auto-generated method stub
		return null;
	}
}
