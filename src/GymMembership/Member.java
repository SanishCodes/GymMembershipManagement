package GymMembership;
import java.io.Serializable;


public class Member implements Serializable{
	private String name;
	private String email;
	private String birthDate;
	private int lom;
	private boolean offer; 
	private double cost;
	
	
	public double getCost() {
		
		double rate = 0;

		if(lom >= 1 && lom < 6) {
			rate = 30.0;
		}else if(lom >=6 && lom<12) {
			rate = 27.5;
		}else {
			rate = 25.0;
		}
		
		if(!offer)
			cost = lom * rate;
		else
			cost = (lom* rate) - (0.15 * (lom* rate));
		
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Member(String name, String email, String birthDate, int lom, boolean offer) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.lom = lom;
		this.offer = offer;
	
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getLom() {
		return lom;
	}

	public void setLom(int lom) {
		this.lom = lom;
	}

	public boolean isOffer() {
		return offer;
	}

	public void setOffer(boolean offer) {
		this.offer = offer;
	}

	@Override
	public String toString() {
		return "Name=" +getName() + ", Email=" +getEmail() + ", BirthDate=" + getBirthDate() +
				", Length of Membership=" +getLom() + ", Offer="
				+ isOffer() + ", Cost=" + getCost();
	}

	


	

	
}
