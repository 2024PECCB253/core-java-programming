package com.company.employee;

public class MainApp {
    public static void main(String[] args) {

        Employee employee = new Employee(101, "Arun", 30000);
        EmployeeService service = new EmployeeServiceImpl();

        service.displayEmployee(employee);

        try {
            double bonus = service.calculateBonus(employee);
            System.out.println("Employee Bonus: " + bonus);
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
