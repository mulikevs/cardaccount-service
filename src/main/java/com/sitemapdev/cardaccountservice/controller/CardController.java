package com.sitemapdev.cardaccountservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.service.CardService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/by-account/{accountId}")
    public ResponseEntity<List<Card>> getCardsByAccountId(@PathVariable Long accountId) {
        log.info("Fetching cards for account with ID: {}", accountId);
        List<Card> cards = cardService.getCardsByAccountId(accountId);
        log.debug("Fetched {} cards for account with ID {}", cards.size(), accountId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        log.info("Creating card: {}", card);
        Card createdCard = cardService.createCard(card);
        log.debug("Created card: {}", createdCard);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody Card card) {
        log.info("Updating card with ID {}: {}", cardId, card);
        Card updatedCard = cardService.updateCard(cardId, card);
        log.debug("Updated card: {}", updatedCard);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
        log.info("Deleting card with ID: {}", cardId);
        cardService.deleteCard(cardId);
        log.debug("Card with ID {} deleted", cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
