package com.demo.phonebookapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.phonebookapp.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
