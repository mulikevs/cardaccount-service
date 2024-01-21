package com.sitemapdev.cardaccountservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitemapdev.cardaccountservice.entity.Card;
import com.sitemapdev.cardaccountservice.repository.CardRepository;
import com.sitemapdev.cardaccountservice.service.CardService;


@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getCardsByAccountId(Long accountId) {
        return cardRepository.findByAccountId(accountId);
    }

    @Override
    public Card createCard(Card card) {
        // Implement create logic
        return cardRepository.save(card);
    }

    @Override
    public Card updateCard(Long cardId, Card card) {
        // Implement update logic
        card.setId(cardId);
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(Long cardId) {
        // Implement delete logic
        cardRepository.deleteById(cardId);
    }
}

