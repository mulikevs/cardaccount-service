package com.sitemapdev.cardaccountservice;

import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.repository.CardRepository;
import com.sitemapdev.cardaccountservice.service.impl.CardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CardServiceImplTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardServiceImpl cardService;

    @Test
    void testGetCardsByAccountId() {
        // Mocking data
        List<Card> cards = Arrays.asList(
                new Card(1L, "alias1", null, "virtual"),
                new Card(2L, "alias2", null, "physical")
        );
        when(cardRepository.findByAccountId(1L)).thenReturn(cards);

        // Performing the test
        List<Card> result = cardService.getCardsByAccountId(1L);

        // Assertions
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testCreateCard() {
        // Mocking data
        Card cardToCreate = new Card(null, "alias", null, "virtual");
        Card createdCard = new Card(1L, "alias", null, "virtual");
        when(cardRepository.save(any(Card.class))).thenReturn(createdCard);

        // Performing the test
        Card result = cardService.createCard(cardToCreate);

        // Assertions
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("alias", result.getCardAlias());
        // Additional assertions based on your entity structure
    }

    @Test
    void testUpdateCard() {
        // Mocking data
        Card cardToUpdate = new Card(null, "alias", null, "virtual");
        Card updatedCard = new Card(1L, "updatedAlias", null, "virtual");
        when(cardRepository.save(any(Card.class))).thenReturn(updatedCard);

        // Performing the test
        Card result = cardService.updateCard(1L, cardToUpdate);

        // Assertions
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("updatedAlias", result.getCardAlias());
        // Additional assertions based on your entity structure
    }

    @Test
    void testDeleteCard() {
        // Performing the test
        cardService.deleteCard(1L);

        // Verifying that deleteById method is called
        verify(cardRepository).deleteById(1L);
    }
}
