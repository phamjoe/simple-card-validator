/* Name: Joseph Pham
 * Student Number: 045268141
 * August 3rd 2016
 * Assignment 3
 * 
 * */

import java.util.List;
import java.util.ArrayList;
import java.lang.Long ; 


public class CardValidation {
	static int p ; 
	static int size  ; 
	static int c ; 
	
	public static void main(String[] args) {
		long cardNumber = 4012888888881881L;
		System.out.println(isValid(cardNumber));

	}

	public static Long eval(List<Long> list) {
		return list.stream().reduce(0L, (x, y) -> y + (10 * x));
	}

	public static Long evalRev(List<Long> list) {
		Long y = 0L;

		for (int i = list.size() - 1; i >= 0; i--) {
			y = list.get(i) + 10 * y;
		}

		return y;
	}

	public static List<Long> toDigits(long l) {

		// TODO to be implemented
		p = 0 ; 
		List<Long> toDigits = new ArrayList<Long>();
		
		while(l>0)
		{
			toDigits.add(l%10);
			l/=10;
			p++ ; 
		}
		
		if(p != 0 ){return toDigits;}
		
		return null;
	}
	

	public static List<Long> toDigitsReverse(long l) {

		List<Long> temp ;

		temp = toDigits(l); 

		size = temp.size() ; 

		return temp ; 

	}
	public static List<Long> doubleSecond(List<Long> list) {
		// TODO to be implemented
		
		c = 0 ; 
		List<Long> send=  new ArrayList<Long>();

		for(int i = 0 ; i < size ; i ++)
		{
			//save every other number in list
			if((i %2)==0 ){
				long temp2 = list.get(i) ;
				send.add(temp2 ) ; 
				c++ ;
			}
			else {
				//doubles every other number
				long temp2 = list.get(i) ;
				send.add(temp2 * 2) ;
			}
		}
		
		if(c != 0 ){return send ; }

		return null;
	}
	public static long sumDigits(List<Long> list) {
		// TODO to be implemented
		c = 0 ; 

		List<Long> temp=  new ArrayList<Long>();

		long total = 0 ; 

		for(int i = 0 ; i < list.size() ; i ++)
		{

			if( list.get(i) > 9  ){
				long change = list.get(i); 
				temp.add(change % 10) ;
				temp.add(change/=10); 
				
			}
			//this will add all the single digits 
			else {total += list.get(i) ; 
			}
			c ++ ; 
		}
		//this will get the total off all digits 
		for(int x = 0 ; x < temp.size(); x++)
		{
			total += temp.get(x); 
		}

		System.out.println("The sum is: " + total);
		if(c !=0 ){
			return total ; 
		}

		return -1L;
	}
	public static boolean isValid(long l) {
		// TODO to be implemented
		List<Long> toReverse ;
		List<Long> toDouble ;
		
		long toSum ;
	
		toReverse = toDigitsReverse(l) ; 
		toDouble = doubleSecond(toReverse) ;
		toSum = sumDigits(toDouble);  
		
		if ((toSum % 10)==0){
			System.out.println("The numbers are valid " ); 
			return true;
		}
		
		else{
			
			System.out.println("The numbers are invalid " ); 
			return false;
		}
	}
}