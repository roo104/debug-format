package com.blogspot.jpdevelopment.gti;

import java.time.*;

public class GtiStatusChange {
	private final String gtiIntr;
	private final String status;
	private final LocalDate date;
	
	public GtiStatusChange(String gtiIntr, String status, LocalDate date) {
		this.gtiIntr = gtiIntr;
		this.status = status;
		this.date = date;
	}
	
	public String getGtiIntr() {
		return gtiIntr;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDate getDate() {
		return date;
	}
		
}
