package com.anwar.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * This class has sample code to understand consumers
 * @author anwarsahib
 */
public class consumer {
    
    public static void main(String args[]){
        Customer c1 = new Customer("John", "99999999");
        greet(c1);
        
        //Consumer functional interfaces
        greetCustomerConsumer.accept(c1);
        greetCustomerConsumer2.accept(c1, Boolean.FALSE);
        
        //Some variations of the same concept with different data types are present for consumers
    }
    
    //Custom Customer datatype 
    static class Customer{
        private final String name;
        private final String phoneNumber;
        
        Customer(String name, String phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
    
    //Fuction to greet the customer. Note that functions returning void data type and accepting single object can be converted to consumers.
    static void greet(Customer customer){
        System.out.println("Hello " + customer.name + ". Thanks for registering phone number " + customer.phoneNumber);
    }
    
    //Consumer that accepts a single agrument
    static Consumer<Customer> greetCustomerConsumer = customer -> 
            System.out.println("Hello " + customer.name + ". Thanks for registering phone number " + customer.phoneNumber);
    
    //Consumer that accepts two agruments
    static BiConsumer<Customer, Boolean> greetCustomerConsumer2 = (customer, showNumber) -> 
            System.out.println("Hello " + customer.name + ". Thanks for registering phone number " 
                    + (showNumber? customer.phoneNumber : "********"));

}
