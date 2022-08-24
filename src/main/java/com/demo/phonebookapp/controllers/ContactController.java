package com.demo.phonebookapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		if(contactById != null) {
			return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
		}else {
			String msg = "Contact Not Found.. Invalid Contact Id..";
			return new ResponseEntity(msg,HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@PutMapping(value = "/updateContact",consumes = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean update = contactServiceI.updateContact(contact);
		if(update == true) {
			String msg = "Contact Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}else {
			String msg = "Contact Not Updated";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value = "/deleteContactById/{contactId}")
	public ResponseEntity<String> updateContact(@PathVariable Integer contactId){
		boolean deleteById = contactServiceI.deleteContactById(contactId);
		if(deleteById == true) {
//			return new ResponseEntity<String>("Contact Deleted Successfully", HttpStatus.OK);
			return new ResponseEntity<String>("Record Deleted Successfully", HttpStatus.OK);
		}else {
//			return new ResponseEntity<String>("Can't Delete Contact.. Invalid Contact ID", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<String>("Can't Delete Record.. Invalid ID", HttpStatus.BAD_REQUEST);
		}
	}
}
