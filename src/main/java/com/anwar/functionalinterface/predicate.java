package com.anwar.functionalinterface;

import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * This class contains sample code to under predicates
 * @author anwarsahib
 */
public class predicate {

    public static void main(String args[]){
        String email = "john.doe@gmail.com";
        System.out.println("Valid Email(" + email + "):" + isValidEmail(email));
        
        //Using Predicate functional interface
        System.out.println("Valid Email(" + email + ") using Predicate:" + isValidEmailPredicate.test(email));
        
        //Chaining the Predicates usinng 'and' function. One can also use 'or' and 'negate' function
        boolean isGmail = isValidEmailPredicate.and(isGmailPredicate).test(email);
        System.out.println("Valid Gmail(" + email + ")?:" + isGmail);

        
        //Similar to function and consumer there are BiPredicate also
    }
    
    static Predicate<String> isValidEmailPredicate = email -> isValidEmail(email);
    static Predicate<String> isGmailPredicate = email -> email.endsWith("gmail.com");
    
    //Using regular expression provided in OWASP Validation Regex repository.
    public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
}
