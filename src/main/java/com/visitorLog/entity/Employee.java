package com.visitorLog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eId;
	
	@Column
	@NotBlank(message="Please enter your first Name")
	private String firstName;
	
	@Column
	@NotBlank(message="Please enter your last Name")
	private String lastName;
	
	@Column
	@NotBlank(message="Please enter your email")
	@Email(message="Please enter a valid email")
	private String email;
	
	@Column
	@NotBlank(message="Please enter your phone Number")
//	@Pattern(regexp="[\\d]{10}", message="Invalid phone number")
	private String phone;
//	"^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$" 
	
	@Column
	@NotBlank(message="Please enter your password")
	@Size(min=8,message="Password must be atleast 8 character")
	private String password;
	
	public Employee() {}
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + "]";
	}
	
	
}
