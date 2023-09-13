package GymMembership;

import java.util.*;
import java.io.*;

public class DisplayManager {
	
	public ArrayList<Member> readMemberFile() {
		String fileName = "members.ser";
		File file = new File(fileName);
		ArrayList<Member> memberList = new ArrayList<>();
		
		try {
	    	FileInputStream readFile = new FileInputStream("members.ser");
	    	ObjectInputStream readStream = new ObjectInputStream(readFile);
	    	
	    	ArrayList<Member> readList = (ArrayList<Member>) readStream.readObject();
	    	readStream.close();
         	System.out.println("File Succesfully Read");
         	memberList.addAll(readList);
	    }catch(FileNotFoundException e) {
	    	System.out.print("File Doesn't Exist /nPlease Insert A Member To Create File");
		}
		catch(IOException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
		return memberList;
		}
		
	public void displayMember(ArrayList<Member> memberList) {
		Iterator<Member> memberIterator = memberList.iterator();
    	while(memberIterator.hasNext()) {
    		Member m = memberIterator.next();
    		System.out.println(m.toString());
    		}
		}
		
	}

