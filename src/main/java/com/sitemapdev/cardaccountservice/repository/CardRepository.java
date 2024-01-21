package com.sitemapdev.cardaccountservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitemapdev.cardaccountservice.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByAccountId(Long accountId);
}