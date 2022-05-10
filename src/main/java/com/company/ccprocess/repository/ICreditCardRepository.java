package com.company.ccprocess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.ccprocess.model.CreditCard;

public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {

}
