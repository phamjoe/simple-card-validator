/* Name: Joseph Pham
 * Student Number: 045268141
 * August 3rd 2016
 * Assignment 3
 * 
 * */

import java.net.*; 
import java.io.* ; 
public class CreditCardServer {
		
		public static void main(String[] args)
		{
			ServerSocket serverSocket; 
			try {
				serverSocket = new ServerSocket(8141); 
				
				System.out.println("***this server is going to register the credit card***"); 
				System.out.println("listening for a connection...");
				
				Socket socketConnection = serverSocket.accept() ; 
				
				ObjectOutputStream oosToClient = new ObjectOutputStream(
					socketConnection.getOutputStream());
					
				ObjectInputStream oisFromClient = new ObjectInputStream(
						socketConnection.getInputStream()); 
						
				CreditCard creditCard ;
					try{
							
							while(true){
								creditCard = (CreditCard)oisFromClient.readObject();
								
								System.out.println("\n*** receive an object from the CLIENT:\n "+ creditCard) ;
								//this is where it will check if it's a valid Credit Card
								creditCard.checkValid(); 
								// send the object to the client
					            oosToClient.writeObject(creditCard);
					            oosToClient.flush();
							}
					}catch (ClassNotFoundException cnf) {
					cnf.printStackTrace();
					} catch (EOFException eof) {
					System.out.println("*** THE client has terminated connection ***");
					}
					
					
					//close connection
					oosToClient.close();
					oisFromClient.close();
					socketConnection.close() ; 	
			}catch (IOException e) {
					e.printStackTrace();
					}
					System.out.println("** the server is going to stop running***");
				
		}
	}
			
		

