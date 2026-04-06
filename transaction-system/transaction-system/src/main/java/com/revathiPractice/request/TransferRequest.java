package com.revathiPractice.request;

public class TransferRequest {
	private String toUsername;
	private double amount;

	// Constructor
	public TransferRequest() {
	}

	public TransferRequest(String toUsername, double amount) {
		this.toUsername = toUsername;
		this.amount = amount;
	}

	// Getter and Setter
	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
