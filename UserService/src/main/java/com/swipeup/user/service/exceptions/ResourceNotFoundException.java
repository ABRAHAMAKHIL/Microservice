package com.swipeup.user.service.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String fieldValue;
	private String fieldId;
	
	public ResourceNotFoundException(String fieldName,String fieldValue, String fieldId){
		
		super(String.format("%s is not found with %s: %s",fieldName,fieldValue,fieldId));
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.fieldId = fieldId;
		
	}

}
