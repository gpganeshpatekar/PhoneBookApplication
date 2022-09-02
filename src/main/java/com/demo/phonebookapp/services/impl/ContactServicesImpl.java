package com.demo.phonebookapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<Contact> contacts = findAll.stream().filter(contact->contact.getActiveSwitch() == 'Y').collect(Collectors.toList());
		return contacts;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
//		Optional<Contact> findById = contactRepository.findById(contactId);
//		
//		if(findById.isPresent()) {
//			Contact contact = findById.get();
//			return contact;
//		}else {
//			return null;
//		}
		Contact contact = contactRepository.findById(contactId).get();
		if(contact.getActiveSwitch()=='Y') {
			return contact;
		}else {
			return null;
		}
	}

	@Override
	public boolean updateContact(Contact contact) {
		Optional<Contact> contact1 = contactRepository.findById(contact.getContactId());
		if(contact1.isPresent()) {
			Contact update = contactRepository.save(contact);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		
	// condition for checking if id is available in database
	// by using existBy
	// boolean existsById = contactRepository.existsById(contactId);
		
	// if(existsById) {
			// for hard delete
	//		contactRepository.deleteById(contactId);
	//		return true;
	//	}else {
	//		return false;
	//	}

		// condition for checking if id is available in database
		// by using existBy
		Optional<Contact> contact = contactRepository.findById(contactId);
		
		if(contact.isPresent()) {
			// for soft delete
			Contact contact1 = contact.get();
			contact1.setActiveSwitch('N');
			contactRepository.save(contact1);
			return true;
		}else {
			return false;
		}		
		
		
	}
	
}
