package com.blogspot.jpdevelopment.gti;

import java.time.*;

public class GtiStatusChange {
	private final String gtiIntr;
	private final String status;
	private final LocalDate date;
	private final String serverName;
	private final String username;
	private final String password;
	private final String databaseName;
	private final String wsHostname;
	
	public GtiStatusChange(String gtiIntr, String status, LocalDate date, String serverName, String username, String password, String databaseName, String wsHostname) {
		this.gtiIntr = gtiIntr;
		this.status = status;
		this.date = date;
		this.serverName = serverName;
		this.username = username;
		this.password = password;
		this.databaseName = databaseName;
		this.wsHostname = wsHostname;
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
	
	public String getServerName() {
		return serverName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public String getWsHostname() {
		return wsHostname;
	}
}
