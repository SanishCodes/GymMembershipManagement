package GymMembership;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class InsertionManager {
	
	public static boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("^[a-zA-Z ]+$");
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}
	
	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isValidBirthDate(String birthDate) {
		Pattern pattern = Pattern.compile("^(0[1-9]|[1-2][0-9]|[3][0-1])-(0[1-9]|1[0-2])-\\d{2}$");
		Matcher matcher = pattern.matcher(birthDate);
		return matcher.matches();
	}
	
	public static boolean isValidYesNo(String yesNo) {
		if(yesNo =="yes" || yesNo == "no")
			return true;
		else
			return false;
	}
	
	public static boolean isValidLom(int lom) {
		if(1>lom && lom<60)
			return true;
		else
			return false;
	}
	
	public static boolean isValidOffer(String offerInput) {
		if("yes".equals(offerInput) || "no".equals(offerInput)) 
			return true;
		else
			return false;
	}
	
	
	public Member addNewMember() {
		Scanner si = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = sc.nextLine();
		
		while(!isValidName(name)) {
			System.out.println("!! The name you entered is invalid !!");
			System.out.println("Re-enter your name: ");
			name = sc.nextLine();
		}
			
		System.out.println("Enter your email: ");
		String email = sc.nextLine();
		 while(!isValidEmail(email)) {
			System.out.println("!! The email you entered is invalid !!");
			System.out.println("Re-enter your email:");
			email = sc.nextLine();
		}
		
		System.out.println("Enter your birthdate: ");
		String birthDate = sc.nextLine();
		while(!isValidBirthDate(birthDate)) {
			System.out.println("!! The birthdate you entered is invalid !!");
			System.out.println("Re-enter your birthdate:");
			birthDate = sc.nextLine();
		}
		
		System.out.println("Enter number of months for membership: ");
		int lom = si.nextInt();
		while(!isValidBirthDate(birthDate)) {
			System.out.println("!! The number of months you entered is invalid !!");
			System.out.println("Re-enter number of months or membership:");
			lom = si.nextInt();
		}
		
		System.out.println("Do you have a special offer:(yes/no) ");
		String offerInput = sc.next();
		boolean offer;
		while(!isValidOffer(offerInput)) {
			System.out.println("!! Offer Input Invalid !!");
			System.out.println("Do you have a special offer:(yes/no) ");
			offerInput = sc.nextLine();
		}
		if(offerInput.equals("yes")) 
			offer = true;
		else 
			offer = false;
		
		Member m = new Member(name,email,birthDate,lom,offer);
		System.out.println(+m.getCost());
		return m;
	}
	
	public void insertIntoFile(ArrayList<Member> memberList) {
		
		  try {
		    	FileOutputStream file = new FileOutputStream("members.ser");
		    	ObjectOutputStream out = new ObjectOutputStream(file);	
		    	
		    	out.writeObject(memberList);
		    	out.close();file.close();
		    	System.out.println("File Written");
		      	}catch(IOException e) {
		      		e.printStackTrace();
		      	}
		 
		
	}
	
}
