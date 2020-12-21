package com.anwar.functionalinterface;

import java.util.function.Supplier;

/**
 * Code sample explaining the concept of supplier
 * @author anwarsahib
 */
public class supplier {
    
    public static void main(String args[]){
        System.out.println(getConnectionUrl());
        
        System.out.println(getConnectionUrlSupplier.get());
    }
    
    static String getConnectionUrl() {
        return "http://localhost:5432/connect";
    }

    //Supplier does not take any object, it only returns
    static Supplier<String> getConnectionUrlSupplier = () 
            -> "http://localhost:5432/connect"; 
}
