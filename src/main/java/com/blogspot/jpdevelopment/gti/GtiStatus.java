/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.gti;

public class GtiStatus {
	
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
