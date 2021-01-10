/** POJO class for the employee 
 * @author anwarsahib
 */
package com.anwar.chaining;

import java.time.LocalDate;

public class Employee {

    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate doj;

    public Employee(String name, String email, String phoneNumber, LocalDate doj) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.doj = doj;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDoj() {
        return doj;
    }
}
