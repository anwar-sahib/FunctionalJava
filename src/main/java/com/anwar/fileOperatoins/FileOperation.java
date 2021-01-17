package com.anwar.fileOperatoins;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class shows example of performing basic read/write/update operation on file 
 * @author anwarsahib
 */
public class FileOperation {
    
    public static void main(String args[]) {
        String filePath = "/Users/anwarsahib/file/test.txt";
        write(filePath);
        read(filePath);
    }
    
    private static void read(String path) {
        try {
            //Read the contents of the file in a string
            String fileContents = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println("Reading in a string:"+ fileContents);
            
            //Read the contents of the file line by line
            List<String> fileLines = Files.readAllLines(Paths.get(path));
            System.out.println("Reading line by line");
            for (String line : fileLines) {
                System.out.println(line);
            }
            
            
            //Read the contents of the file directly into stream
            Stream<String> stream = Files.lines(Paths.get(path));
            //For reading in other encoding - Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8);

            System.out.println("Reading in a stream");
            // apply filters and print all lines
            stream.map(String::trim)
                    .filter(l -> !l.isEmpty())
                    .forEach(System.out::println);
           
            stream.close();  // do remember to close the stream or use try with resources
        } catch (IOException ex) {
            System.err.println("Error reading file contents:" + ex.getMessage());
        }
    }
    
    
    private static void write(String path) {
        try {
            String contents = " Testing writing content to files ";
            Files.write(Paths.get(path), contents.getBytes());

            //StandardOpenOption provides option to do various type of file operartion.
            contents = " and appending to existing";
            Files.write(Paths.get(path), contents.getBytes(), StandardOpenOption.APPEND);
            
            
            //Writing Encoded content
            //List<String> listContents = Arrays.asList(" Writing Encoded", "content");
            //Files.write(Paths.get(path), listContents, StandardCharsets.UTF_8,StandardOpenOption.CREATE);
            
            
        } catch (IOException ex) {
            System.err.println("Error writing file contents:" + ex.getMessage());
        }
    }

}
