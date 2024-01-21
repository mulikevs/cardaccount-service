package com.sitemapdev.cardaccountservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.service.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/by-account/{accountId}")
    public ResponseEntity<List<Card>> getCardsByAccountId(@PathVariable Long accountId) {
        List<Card> cards = cardService.getCardsByAccountId(accountId);
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> updateCard(@PathVariable Long cardId, @RequestBody Card card) {
        Card updatedCard = cardService.updateCard(cardId, card);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
