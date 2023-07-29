package com.masai;

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
	public String submitForm(@ModelAttribute("reservation") Reservation res)  
	{  
	    return "confirmation-page";  
	}  
}  
