package com.example.bank.controller;

import com.example.bank.entity.Transaction;
import com.example.bank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public Transaction deposit(@RequestParam Double amount,@RequestParam String userName) {

        return transactionService.deposit(userName, amount);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestParam Double amount,@RequestParam String userName) {

        return transactionService.withdraw(userName, amount);
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestParam Double amount,
                                @RequestParam String toUser,
                                @RequestParam String userName) {
        return transactionService.transfer(userName, amount, toUser);
    }

    @GetMapping("/history")
    public List<Transaction> getTransactionHistory(@RequestParam String userName) {

        return transactionService.getTransactionHistory(userName);
    }
}
