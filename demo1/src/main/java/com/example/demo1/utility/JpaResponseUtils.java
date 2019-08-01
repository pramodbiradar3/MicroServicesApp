package com.example.demo1.utility;

import java.util.Optional;

public class JpaResponseUtils<T> {
	
	public static <T>T optionalToObject(Optional<T> employeeOptional,Class<T> class1){
		if(employeeOptional.isPresent()) {
			return  (T)class1.cast(employeeOptional.get()); 
		}
		return null;
	}
}
