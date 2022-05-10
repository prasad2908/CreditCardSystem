package com.company.ccprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ccprocess.model.CreditCard;
import com.company.ccprocess.service.ICreditCardService;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	private ICreditCardService creditCardService;
	
	@GetMapping("/getCards")
	public ResponseEntity<List<CreditCard>> getAllCards()
	{
		return ResponseEntity.ok(creditCardService.getAllCards());
	}

	@PostMapping("/addNewCard")
	public ResponseEntity<CreditCard> addNewCard(@RequestBody CreditCard creditCard)
	{
		return ResponseEntity.ok(creditCardService.addNewCard(creditCard));
	}
	
}
