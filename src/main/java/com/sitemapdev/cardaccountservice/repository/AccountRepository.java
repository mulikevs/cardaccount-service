package com.sitemapdev.cardaccountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitemapdev.cardaccountservice.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
 // additional query methods if needed
}