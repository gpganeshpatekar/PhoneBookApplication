package com.demo.phonebookapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.phonebookapp.entities.Contact;
import com.demo.phonebookapp.repositories.ContactRepository;
import com.demo.phonebookapp.services.ContactServicesI;


@Service
public class ContactServicesImpl implements ContactServicesI {
	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public boolean saveContact(Contact contact) {
		Contact save = contactRepository.save(contact);
		if(save!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact updateContact(Contact contact, Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
