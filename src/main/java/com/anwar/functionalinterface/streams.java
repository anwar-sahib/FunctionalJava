package com.anwar.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class has sample code of how functions, consumers, Predicates etc are applied with streams
 * @author anwarsahib
 */
public class streams {
    
    public static void main(String args[]){
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new Employee("Adam","Eng"));
        employees.add(new Employee("John","HR"));
        employees.add(new Employee("Marie","Testing"));
        employees.add(new Employee("Bob","Eng"));
        employees.add(new Employee("Julie","Admin"));
        employees.add(new Employee("Paul","Testing"));
        
        //Using streams and java.util.function package
        System.out.println("\n----map() needs function and forEach() needs a consumer-----");
        employees.stream().map(employee -> employee.dept)
                          .collect(Collectors.toSet()) //Collector provide important methods userful for reduction
                          .forEach(System.out::println);
        
        //Chaining same functional operators like map twice
        System.out.println("\n----Print Email id  of each employee-----");
        employees.stream().map(employee -> employee.name)
                          .map(name -> name + "@functionaljava.com")
                          .forEach(System.out::println);
        
        
        System.out.println("\n----Using matchers in streams, matchers need Predicates-----");
        boolean allEngEmplyees = employees.stream().allMatch(employee -> employee.dept.equals("Eng"));
        System.out.println("allEngEmplyees:"+ allEngEmplyees);
        boolean anyEngEmplyee = employees.stream().anyMatch(employee -> employee.dept.equals("Eng"));
        System.out.println("anyEngEmplyees:"+ anyEngEmplyee);
        boolean anyFinanceEmplyee = employees.stream().anyMatch(employee -> employee.dept.equals("Finance"));
        System.out.println("anyFinanceEmplyee:"+ anyFinanceEmplyee);
                          
    }
    
    
    static class Employee {
        
        private final String name;
        private final String dept;
      
        public Employee(String name, String dept){
            this.name = name;
            this.dept = dept;
        }
    }

}
