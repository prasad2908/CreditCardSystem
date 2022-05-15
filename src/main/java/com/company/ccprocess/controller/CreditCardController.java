package com.company.ccprocess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ccprocess.model.CreditCard;
import com.company.ccprocess.service.ICreditCardService;

@CrossOrigin(origins="*")
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
	public ResponseEntity<?> addNewCard(@RequestBody CreditCard creditCard)
	{
	    CreditCard card = creditCardService.addNewCard(creditCard);
	    if(card != null) {
		 return ResponseEntity.ok(card);
	    }
	    //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    return new ResponseEntity<Object>(new Error("Card Number Is Not Valid"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
