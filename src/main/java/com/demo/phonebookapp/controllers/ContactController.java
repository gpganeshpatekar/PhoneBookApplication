package com.demo.phonebookapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.phonebookapp.entities.Contact;
import com.demo.phonebookapp.services.ContactServicesI;

@RestController
public class ContactController {
	
	@Autowired
	private ContactServicesI contactServiceI;
	
	@PostMapping(value = "/saveContact",consumes = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		boolean save = contactServiceI.saveContact(contact);
		if(save == true) {
			String msg = "Contact Saved Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}else {
			String msg = "Contact Not Saved";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getAllContact", produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact(){
		List<Contact> allContact = contactServiceI.getAllContact();
		if(allContact != null) {
			return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
		}else {
			String msg = "Data Not Found";
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getContactById/{contactId}", produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId){
		Contact contactById = contactServiceI.getContactById(contactId);
			return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
	}
}
