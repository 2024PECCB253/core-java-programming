package com.company.employee;

public interface EmployeeService {
    void displayEmployee(Employee employee);
    double calculateBonus(Employee employee) throws InvalidSalaryException;
}
