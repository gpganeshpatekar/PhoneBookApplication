package com.demo.phonebookapp.services;

import java.util.List;

import com.demo.phonebookapp.entities.Contact;

public interface ContactServicesI {
	
	  boolean saveContact(Contact contact);
	  List<Contact>  getAllContact();
	  Contact    getContactById(Integer contactId);
	  Contact updateContact(Contact contact,Integer contactId);
	  boolean deleteContactById(Integer contactId);

}
