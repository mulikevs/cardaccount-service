package com.sitemapdev.cardaccountservice;

import com.sitemapdev.cardaccountservice.entity.Account;
import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.repository.AccountRepository;
import com.sitemapdev.cardaccountservice.service.impl.AccountServiceImpl;
import com.sitemapdev.cardaccountservice.service.CardService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CardService cardService;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void testGetAllAccounts() {
        // Mocking data
        List<Account> accounts = Arrays.asList(
                new Account(1L, "iban1", "bic1", 101L),
                new Account(2L, "iban2", "bic2", 102L)
        );
        when(accountRepository.findAll()).thenReturn(accounts);

        // Performing the test
        List<Account> result = accountService.getAllAccounts();

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testGetAccountById() {
        // Mocking data
        Account account = new Account(1L, "iban1", "bic1", 101L);
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        // Performing the test
        Account result = accountService.getAccountById(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("iban1", result.getIban());
        assertEquals("bic1", result.getBicSwift());
        assertEquals(101L, result.getClientId());
    }

    @Test
    void testCreateAccount() {
        // Mocking data
        Account accountToCreate = new Account(null, "iban3", "bic3", 103L);
        Account createdAccount = new Account(3L, "iban3", "bic3", 103L);
        when(accountRepository.save(any(Account.class))).thenReturn(createdAccount);

        // Performing the test
        Account result = accountService.createAccount(accountToCreate);

        // Assertions
        assertNotNull(result);
        assertEquals(3L, result.getId());
        assertEquals("iban3", result.getIban());
        assertEquals("bic3", result.getBicSwift());
        assertEquals(103L, result.getClientId());
    }

    @Test
    void testUpdateAccount() {
        // Mocking data
        Account accountToUpdate = new Account(null, "iban4", "bic4", 104L);
        Account updatedAccount = new Account(4L, "iban4", "bic4", 104L);
        when(accountRepository.save(any(Account.class))).thenReturn(updatedAccount);

        // Performing the test
        Account result = accountService.updateAccount(4L, accountToUpdate);

        // Assertions
        assertNotNull(result);
        assertEquals(4L, result.getId());
        assertEquals("iban4", result.getIban());
        assertEquals("bic4", result.getBicSwift());
        assertEquals(104L, result.getClientId());
    }

    @Test
    void testDeleteAccount() {
        // Performing the test
        accountService.deleteAccount(1L);

        // Verifying that deleteById method is called
        verify(accountRepository).deleteById(1L);
    }

    @Test
    void testGetCardsByAccountId() {
        // Mocking data
        List<Card> cards = Arrays.asList(
                new Card(1L, "alias1", null, "virtual"),
                new Card(2L, "alias2", null, "physical")
        );
        when(cardService.getCardsByAccountId(1L)).thenReturn(cards);

        // Performing the test
        List<Card> result = accountService.getCardsByAccountId(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
