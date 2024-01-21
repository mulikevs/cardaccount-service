package com.sitemapdev.cardaccountservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sitemapdev.cardaccountservice.entity.Account;
import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.service.AccountService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        log.info("Fetching all accounts");
        List<Account> accounts = accountService.getAllAccounts();
        log.debug("Fetched {} accounts", accounts.size());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        log.info("Fetching account by ID: {}", accountId);
        Account account = accountService.getAccountById(accountId);

        if (account != null) {
            log.debug("Fetched account: {}", account);
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            log.warn("Account with ID {} not found", accountId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        log.info("Creating account: {}", account);
        Account createdAccount = accountService.createAccount(account);
        log.debug("Created account: {}", createdAccount);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        log.info("Updating account with ID {}: {}", accountId, account);
        Account updatedAccount = accountService.updateAccount(accountId, account);
        log.debug("Updated account: {}", updatedAccount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        log.info("Deleting account with ID: {}", accountId);
        accountService.deleteAccount(accountId);
        log.debug("Account with ID {} deleted", accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{accountId}/cards")
    public ResponseEntity<List<Card>> getCardsByAccountId(@PathVariable Long accountId) {
        log.info("Fetching cards for account with ID: {}", accountId);
        List<Card> cards = accountService.getCardsByAccountId(accountId);
        log.debug("Fetched {} cards for account with ID {}", cards.size(), accountId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
}
