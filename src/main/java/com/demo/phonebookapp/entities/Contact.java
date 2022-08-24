package com.demo.phonebookapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Entity
@Table(name = "CONTACT_DTLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	@NotEmpty
	private String contactName;
	
	@Column(name="CONTACT_NUMBER")
	private String contactNumber;
	

	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="ACTIVE_SWITCH")
	private Character activeSwitch;
	
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate  updateDate;

}
