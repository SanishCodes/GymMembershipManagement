package GymMembership;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;

public class Gym {
	
	
	public static void writeToFile(ArrayList<Member> memberList) {
		String fileName = "test.txt";
		try(FileOutputStream fileOutputStream = new FileOutputStream(fileName);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){
			objectOutputStream.writeObject(memberList);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//#########################################################
	
	public static void main(String[] args) {
		
		Scanner si = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> memberList = new ArrayList<>();
		int ch;
		do{
			System.out.println("--------------------------");
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.QUERY");
			System.out.println("4.DELETE");
			System.out.println("5.EXIT");
			System.out.println("Enter your choice: ");
			ch = si.nextInt();
			System.out.println("--------------------------");
			
			switch(ch){
			case 1:
				InsertionManager insert = new InsertionManager();
				DisplayManager display = new DisplayManager();
				memberList.addAll(display.readMemberFile());
				memberList.add(insert.addNewMember());
				break;
				
			case 2:
				DisplayManager display1 = new DisplayManager();
				display1.displayMember(display1.readMemberFile());
				break;
				
			case 3:
				System.out.println("Queried");
				break;
				
			case 4:
				System.out.println("Deleted");
				break;
				
			case 5:
				InsertionManager insert1 = new InsertionManager();
				insert1.insertIntoFile(memberList);
				System.out.println("Exited");
				break;
			}
		}while(ch != 5);
		si.close();
		sc.close();
	}

}
