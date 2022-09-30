package com.employee.EmployeeTaxCal.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.EmployeeTaxCal.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/")
	public String get() {
		return "Welcome to Employee Tax Calculation";

	}

	@PostMapping("/addEmployee")
	public Employee getEmployee(@RequestParam(name = "employeeId") long employeeId,
			@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName,
			@RequestParam(name = "email") String email, @RequestParam(name = "phoneNumbers") List<String> phoneNumbers,
			@RequestParam(name = "dateOfJoining") String dateOfJoining, @RequestParam(name = "salary") long salary) {

		SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");
		long workingDays = 0;
		try {
			Date startDate = dateFormater.parse(dateOfJoining);
			Date endDate = dateFormater.parse("31/03/2023");

			long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
			workingDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		long totalSalary = (salary / 30) * workingDays;

		double tax = getTaxAmount(totalSalary);
		double cess = getCessAmount(totalSalary);
		List<Long> phList = new ArrayList<>();
		for (String s : phoneNumbers) {
			long i = Long.parseLong(s);
			phList.add(i);
		}
		Employee newEmp = new Employee(employeeId, firstName, lastName, email, phList, dateOfJoining, salary, tax,
				cess);
		return newEmp;

	}

	private Double getTaxAmount(long totalSalary) {
		double taxableIncome = 0;
		double tax = 0;
		if (totalSalary > 250000) {
			taxableIncome = totalSalary - 250000;
		}
		if (totalSalary > 250000 && totalSalary <= 500000 && taxableIncome > 0) {
			tax = taxableIncome * 0.05;
			taxableIncome = taxableIncome - 500000;
		}
		if (totalSalary > 500000 && totalSalary <= 1000000 && taxableIncome > 0) {
			tax = tax + taxableIncome * 0.1;
			taxableIncome = taxableIncome - 1000000;
		}
		if (totalSalary > 1000000 && taxableIncome > 0) {
			tax = tax + taxableIncome * 0.2;
		}
		return tax;
	}

	private Double getCessAmount(long totalSalary) {
		double cess = 0;
		if (totalSalary > 2500000) {
			double taxableIncome = totalSalary - 2500000;
			cess = taxableIncome * 0.02;
		}
		return cess;
	}
	
}
