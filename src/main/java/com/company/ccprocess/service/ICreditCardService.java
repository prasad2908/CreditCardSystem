package com.company.ccprocess.service;

import java.util.List;

import com.company.ccprocess.model.CreditCard;

public interface ICreditCardService {

	List<CreditCard> getAllCards();
	CreditCard addNewCard(CreditCard creditCard);
}
