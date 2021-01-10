package com.anwar.chaining;

import com.anwar.chaining.EmployeeValidator.ValidationResult;
import java.time.LocalDate;

/**
 * This class shows sample example of using functional chaining
 * @author anwarsahib
 */
public class FunctionalChaining {


    public static void main(String[] args) {
        Employee employee = new Employee(
                "John",
                "John@gmail.com",
                "+0123456789",
                LocalDate.of(2020, 1,10)
        );

        ValidationResult result = EmployeeValidator.isPhoneNumberValid()
                .and(EmployeeValidator.isNewJoinee())
                .and(EmployeeValidator.isEmailValid())
                .apply(employee);

        System.out.println("Result of validation:" + result);
                
    }
}
