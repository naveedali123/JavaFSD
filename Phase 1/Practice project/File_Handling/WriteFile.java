package File_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile {
	 public static void main(String[] args) throws FileNotFoundException
		        
		    {
		       Scanner in = new Scanner(System.in);
		       System.out.println("Enter the content to write to file");
		       String data=in.nextLine();
		       File file = new File("/home/naveedalimphasi/JavaFSD/writefile.txt"); 
	            PrintWriter writer = new PrintWriter(file);
	            writer.write(data);
	            writer.close();
	            System.out.println("Wrtie successful to the file ");
	            in.close();
		    }

}
