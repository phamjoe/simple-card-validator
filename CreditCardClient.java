/* Name: Joseph Pham
 * Student Number: 045268141
 * August 3rd 2016
 * Assignment 3
 * 
 * */

import java.net.*;
import java.io.*;

public class CreditCardClient {

	public static void main(String[] args) {

		Socket clientSocket;
		try {
			
			 /* step 1: connect to the server name: "localhost" port number: 8141 */
			clientSocket = new Socket(InetAddress.getByName("localhost"), 8141);
			System.out.println("Connected to "
					+ clientSocket.getInetAddress().getHostName());
			
			/* step 2: connect input and output streams to the socket */
			ObjectInputStream oisFromServer = new ObjectInputStream(
					clientSocket.getInputStream());

			ObjectOutputStream oosToServer = new ObjectOutputStream(
					clientSocket.getOutputStream());

			System.out.println("I/O streams connected to the socket");

			/* step 3: communicate with the server */
			CreditCard[] cards = new CreditCard[2];
			//these are the values in the credit card and will check if it is valid or not 
			cards[0] = new CreditCard(4012888888881881L);
			cards[1] = new CreditCard(5014888888881881L);
			

			for (int i = 0; i < 2; i++) {

				try {
					// send an object to the server
					oosToServer.writeObject(cards[i]);
					oosToServer.flush();
					System.out.println("\n### send this card to the server for registration:\n" + cards[i]);

					// receive an object from the server
					cards[i] = (CreditCard) oisFromServer.readObject(); // casting!
					System.out.println("\t###### the card returned by the server:\n"+ cards[i]);
									
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) { }				
				} catch (ClassNotFoundException cnf) {
					cnf.printStackTrace();
				} catch (EOFException eof) {
					System.out.println("The server has terminated connection!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			 /* step 4: close the connection to the server */		
			System.out.println("\nClient: closing the connection...");
			oosToServer.close();
			oisFromServer.close();
			clientSocket.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("the client is going to stop runing...");
	}
}
