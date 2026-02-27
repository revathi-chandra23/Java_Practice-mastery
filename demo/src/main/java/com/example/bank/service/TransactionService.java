package com.example.bank.service;

import com.example.bank.entity.Transaction;
import com.example.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction deposit(String userName, Double amount) {
        return saveTransaction(userName, "DEPOSIT", amount, "Amount Deposited");
    }

    public Transaction withdraw(String userName, Double amount) {
        return saveTransaction(userName, "WITHDRAW", amount, "Amount Withdrawn");
    }

    public Transaction transfer(String userName, Double amount, String toUser) {
        return saveTransaction(userName, "TRANSFER", amount, "Transferred to: " + toUser);
    }

    public List<Transaction> getTransactionHistory(String userName) {
        return transactionRepository.findByUserName(userName);
    }

    private Transaction saveTransaction(String userName, String transactionType, Double amount, String description) {
        Transaction transaction = new Transaction();
        transaction.setUserName(userName);
        transaction.setType(transactionType);
        transaction.setAmount(amount);
        transaction.setDescription(description);
        transaction.setTransactionDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }
}
