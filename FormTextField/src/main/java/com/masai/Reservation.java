package com.masai;

public class Reservation {  
	  
    private String firstName;  
    private String lastName;  
    private String Gender;  
    private String[] Food;  
    
    public Reservation()  
    {         
    }  
    
    public String getFirstName() {  
        return firstName;  
    }  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
    public String getLastName() {  
        return lastName;  
    }  
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    }  
    public String getGender() {  
        return Gender;  
    }  
    public void setGender(String gender) {  
        Gender = gender;  
    }  
    public String[] getFood() {  
        return Food;  
    }  
    public void setFood(String[] food) {  
        Food = food;  
    }         
}  
	
	
