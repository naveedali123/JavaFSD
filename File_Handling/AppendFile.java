package File_Handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AppendFile {
	public static void main(String[] args) throws IOException {
  
        try {
        	File file = new File("/home/naveedalimphasi/JavaFSD/append.txt");
        	FileWriter fr = new FileWriter(file, true);
        	fr.write("data \n");
        	fr.close();
        	System.out.println("File appended");
        }
        catch (FileNotFoundException ex) {
			System.out.println("File not Found");
        }
        
    }

}
