package GymMembership;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListToFile {
    public static void main(String[] args) {
    ArrayList<Member> aList = new ArrayList<>();
    aList.add(new Member("Sanish", "sanish@gmail.com", "12-12-12", 12, false));
    aList.add(new Member("Shrest", "shrestha@gmail.com", "12-12-90", 6, false));
    
    
   /*
      try {
    	FileOutputStream file = new FileOutputStream("project.ser");
    	ObjectOutputStream out = new ObjectOutputStream(file);	
    	
    	out.writeObject(aList);
    	out.close();file.close();
    	System.out.println("File Written");
      	}catch(IOException e) {
      		e.printStackTrace();
      	}
      */
    
    	String fileName = "members.ser";
    	File file = new File(fileName);
    	
    	if(file.exists()) {
    			try {
    		    	FileInputStream readFile = new FileInputStream("members.ser");
    		    	ObjectInputStream readStream = new ObjectInputStream(readFile);
    		    	
    		    	ArrayList<Member> readList = (ArrayList<Member>) readStream.readObject();
    		    	readStream.close();
    		    	System.out.println("Reading file~~~~~~~~~~~~~~~~~~~~");

    		    	Iterator<Member> memberIterator = readList.iterator();
    		    	if(memberIterator.hasNext()) {
    			    	while(memberIterator.hasNext()) {
    			    		Member m = memberIterator.next();
    			    		System.out.println(m.toString());
    			    	}
    		    	}else {
    		    		System.out.println("No Records Found");
    		    	}
    		    	System.out.println(readList.toString());
    		    }catch(Exception e) {
    		    	e.printStackTrace();
    		    }
    		}
    	else {
    		System.out.println("File Not Found");
    	}
    	
    
    }
}





