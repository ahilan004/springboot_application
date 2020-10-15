package com.example.hackathon.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.hackathon.model.Trade;
import com.example.hackathon.model.Users;
import com.example.hackathon.repository.UsersRepository;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/list")
	public List<Users> getAll(){
		return usersRepository.findAll();	
		}
	
	
	 @RequestMapping(method=RequestMethod.POST, value="/add")
	 public void addUser(@RequestBody Users user) {
			
			 user.set_id(ObjectId.get());
			 if(checkUser(user)==true)
			 {
			 usersRepository.save(user);
			
			 }
			 
	
	
	}
	 
	
	//@GetMapping(value = "/check/{uname}") 
	public boolean checkUser(Users user)
	{
		List<Users> userList = getAll();
		
		  //Iterator<Users> iterator = userList.iterator();
	      for (int i = 0; i <userList.size(); i++) {
			    if(userList.get(i).getUsername().equals(user.username)) {
			    	return false;
			    }
	      }
		
		
		return true;
	}
	
	
	
}
	
