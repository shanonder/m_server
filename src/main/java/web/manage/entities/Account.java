package web.manage.entities;

import javax.persistence.*;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String userName;
	private String password;
	private String power;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}
