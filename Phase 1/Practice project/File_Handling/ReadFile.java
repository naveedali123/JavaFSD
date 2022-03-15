package File_Handling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	public static void main(String [] args) throws IOException {
		try {File file = new File("/home/naveedalimphasi/JavaFSD/test.txt");
		BufferedReader br= new BufferedReader(new FileReader(file));
		String st;

        while ((st = br.readLine()) != null)

            System.out.println(st);
        br.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File not Found");
			
		}        
	}

}
