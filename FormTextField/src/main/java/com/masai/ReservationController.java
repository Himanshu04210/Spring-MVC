package com.masai;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;  
  
@Controller  
public class ReservationController {  
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
    @RequestMapping("/bookingForm")  
	public String bookingForm(Model model)  
	{  
	      //create a reservation object   
	    Reservation res=new Reservation();  
	      //provide reservation object to the model   
	    model.addAttribute("reservation", res);  
	    return "reservation-page";  
	}  
    
	@RequestMapping("/submitForm")  
	public String submitForm(Model model)  
	{  
	   
		Reservation r1 = new Reservation("Rahul", "Kumar", "Male");
		
		Reservation r2 = new Reservation("Priti", "Tiwari", "Female");
		Reservation r3 = new Reservation("Aman", "astel", "Male");
		
		List<Reservation> list = Arrays.asList(r1, r2, r3);
		
		model.addAllAttributes(list);
		
		return "confirmation-page";  
	}  
}  
