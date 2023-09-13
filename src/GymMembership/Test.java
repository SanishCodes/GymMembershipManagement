package GymMembership;
import java.io.*;

import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class Test {
	
	public static void createFile() {
		try {
			File myObj = new File("personal.txt");
			if(myObj.createNewFile())
				System.out.println("File Created");
			else
				System.out.println("File already exists");
		}catch(IOException e){
			System.out.println("An error occured");
			e.printStackTrace();
			
		}
	}
	
	public static void fileInfo(String fileName) {
		
		File myObj = new File(fileName);
		
		if(myObj.exists()) {
			System.out.println("FileName: "+myObj.getName());
			System.out.println("FilePath: "+myObj.getAbsolutePath());
			System.out.println("FileSize: "+myObj.length());
			System.out.println("Writeable: "+myObj.getName());
			System.out.println("Readable: "+myObj.getName());
		}else {
			System.out.println("File Not Found!!!");
		}
		
	}
	
	public static void writeToFile(String fileName) {
		try {
			FileWriter myWriter = new FileWriter(fileName);
			ArrayList<Integer> list = new ArrayList<>();
			
			list.add(1);
			list.add(1);
			
			list.add(1);
			list.add(1);
			list.add(1);
			myWriter.write(list.toString());
			myWriter.close();
		}catch(IOException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		
		fileInfo("personal.txt");
		writeToFile("personal.txt");
		fileInfo("personal.txt");
	}
}