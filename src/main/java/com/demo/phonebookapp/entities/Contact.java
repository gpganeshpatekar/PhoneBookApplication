package com.demo.phonebookapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Entity
@Table(name = "CONTACT_DTLS")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	@NotEmpty
	@Size(max = 2,message = "name must be min of 2 characters")
	private String contactName;
	
	@Column(name="CONTACT_NUMBER")
	@NotEmpty
	@Pattern(regexp = "[0|91)?[7-9][0-9]{9}",message = "Please enter valid contact number..")
	private String contactNumber;
	
	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+",message = "Please enter valid email id ex. abc@mail.com")
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="ACTIVE_SWITCH")
	private Character activeSwitch;
	
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE",insertable = false)
	@CreationTimestamp
	private LocalDate  updateDate;

}
