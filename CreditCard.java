/* Name: Joseph Pham
 * Student Number: 045268141
 * August 3rd 2016
 * Assignment 3
 * 
 * */


import java.io.*;


public class CreditCard implements Serializable {
	
	CardValidation card ; 
	public long number ; 
	public boolean valid ; 
	
	//constructor 
	
	CreditCard()
	{
		valid = false ; 
		number = 0L ; 
		card = new CardValidation() ; 
	} 
	
	//constructor
	
	CreditCard(long n)
	{
		valid = false; 
		number = n ; 
	}

	public String toString()
	{
		return "Credit Card Number:"+ number +"  Valid number: " + valid ; 
	}

	public void checkValid()
	{
		valid = card.isValid(number) ; 
	}
}