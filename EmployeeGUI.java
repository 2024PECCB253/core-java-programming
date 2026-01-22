package com.company.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeGUI extends JFrame implements ActionListener {

    JTextField txtId, txtName, txtSalary;
    JButton btnCalculate;
    JTextArea result;

    public EmployeeGUI() {
        setTitle("Employee Management System");
        setSize(400, 350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Employee ID:"));
        txtId = new JTextField(20);
        add(txtId);

        add(new JLabel("Employee Name:"));
        txtName = new JTextField(20);
        add(txtName);

        add(new JLabel("Employee Salary:"));
        txtSalary = new JTextField(20);
        add(txtSalary);

        btnCalculate = new JButton("Calculate Bonus");
        add(btnCalculate);

        result = new JTextArea(8, 30);
        result.setEditable(false);
        add(result);

        btnCalculate.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            double salary = Double.parseDouble(txtSalary.getText());

            if (salary <= 0) {
                throw new InvalidSalaryException("Salary must be greater than zero");
            }

            Employee emp = new Employee(id, name, salary);
            double bonus = emp.getSalary() * 0.10;

            result.setText(
                "Employee ID: " + emp.getId() + "\n" +
                "Employee Name: " + emp.getName() + "\n" +
                "Employee Salary: " + emp.getSalary() + "\n" +
                "Employee Bonus: " + bonus
            );

        } catch (InvalidSalaryException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid data");
        }
    }

    public static void main(String[] args) {
        new EmployeeGUI();
    }
}
