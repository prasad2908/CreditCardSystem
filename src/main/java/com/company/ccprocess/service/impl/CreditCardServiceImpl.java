package com.company.ccprocess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.ccprocess.model.CreditCard;
import com.company.ccprocess.repository.ICreditCardRepository;
import com.company.ccprocess.service.ICreditCardService;

@Service
public class CreditCardServiceImpl implements ICreditCardService {
	
	@Autowired
	private ICreditCardRepository creditCardRepository;

	@Override
	public List<CreditCard> getAllCards() {
		
		return creditCardRepository.findAll();
	}

	@Override
	public CreditCard addNewCard(CreditCard creditCard) {
		
		return creditCardRepository.save(creditCard);
	}

}
