package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class registration {
 
	public registration() {
		super();
	}
	@Id
	private int UserID;
	private String Contact;
	private String Name,EmailId,Gender,City,State,Password;
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getContact() {
		return Contact;
	}
	public void setContact(String contact) {
		Contact = contact;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public registration(int userID, String contact, String name, String emailId, String gender, String city, String state,
			String password) {
		super();
		UserID = userID;
		Contact = contact;
		Name = name;
		EmailId = emailId;
		Gender = gender;
		City = city;
		State = state;
		Password = password;
	}
	@Override
	public String toString() {
		return "registration [UserID=" + UserID + ", Contact=" + Contact + ", Name=" + Name + ", EmailId=" + EmailId
				+ ", Gender=" + Gender + ", City=" + City + ", State=" + State + ", Password=" + Password + "]";
	}
	
	
	
}
