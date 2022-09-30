package com.employee.EmployeeTaxCal.model;

import java.util.List;

public class Employee {

	private final long employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private List<Long> phoneNumbers;
	private String dateOfJoining;
	private long salary;
	private double tax;
	private double cess;


	public Employee(long employeeId, String firstName, String lastName, String email, List<Long> phoneNumbers,
			String dateOfJoining, long salary, double tax, double cess) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.dateOfJoining = dateOfJoining;
		this.salary = salary;
		this.tax = tax;
		this.cess = cess;
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

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public List<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getCess() {
		return cess;
	}

	public void setCess(double cess) {
		this.cess = cess;
	}

}
