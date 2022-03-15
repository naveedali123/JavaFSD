package LockerMe.com;


import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class retrievingFile {

	public static void retrievingfiles() {
		File fileDir = new File("/home/naveedalimphasi/JavaFSD/LockedMe.com/main/");
		List<String> listFile = Arrays.asList(fileDir.list());
		Collections.sort(listFile);
		System.out.println("---------------------------------------");
		System.out.println("Sorting by filename in ascending order");
		for(String s:listFile){
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
		
	}
		
	}


