package com.example.Blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
String resourceName;
String fieldName;
Long fieldvalue;
public ResourceNotFoundException(String resourceName, String fieldName, Long fieldvalue) {
	super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldvalue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldvalue = fieldvalue;
}



}
