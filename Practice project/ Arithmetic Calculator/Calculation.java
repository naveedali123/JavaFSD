package PRACTIVE_LAB;

import java.util.Scanner;
public class Calculation {
public static void main(String[] args) {
		final int condition=1;
		Scanner scan = new Scanner(System.in);
		while(condition==1) {
		System.out.println("***Arithmetic Calculator***");
		System.out.println("Enter the opration you like to perform");
		System.out.println("1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Exit");
		int choice = scan.nextInt();
		if (choice==5) {
			System.out.println("Thank you");
			System.exit(0);
		}
		System.out.println("Enter first number");
		int digit1 = scan.nextInt();
		System.out.println("Enter second number");
		int digit2 = scan.nextInt();
		
		Digit dg = new Digit();
		dg.setdigit1(digit1); 
		dg.setdigit2(digit2);
		Calculator cal = new Calculator();
		//scan.close();
		switch(choice) {
		case 1:int addResult = cal.addition(dg.getdigit1(), dg.getdigit2());
		System.out.println("Addition Result = "+addResult);
		break;
		case 2:int subResult = cal.substraction(dg.getdigit1(), dg.getdigit2());
		System.out.println("Subtraction Result = "+subResult);
		break;
		case 3:int mulResult = cal.multiplication(dg.getdigit1(), dg.getdigit2());
		System.out.println("Multiplication Result = "+mulResult);
		break;
		case 4:if (digit2==0) {
			System.out.println("Divide by Zero error");
			break;
		}
		else {
			float divResult = cal.division(dg.getdigit1(), dg.getdigit2());
		System.out.println("Division Result = "+divResult);
		break;
		}
		default :System.out.println("Wrong choice Enter again correct values from Menu");

		}
		}
	}
}
