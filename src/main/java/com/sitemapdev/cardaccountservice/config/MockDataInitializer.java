package com.sitemapdev.cardaccountservice.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.sitemapdev.cardaccountservice.entity.Account;
import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.repository.AccountRepository;
import com.sitemapdev.cardaccountservice.repository.CardRepository;

import java.util.Arrays;

@Component
public class MockDataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    public MockDataInitializer(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create mock data for accounts
        Account account1 = Account.builder().iban("IBAN111").bicSwift("SWIFT111").clientId(1L).build();
        Account account2 = Account.builder().iban("IBAN222").bicSwift("SWIFT222").clientId(2L).build();
        Account account3 = Account.builder().iban("IBAN333").bicSwift("SWIFT333").clientId(1L).build();
        Account account4 = Account.builder().iban("IBAN444").bicSwift("SWIFT444").clientId(2L).build();
        Account account5 = Account.builder().iban("IBAN555").bicSwift("SWIFT555").clientId(1L).build();

        // Save accounts to the database
        accountRepository.saveAll(Arrays.asList(account1, account2, account3, account4, account5));

        // Create mock data for cards
        Card card1 = Card.builder().cardAlias("CardAlias1").account(account1).cardType("VIRTUAL").build();
        Card card2 = Card.builder().cardAlias("CardAlias2").account(account2).cardType("PHYSICAL").build();
        Card card3 = Card.builder().cardAlias("CardAlias3").account(account3).cardType("VIRTUAL").build();
        Card card4 = Card.builder().cardAlias("CardAlias4").account(account4).cardType("PHYSICAL").build();
        Card card5 = Card.builder().cardAlias("CardAlias5").account(account5).cardType("VIRTUAL").build();

        // Save cards to the database
        cardRepository.saveAll(Arrays.asList(card1, card2, card3, card4, card5));
    }
}

