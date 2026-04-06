package com.revathiPractice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revathiPractice.Service.TransactionService;
import com.revathiPractice.request.TransferRequest;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@PostMapping("/deposit")
	@PreAuthorize("hasRole('USER')")
	public String deposit(@RequestBody double amount) {
		return transactionService.deposit(amount);
	}

	@PostMapping("/withdraw")
	@PreAuthorize("hasRole('USER')")
	public String withdraw(@RequestBody double amount) {
		return transactionService.withdraw(amount);
	}

	@PostMapping("/transfer")
	@PreAuthorize("hasRole('USER')")
	public String transfer(@RequestBody TransferRequest transferRequest) {
		return transactionService.transfer(transferRequest.getAmount(), transferRequest.getAmount());
	}
}
