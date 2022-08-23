package com.demo.phonebookapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.phonebookapp.entities.Contact;
import com.demo.phonebookapp.services.ContactServicesI;

@RestController
@RequestMapping("contact/")
public class ContactController {
	
	@Autowired
	private ContactServicesI contactServiceI;
	
	@PostMapping("/")
	public ResponseEntity<String> saveContact(@Valid @RequestBody Contact contact){
		boolean save = contactServiceI.saveContact(contact);
		if(save == true) {
			String success = "Contact Saved Successfully";
			return new ResponseEntity<String>(success,HttpStatus.CREATED);
		}else {
			String unsuccess = "Unable To Save Contact..";
			return new ResponseEntity<String>(unsuccess, HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
