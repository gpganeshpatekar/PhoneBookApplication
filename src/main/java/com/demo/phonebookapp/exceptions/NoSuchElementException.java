package com.demo.phonebookapp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NoSuchElementException extends RuntimeException {
	
	String resourceName;
	String fieldName;
	long fieldValue;
	
	public NoSuchElementException(String resourceName, String fieldName, long fieldValue){
		
		super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	


}
