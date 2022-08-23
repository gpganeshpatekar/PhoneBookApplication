package com.demo.phonebookapp.services.impl;

import java.util.List;
import java.util.Optional;

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
		List<Contact> findAll = contactRepository.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = contactRepository.findById(contactId).get();
		return contact;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact update = contactRepository.save(contact);
		if(update == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
