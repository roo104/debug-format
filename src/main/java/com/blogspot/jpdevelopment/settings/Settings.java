/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.settings;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

import org.slf4j.*;

public class Settings {
	
	public static final String LIVA_DATABASE_SERVER_NAME = "liva.database.server-name";
	public static final String LIVA_DATABASE_NAME = "liva.database.name";
	public static final String LIVA_DATABASE_USERNAME = "liva.database.username";
	public static final String LIVA_DATABASE_PASSWORD = "liva.database.password";
	public static final String LIVA_WS_ENDPOINT = "liva.ws.endpoint";
	public static final String SCHANTZ_PROPERTIES = "schantz.properties";
	private static final Logger log = LoggerFactory.getLogger(Settings.class);
	private static Settings instance;
	private final Properties properties = new Properties();
	private final String serverName;
	private final String databaseName;
	private final String username;
	private final String password;
	private final String wsEndpoint;
	
	private Settings() {
		loadProperties();
		this.serverName = properties.getProperty(LIVA_DATABASE_SERVER_NAME);
		this.databaseName = properties.getProperty(LIVA_DATABASE_NAME);
		this.username = properties.getProperty(LIVA_DATABASE_USERNAME);
		this.password = properties.getProperty(LIVA_DATABASE_PASSWORD);
		this.wsEndpoint = properties.getProperty(LIVA_WS_ENDPOINT);
	}
	
	public static Settings getInstance() {
		if (instance == null) {
			instance = new Settings();
		}
		return instance;
	}
	
	private static String getUserDataDirectory() {
		return System.getProperty("user.home") + File.separator + SCHANTZ_PROPERTIES;
	}
	
	public void updateSetting(String key, String value) {
		properties.setProperty(key, value);
	}
	
	public void updateSettings() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getUserDataDirectory()), StandardCharsets.UTF_8))) {
			properties.store(writer, "");
			
		} catch (IOException e) {
			log.error("Error updating settings", e);
		}
	}
	
	private void loadProperties() {
		try {
			File file = new File(getUserDataDirectory());
			properties.load(new FileReader(file));
		} catch (IOException e) {
			loadDefaultProperties();
		}
	}
	
	private void loadDefaultProperties() {
		try {
			properties.load(getClass().getResourceAsStream("/" + SCHANTZ_PROPERTIES));
		} catch (IOException e) {
			log.error("Error loading default properties", e);
		}
	}
	
	public String getServerName() {
		return serverName;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getWsEndpoint() {
		return wsEndpoint;
	}
}
