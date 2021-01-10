package com.anwar.chaining;

/**
 * This class facilitates using functional chaining
 * @author anwarsahib
 */

import com.anwar.chaining.EmployeeValidator.*;
import static com.anwar.chaining.EmployeeValidator.ValidationResult.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;


public interface EmployeeValidator
        extends Function<Employee, ValidationResult> {

    static EmployeeValidator isEmailValid() {
        return employee -> {
            System.out.println("running email validation...");
            return employee.getEmail().contains("@") ? //Dummy simple validation
                    SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static EmployeeValidator isPhoneNumberValid() {
        System.out.println("running phone number validation...");
        return employee -> employee.getPhoneNumber().startsWith("+0") ? //Dummy simple validation
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static EmployeeValidator isNewJoinee() {
        System.out.println("running new joinee validation...");
        return employee ->
                Period.between(employee.getDoj(), LocalDate.now()).getDays() < 5 ? //Dummy simple validation
                        SUCCESS : IS_NOT_NEW_JOINEE;
    }

    default EmployeeValidator and (EmployeeValidator other) {
        return employee -> {
            ValidationResult result = this.apply(employee);
            return result.equals(SUCCESS) ? other.apply(employee) : result;
        };
    }
    
    static enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_NEW_JOINEE
    }
}


