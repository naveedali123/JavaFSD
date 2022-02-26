package Validation_of_an_Email_ID;

import java.util.ArrayList;
import java.util.Scanner;

public class emailValidation {
	public static void main(String[] args){
		  Scanner in = new Scanner(System.in);
		  System.out.println("Enter the employees email ID which you would like to search");
		  String Emailcheck = in.nextLine();
		  Emailcheck=Emailcheck.toLowerCase();
	      ArrayList <String> Emaillist = new ArrayList<String>();
	      Emaillist.add("aran@gmail.com");
	      Emaillist.add("ali@co.in");
	      Emaillist.add("abc@xyz.com");
	      Emaillist.add("hello@google.com");
	      Emaillist.add("musk@tesla.com");
	      Emaillist.add("rayan@school.in");
	      Emaillist.add("tim@apple.com");	     
	         if (Emaillist.contains(Emailcheck)){
	               System.out.println("The Entered employees Email ID was found in the search");
	         }
	         else {
	        	 System.out.println("The Entered employees Email ID was not found in the search");
	         }
	         in.close();
	   }

}
