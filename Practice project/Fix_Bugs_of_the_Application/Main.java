package Fix_Bugs_of_the_Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();
    }
    
    private static void optionsSelection() {
    	ArrayList<Integer> arrlist = new ArrayList<Integer>();
        ArrayList<Integer> expenses = new ArrayList<Integer>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);
        expenses.addAll(arrlist);
    	while(true) {
    		System.out.println("1. I wish to review my expenditure\n2.I wish to add my expenditure\n3.I wish to delete my expenditure\n4.I wish to sort the expenditures\n5.I wish to search for a particular expenditure\n6.Close the application");
    		System.out.println("\nEnter your choice:\t");
            Scanner sc = new Scanner(System.in);
            int  options =  sc.nextInt();
                    switch (options){
                        case 1:
                            System.out.println("Your saved expenses are listed below: \n");
                            System.out.println(expenses+"\n");
                           // optionsSelection();
                            break;
                        case 2:
                            System.out.println("Enter the value to add your Expense: \n");
                            int value = sc.nextInt();
                            expenses.add(value);
                            System.out.println("Your value is updated\n");
                            expenses.addAll(arrlist);
                            System.out.println(expenses+"\n");
                           // optionsSelection();
                            break;
                        case 3:
                            System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                            int con_choice = sc.nextInt();
                            if(con_choice==options){
                                   expenses.clear();
                                System.out.println(expenses+"\n");
                                System.out.println("All your expenses are erased!\n");
                            } else {
                                System.out.println("Oops... try again!");
                            }
                            //optionsSelection();
                            break;
                        case 4:
                            sortExpenses(expenses);
                           // optionsSelection();
                            break;
                        case 5:
                        	 System.out.println("Enter the expense you need to search:\t");
                              int x = sc.nextInt(); 
                            searchExpenses(expenses,x);
                            //optionsSelection();
                            break;
                        case 6:
                            closeApp();
                            break;
                        default:
                            System.out.println("You have made an invalid choice!");
                            break;
                    }
                }
            }
 
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
        System.exit(0);
            }
    
    private static void searchExpenses(ArrayList<Integer> arrayList,int x) {
    	int index = Collections.binarySearch(arrayList, x); 
        if(index >= 0)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Insertion point: " + index);
           }
    
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
        for (int i = 0; i <  arrlength - 1; i++) {
            for (int j = arrlength - 1; j > i; j--) {
                if (arrayList.get(j - 1) > arrayList.get(j)) {
                    int tmp = arrayList.get(j - 1);
                    arrayList.set(j -1, arrayList.get(j));
                    arrayList.set(j, tmp);
                }
             }
        }
        System.out.println(arrayList+"\n");
    }
}
