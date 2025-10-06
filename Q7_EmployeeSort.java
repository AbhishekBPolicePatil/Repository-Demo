package com.demo.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q7_EmployeeSort {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Alice", 50000));

        employees.add(new Employee(2, "Bob", 70000));

        employees.add(new Employee(3, "Charlie", 60000));

        System.out.println("Before sorting:");

        for (Employee e : employees) {

            System.out.println(e);

        }

        employees.sort(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("After sorting by salary:");

        for (Employee e : employees) {

            System.out.println(e);

        }

    }

}
