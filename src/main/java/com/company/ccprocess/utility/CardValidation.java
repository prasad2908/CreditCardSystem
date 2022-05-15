package com.company.ccprocess.utility;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class CardValidation {
	
	/** Luhn 10 validation to validate the card Number **/
	 public boolean isValidLuhnCardNumber(String cardNumber)
	    {
	        
	        int[] cardArray=new int[cardNumber.length()];
	 
	        for(int i=0;i<cardNumber.length();i++)
	        {
	            Character c= cardNumber.charAt(i);
	            cardArray[i]=  Integer.parseInt(c.toString());
	        }
	 
	        for(int i=cardArray.length-2;i>=0;i=i-2)
	        {
	            int num = cardArray[i];
	            num = num * 2;  
	            if(num>9)
	            {
	                num = num%10 + num/10;  
	            }
	            cardArray[i]=num;
	        }
	 
	        int sum = sumDigits(cardArray);  
	 
	        System.out.println(sum);
	 
	        if(sum%10==0)  
	        {
	            return true;
	        }
	 
	        return false;
	 
	    }
	 
	 private int sumDigits(int[] arr)
	    {
	        return Arrays.stream(arr).sum();
	    }

}
