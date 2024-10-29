package com.example.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String helloProgramm() {
        return "<h1>Hello! Here you can see your employees</h1>";
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            String result = employeeService.addEmployee(firstName, lastName);
            return "<h1>" + result + "</h1>";
        } catch (EmployeeAlreadyAddedException e) {
            return "<h1>Ошибка: " + e.getMessage() + "</h1>";
        } catch (EmployeeStorageIsFullException e) {
            return "<h1>Ошибка: " + e.getMessage() + "</h1>";
        }
    }


    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundExeption {
        try {
            String t = employeeService.deleteEmployee(firstName, lastName);
            return "<h1>" + "{" + " firstName: " + firstName + ", lastName: " + lastName + "}" + "</h1>";
        } catch (EmployeeNotFoundExeption e) {
            return "<h1>Ошибка: " + e.getMessage() + "</h1>";
        }
    }


    @GetMapping("/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws EmployeeNotFoundExeption {
        try {
            String t = employeeService.findEmployee(firstName, lastName);
            return "<h1>" + "{" + " firstName: " + firstName + ", lastName: " + lastName + "}" + "</h1>";
        } catch (EmployeeNotFoundExeption e) {
            return "<h1>Ошибка: " + e.getMessage() + "</h1>";
        }
    }
}

