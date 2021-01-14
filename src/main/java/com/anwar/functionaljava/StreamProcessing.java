package com.anwar.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class shows various examples of data processing using streams
 * @author anwarsahib
 */
public class StreamProcessing {

    public static void main(String args[]){
        
        List<String> listA = Arrays.asList("a","b","c","b","e","g","a","z","a");
        List<String> listB = Arrays.asList("c","b","h","p","e","r");
        
        //Find common elements between two lists
        Set<String> commonList  = listA.stream()
             .filter(listB::contains)
             .collect(Collectors.toSet());  
        
        System.out.println("--------Common elements----------");
        commonList.stream()
             .forEach(System.out::println);
        
        
        //Find elements that are not common in both lists
        List<String> totalList = new ArrayList<>();  //Find total list
        listA.stream()
             .forEach(totalList::add);
        listB.stream()
             .forEach(totalList::add);
        
        //Filter out common elements
         Set<String> unCommonList  = totalList.stream()
             .filter(e -> !commonList.contains(e))
             .collect(Collectors.toSet()); 
        
        System.out.println("--------Uncommon elements----------");
        unCommonList.stream()
             .forEach(System.out::println);
        
        
        //Find duplicate elements in the list
        Set<String> checkSet = new HashSet<>();
        Set<String> duplicateList = listA.stream()
            .filter(e -> !checkSet.add(e))
            .collect(Collectors.toSet());
        
        System.out.println("--------Duplicate elements----------");
        duplicateList.stream()
             .forEach(System.out::println);
        
        //Find the duplicate elements and count how many times they are present
        Map<String, Long> occurances = listA.stream()
             .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        
        System.out.println("--------No of occurances of duplicate elements----------");
        occurances.forEach((k, v) -> {
            if (v > 1) {
                System.out.println(k + " : " + v);
            }
        });
        
    }
}
