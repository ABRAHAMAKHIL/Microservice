package com.swipeup.hotel.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String resourceName;
	String resourceValue;
	String resourceId;
	
	public ResourceNotFoundException(String resourceName,String resourceValue,String resourceId){
		super(String.format("%s is not found with %s: %s",resourceName,resourceValue,resourceId));
		this.resourceName = resourceName;
		this.resourceValue = resourceValue;
		this.resourceId = resourceId;
		
	}

}
