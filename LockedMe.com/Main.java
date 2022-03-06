package LockerMe.com;

import java.util.Scanner;

public class Main {
	
	public static void welcomescreen() {
		String Applicationname ="Virtual Key for Your Repositories";
		String Developername ="Naveed Ali";
		System.out.println(Applicationname);
		System.out.println(Developername);
	}
	public static void mainmenu() {
		Scanner in = new Scanner (System.in);
		System.out.println("1.Retrieving the file names in an ascending order\n2.Business-level operations\n3.close the application");
		System.out.println("choose the option:");
		try {
		int choice = in.nextInt();
		switch(choice) {
		case 1:
			retrievingFile.retrievingfiles();
			break;
		case 2:
			buninessoperation.buninessoperationmenu();
			break;
		case 3:
			closeapplication();
			break;
		default:
			System.out.println("Please select a valid option from above.");
		}
		}catch(Exception e ) {
			System.out.println("Error Accured\nEnter correct value from the menu");	
		}
		mainmenu();
	}
	public static void closeapplication() {
		System.out.println("Thank you for using the system\nclosing the application");
		System.exit(0);
	}
	public static void main(String args[]) {
		welcomescreen();
		mainmenu();
	
	}
	
}
	

