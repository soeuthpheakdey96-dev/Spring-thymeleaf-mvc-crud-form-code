package com.dev.spring.mvc.thymeleafdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee")
public class Employee {
  
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id")
  private int EmployeeId;
  
  @NotNull(message="Please enter your First Name")
  @Size(min=1, message="Please enter your First Name")
  @Column(name="first_name")
  private String firstName;
  
  @NotNull(message="Please enter your Last Name")
  @Size(min=1, message="Please enter your Last Name")
  @Column(name="last_name")
  private String lastName;
  
  @NotNull(message="Please enter your Email")
  @Size(min=1, message="Please enter your Email")
  @Column(name="email")
  private String email;
  @NotNull(message="Please enter your Education")
  @Size(min=1, message="Please enter your Education")
  private String Education;

  
  public Employee() {
    
  }


  public Employee(
		@NotNull(message = "Please enter your First Name") @Size(min = 1, message = "Please enter your First Name") String firstName,
		@NotNull(message = "Please enter your Last Name") @Size(min = 1, message = "Please enter your Last Name") String lastName,
		@NotNull(message = "Please enter your Email") @Size(min = 1, message = "Please enter your Email") String email,
		@NotNull(message = "Please enter your Education") @Size(min = 1, message = "Please enter your Education") String education) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.Education = education;
  }


  public int getEmployeeId() {
	return EmployeeId;
  }


  public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
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


  public String getEducation() {
	return Education;
  }


  public void setEducation(String education) {
	this.Education = education;
  }


  @Override
  public String toString() {
	return "Employee [EmployeeId=" + EmployeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
			+ email + ", Education=" + Education + ", getEmployeeId()=" + getEmployeeId() + ", getFirstName()="
			+ getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()=" + getEmail() + ", getEducation()="
			+ getEducation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
  }

  
}



