package exam.hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admintable {
	@Id 
	int id;
	String password,type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Admintable(int id, String password, String type) {
		
		this.id = id;
		this.password = password;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + ", type=" + type + "]";
	}
	

}
