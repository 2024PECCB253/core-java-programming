package com.company.employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void displayEmployee(Employee employee) {
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Salary: " + employee.getSalary());
    }

    @Override
    public double calculateBonus(Employee employee) throws InvalidSalaryException {
        if (employee.getSalary() <= 0) {
            throw new InvalidSalaryException("Salary must be greater than zero");
        }
        return employee.getSalary() * 0.10;
    }
}
