package com.springBootWithREST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springBootWithREST.Dao.CardDaoRepo;
import com.springBootWithREST.model.CardObject;



//@Controller 
@RestController // instead of using controller use RestController.
public class CardController {
	

	@Autowired
	private CardDaoRepo repo;

	@RequestMapping("/")
	public String home() {

		return "home";
	}
	
	@GetMapping(path ="/details/{cardNo}/{name}/{cvv}",produces = {"application/JSON"})
	public CardObject cardDetails(@PathVariable("cardNo")long cardNo, @PathVariable("name")String name,@PathVariable("cvv")int cvv)
	{
		
		  System.out.println(cardNo+ "," +name+ " ," +cvv); 
		  CardObject co= null;
		  co=  repo.findByCardNo(cardNo);
		  
		  if(co==null || !co.validate(cardNo,name,cvv)) {
		  
		  co = new CardObject(cardNo,null, null,0);
		  
		  }
		
       return co;
				
			
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
