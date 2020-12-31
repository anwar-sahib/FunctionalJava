package com.anwar.functionalinterface;

import java.util.Optional;

/** Sample code to understand optional 
 * @author anwarsahib
 */
public class optional {

    public static void main(String args[]) {

        Optional testOptional = Optional.ofNullable("Testing Optional");
        Optional nullOptional = Optional.ofNullable(null);
        
        //Optional with null value gives Optional.empty
        System.out.println("Non-null Optional : " + testOptional);
        System.out.println("Null Optional : " + nullOptional);
        
        
        //Getting value from optional
        System.out.println("Non-null Optional Value: " + testOptional.get());
        //This will throw java.util.NoSuchElementException. Use orElseGet() in this case
        //System.out.println("Null Optional : " + nullOptional.get());
        
        System.out.println("Using get with else : " + nullOptional.orElseGet(
             () ->  "Value not present" //A supplier 
        ));
        
        
        //Usage of Map 
        // Get the address of a user if it is present and print it if the user is from India
        UserMap userMap = new UserMap("AUser","India");
        Optional<UserMap> nullUser  = Optional.ofNullable(null);
        Optional<UserMap> testUser = Optional.of(userMap); //Optional type has to specified as User, otherwise we get java.lang.RuntimeException: Uncompilable source code
        
        /* Imeprative Style
        if(user != null) {
            Address address = user.getAddress();
            if(address != null && address.getCountry().equalsIgnoreCase("India")) {
                    System.out.println("User belongs to India");
            }
        } */
        
        testUser.map(UserMap::getCountry)
                .filter(country -> country.equalsIgnoreCase("India"))
                .ifPresent(india -> System.out.println("User of " + india));
        
        
        Optional nullCountry = nullUser.map(UserMap::getCountry);
        System.out.println("Map retruning null when no value present : " + nullCountry);
        
        
        //Usage of flatMap 
        //Flatmap is used when there is object inside the object with function returning optional
        UserFlatMap userFlatMap = new UserFlatMap("AUser", Optional.of(new Address("TestAddress", "India")));
        Optional<UserFlatMap> testUser1 = Optional.of(userFlatMap); 
         
        
        testUser1.flatMap(UserFlatMap::getAddress)
                 .map(Address::getCountry)
                 .filter(country -> country.equalsIgnoreCase("India"))
                 .ifPresent(india -> System.out.println("User of " + india + " using flatmap"));
    }
    
    public static class UserMap{
        private final String name;
        private final String country;
        
        public UserMap(String name, String country){
            this.name = name;
            this.country = country;
        }
        
        public String getName(){
            return name;
        }
        
        public String getCountry(){
            return country;
        }
    }

    public static class UserFlatMap {
        private final String name;
        private final Optional<Address> address;
        
        public UserFlatMap(String name, Optional<Address> address){
            this.name = name;
            this.address = address;
        }
        
        public String getName(){
            return name;
        }
        
        public Optional<Address> getAddress(){
            return address;
        }
    }
    
    
    public static class Address {
        private final String address;
        private final String country;
        
        public Address(String address, String country){
            this.address = address;
            this.country = country;
        }
        
        public String getCountry(){
            return country;
        }
        
        public String getAddress(){
            return address;
        }
        
    }
    
}
