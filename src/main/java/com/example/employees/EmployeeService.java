package com.example.employees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees;
    private int max_employee;

    public EmployeeService() {
        employees = new ArrayList<>();
        max_employee = 12;
        employees.add(new Employee("Иван", "Иванов"));
        employees.add(new Employee("Дмитрий", "Александров"));
        employees.add(new Employee("Евгений", "Александров"));
        employees.add(new Employee("Екатерина", "Иванова"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Ivanov"));
        employees.add(new Employee("Ivan", "Ivanov"));
    }

    public String addEmployee(String name, String lastName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employees.size() >= max_employee) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getFamilyName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("В коллекции уже есть такой сотрудник.");
            }
        }
        Employee newEmployee = new Employee(name, lastName);
        employees.add(newEmployee);
        return "{" + " firstName: " + name + ", lastName: " + lastName + "}";
    }

    public String deleteEmployee(String name, String lastName) throws EmployeeNotFoundExeption {
        Employee employeeToDelete = null;
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getFamilyName().equals(lastName)) {
                employeeToDelete = employee;
                break;
            }
        }
        if (employeeToDelete == null) {
            throw new EmployeeNotFoundExeption("Сотрудник не найден");
        }
        employees.remove(employeeToDelete);
        return "{" + " firstName: " + name + ", lastName: " + lastName + "}";
    }

    public String findEmployee(String name, String lastName)  throws EmployeeNotFoundExeption {
        for (Employee employee : employees) {
            if (employee.getName().equals(name) && employee.getFamilyName().equals(lastName)) {
                return employee.getFullName();
            }
        }
        throw new EmployeeNotFoundExeption("Сотрудник не найден");
    }
}
