package com.anwar.functionaljava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * This Class demonstrate how functional programming enables more declarative programming 
 * @author anwarsahib
 */
public class DeclarativeSyntax {
    
    public static void main(String args[]){
        checkisPrime();
        customSearch();
        functionReturningPredicate();
    }
    
    
    private static void checkisPrime(){
        System.out.println("Checking prime");
        System.out.println(isPrime(1));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        System.out.println(isPrime(10));
        System.out.println("X---------------------X\n");
    }
    private static boolean isPrime(int n) {
        //Imperative approach where we say how to do something.
/*         for (int i = 2; i < n; i++) { //Requires checking logic and possibility to bugs due to mutability
            if (n % i == 0) {
                return false;
            }
        }
        return true; */
        
        //Declarative way, we just say what to do with logic part added in the function
        return n > 1 && IntStream.range(2, n)
                                 .noneMatch(index -> isDivisible(n, index));
        
    }

    //isDivisible logic is extracted out and be reused. 
    private static boolean isDivisible(int number, int divisor){
        return number % divisor == 0;
    }
    
    
    
    private static void customSearch(){
       System.out.println("Custom Search");
       search();
       System.out.println("X---------------------X\n");
       System.out.println("Optimisation using streams for custom search");
       searchOptimisationDemo();
       System.out.println("X---------------------X\n");
    }
    
    //Find the double for first event numeber greater than 3
    private static void search(){
        int result = -1;
        //Imperative way of specifying logic
        List<Integer> values = Arrays.asList(1,2,3,4,5,10);
/*        for(int e: values){
            if(e > 3 && e % 2 == 0){
                result =  e * 2;
                System.out.println(result);
                break;
            }
        }
        return result;*/
    
         //Declarative way where code reads as logic
          result = values.stream().filter(e -> e > 3) //This can also be defined as functions
                        .filter(e -> isDivisible(e, 2)) //Reusing the function
                        .map(e -> e * 2)
                        .findFirst()
                        .get(); 
          
          //NOTE - replace stream() with parallelStream() for executing in parallel without having to deal with multithreading
          System.out.println("result:" + result);
    }
    
    private static void searchOptimisationDemo(){
         List<Integer> values = Arrays.asList(1,2,3,7,4,5,10);
         int result = -1;
         
         //Declarative way of finding fist element which is greater than 3 and even. Get double of that number
         result = values.stream().filter(DeclarativeSyntax :: greaterThan3) 
                        .filter(DeclarativeSyntax :: isEven) //Reusing the function
                        .map(DeclarativeSyntax :: doubleIt)
                        .findFirst() //Code will internally only process what is needed once terminal operator is called
                        .get(); //Until the get method is called no processing is done.
          System.out.println("result:" + result);
    }
    
    private static boolean greaterThan3(int n){
        System.out.println("greaterThan3:" + n);
        return n > 3;
    }
    private static boolean isEven(int n){
        System.out.println("isEven:" + n);
        return n % 2 == 0;
    }
    private static int doubleIt(int n){
        System.out.println("doubleIt:" + n);
        return n * 2;
    }
    
    
    
    public static void functionReturningPredicate() {
        System.out.println("Function returning predicate for custom logic");
        List<Integer> values = Arrays.asList(1, 2, 3, 7, 4, 5, 10);

        //Function takes integer and return predicate for integer
        Function<Integer, Predicate<Integer>> isGreaterThanN = pivot -> //Take a pivot such that we apply predicate on that pivot
                number -> number > pivot; //Predicate to be returned

        //Declarative way of finding first element greater than 4
        int result = values.stream()
                .filter(isGreaterThanN.apply(4))
                .findFirst()
                .get();
        
        System.out.println("result:" + result);
        System.out.println("X---------------------X\n");
    }
}
