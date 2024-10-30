package com.example.employees;

import java.util.Objects;

public class Employee {
    private String name;
    private String familyName;
    private String fullName;

    public Employee(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
        this.fullName = this.familyName + ' ' + this.name;
    }

    public String getName() {
        return this.name;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getFullName() {
        return this.fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(familyName, employee.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, familyName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public static void printEmployeeList(Employee[] employees) {
        if (employees == null || employees.length == 0) {
            System.out.println("Список сотрудников пуст.");
            return;
        }

        System.out.println("Список сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%d. %s\n", i + 1, employees[i].toString());
        }
    }
}
