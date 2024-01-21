package com.sitemapdev.cardaccountservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitemapdev.cardaccountservice.entity.Account;
import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.repository.AccountRepository;
import com.sitemapdev.cardaccountservice.service.AccountService;
import com.sitemapdev.cardaccountservice.service.CardService;

@Service
public class AccountServiceImpl implements AccountService {

	 @Autowired
	    private AccountRepository accountRepository;

	    @Autowired
	    private CardService cardService;

	    @Override
	    public List<Account> getAllAccounts() {
	        return accountRepository.findAll();
	    }

	    @Override
	    public Account getAccountById(Long accountId) {
	        return accountRepository.findById(accountId).orElse(null);
	    }

	    @Override
	    public Account createAccount(Account account) {
	        // Implement create logic
	        return accountRepository.save(account);
	    }

	    @Override
	    public Account updateAccount(Long accountId, Account account) {
	        // Implement update logic
	        account.setId(accountId);
	        return accountRepository.save(account);
	    }

	    @Override
	    public void deleteAccount(Long accountId) {
	        // Implement delete logic
	        accountRepository.deleteById(accountId);
	    }

	    @Override
	    public List<Card> getCardsByAccountId(Long accountId) {
	        return cardService.getCardsByAccountId(accountId);
	    }
}
