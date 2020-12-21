package com.anwar.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * This class has sample codes to understand important functional interfaces
 * @author anwarsahib
 */
public class function {

    public static void main(String args[]) {
        int n = inc(0);
        System.out.println("Increment by 1 using function:" + n);
        n = add1Fn.apply(2);
        System.out.println("Increment by 1 using functional interface:" + n);
        
        //andThen() returns a function of type mul10Fn
        Function<Integer, Integer> add1AndMul10Fn = add1Fn.andThen(mul10Fn);
        n = add1AndMul10Fn.apply(2);
        System.out.println("Chaining functional interface:" + n);
        //n =  addOneFn.andThen(mul10Fn).apply(2); More shorter way to write it
        
        
        n = add1AndMulNFn.apply(5, 10); //Equivanlet to inc1AndMulN(5, 10);
        System.out.println("Bifunction output:" + n);
        
        //All other Functions and BiFuntions are variations of the same concept with different data types
    }

    //Imperative approach
    static int inc(int n) {
        return n + 1;
    }
    
    static int inc1AndMulN(int n, int mulByN) {
        return (n + 1) * mulByN;
    }

    //Funtional interface which takes an integer and returns integer
    static Function<Integer, Integer> add1Fn = n -> n + 1;
    static Function<Integer, Integer> mul10Fn = n -> n * 10;
    
    //Funtional interface which takes two integers and returns an integer
    static BiFunction<Integer, Integer, Integer> add1AndMulNFn = (n, m) -> (n + 1) * m;

}
