package com.demo.phonebookapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.phonebookapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
