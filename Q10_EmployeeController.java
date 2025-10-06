package com.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class Q10_EmployeeController {

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob", 70000),
            new Employee(3, "Charlie", 60000)
        );
    }
}