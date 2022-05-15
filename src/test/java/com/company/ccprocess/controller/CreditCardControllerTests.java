package com.company.ccprocess.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.ccprocess.model.CreditCard;
import com.company.ccprocess.service.ICreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CreditCardController.class)
public class CreditCardControllerTests {
	
	 @Autowired
	 private MockMvc mvc;
	
	@MockBean
	private ICreditCardService creditCardService;
	
	
	
	@Before
    public void setUp() throws Exception {
    }

	
	 @Test
	 public void whenAddCard_thenCreateCard() throws Exception {
	        CreditCard card = new CreditCard();
	        card.setName("John");
	        card.setNumber(5381491217556736L);
	        card.setBalance(0.00);
	        card.setLimit(1000000.00);
	        
	        ObjectMapper mapper = new ObjectMapper();
	        String JsonCard = mapper.writeValueAsString(card);
	        given(creditCardService.addNewCard(Mockito.any())).willReturn(card);
	        

	        mvc.perform(post("/creditcard/addNewCard").contentType(MediaType.APPLICATION_JSON).content(JsonCard)).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("John")));
	        
	        verify(creditCardService, VerificationModeFactory.times(1)).addNewCard(Mockito.any());
	        
	        reset(creditCardService);
	    }
	 
	 
	 @Test
	 public void whenfetchCard_thenGetAllCards() throws Exception {
		 
	        CreditCard card = new CreditCard();
	        card.setName("John");
	        card.setNumber(5181975718047403L);
	        card.setBalance(0.00);
	        card.setLimit(1000000.00);
	        
	        CreditCard card1 = new CreditCard();
	        card1.setName("Alex");
	        card1.setNumber(5204571199083364L);
	        card1.setBalance(0.00);
	        card1.setLimit(1000000.00);
	        
	        CreditCard card2 = new CreditCard();
	        card2.setName("Bucan");
	        card2.setNumber(5322683667269933L);
	        card2.setBalance(0.00);
	        card2.setLimit(1000000.00);
	        
	        List<CreditCard> ccCardList =  Arrays.asList(card, card1, card2);
	        
	        
	        
	        
	        given(creditCardService.getAllCards()).willReturn(ccCardList);
	        

	        mvc.perform(get("/creditcard/getCards").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is(card.getName()))).andExpect(jsonPath("$[1].name", is(card1.getName())))
            .andExpect(jsonPath("$[2].name", is(card2.getName())));
	        
            verify(creditCardService, VerificationModeFactory.times(1)).getAllCards();
            
            reset(creditCardService);
	    }
}
