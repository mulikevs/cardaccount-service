package com.sitemapdev.cardaccountservice.service;

import java.util.List;

import com.sitemapdev.cardaccountservice.entity.Card;

public interface CardService {
    List<Card> getCardsByAccountId(Long accountId);
    Card createCard(Card card);
    Card updateCard(Long cardId, Card card);
    void deleteCard(Long cardId);
}
