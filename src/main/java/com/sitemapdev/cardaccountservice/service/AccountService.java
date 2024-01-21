package com.sitemapdev.cardaccountservice.service;

import java.util.List;

import com.sitemapdev.cardaccountservice.entity.Account;
import com.sitemapdev.cardaccountservice.entity.Card;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long accountId);
    Account createAccount(Account account);
    Account updateAccount(Long accountId, Account account);
    void deleteAccount(Long accountId);
    List<Card> getCardsByAccountId(Long accountId);
}
