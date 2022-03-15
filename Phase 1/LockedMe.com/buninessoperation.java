package LockerMe.com;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class buninessoperation {

	public static void buninessoperationmenu() {
		Scanner in = new Scanner (System.in);
		System.out.println("1.Add a file\n2.delete a file\n3.search a file\n4.back to main menu");
		System.out.println("choose the option:");
		int choice2 = in.nextInt();
		try{
			switch(choice2) {
			case 1:
				createfile();
				break;
			case 2:
				deletefile();
				break;
			case 3:
				searchfile();
				break;
			case 4:
				Main.mainmenu();
				break;
			default:
				System.out.println("Please select a valid option from above.");
			}
		}catch(Exception e ) {
			System.out.println("Error Accured\nEnter correct value from the menu");
			
			}
		buninessoperationmenu();
		}
	public static void createfile() {
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------------");
        System.out.print("Enter the desired name of your file: ");
        String fileName = in.nextLine();
        fileName = "/home/naveedalimphasi/JavaFSD/LockedMe.com/main/"+fileName;
		try {
		      File myObj = new File(fileName);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		    }
		System.out.println("---------------------------------------");
	}
	public static void deletefile() {
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------------");
        System.out.print("Enter the desired name of the file to be deleted: ");
        String fileName = in.nextLine();
        fileName = "/home/naveedalimphasi/JavaFSD/LockedMe.com/main/"+fileName;	
        File f= new File(fileName);            
        if(f.delete())                  
        {  
        System.out.println(f.getName() + " deleted");   
        }
        else {
        	System.out.println("The file "+f.getName()+" doesnot exist please try again");
        }
        System.out.println("---------------------------------------");
        }
	public static void searchfile() {
		Scanner in = new Scanner(System.in);
		System.out.println("---------------------------------------");
        System.out.print("Enter the desired name of the file to be searched: ");
        String fileName = in.nextLine();
        fileName = "/home/naveedalimphasi/JavaFSD/LockedMe.com/main/"+fileName;
        File search=new File(fileName);
        boolean check = new File(fileName).exists();
        if(check == true) {
        	System.out.println("File found in main dir");
        }
        else {
        	System.out.println("File not found in main dir");
        }
        System.out.println("---------------------------------------");
		
	}
		
	}

