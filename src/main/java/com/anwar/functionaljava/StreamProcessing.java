package com.anwar.functionaljava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class shows various examples of data processing using streams
 * @author anwarsahib
 */
public class StreamProcessing {

    public static void main(String args[]){
        
        List<String> listA = Arrays.asList("a","b","c","b","e","g","a","z");
        List<String> listB = Arrays.asList("c","b","h","p","e","r");
        
        //Find common elements between two lists
        List<String> commonList  = listA.stream()
             .filter(listB::contains)
             .collect(Collectors.toList());  
        
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
         List<String> unCommonList  = totalList.stream()
             .filter(e -> !commonList.contains(e))
             .collect(Collectors.toList()); 
        
        System.out.println("--------Uncommon elements----------");
        unCommonList.stream()
             .forEach(System.out::println);
        
        
        //Find duplicate elements in the list
        Set<String> checkSet = new HashSet<>();
        List<String> duplicateList = listA.stream()
            .filter(e -> !checkSet.add(e))
            .collect(Collectors.toList());
        
        System.out.println("--------Duplicate elements----------");
        duplicateList.stream()
             .forEach(System.out::println);
    }
}
