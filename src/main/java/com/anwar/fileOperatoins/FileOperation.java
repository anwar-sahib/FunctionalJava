package com.anwar.fileOperatoins;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class shows example of performing basic read/write/update operation on file 
 * @author anwarsahib
 */
public class FileOperation {
    
    public static void main(String args[]){
        String filePath = "/Users/anwarsahib/file/test.txt";
        read(filePath);
    }
    
    private static void read(String path){
        try {
            //Read the contents of the file in a string
            String fileContents = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println(fileContents);
        } catch (IOException ex) {
            System.err.println("Error reading file contents:" + ex.getMessage());
        }
    }

}
