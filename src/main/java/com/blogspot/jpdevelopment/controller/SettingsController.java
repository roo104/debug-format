/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.controller;

import java.net.*;
import java.util.*;

import com.blogspot.jpdevelopment.settings.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class SettingsController implements Initializable {
	
	@FXML
	private TextField serverName;
	@FXML
	private TextField databaseName;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private TextField wsEndpoint;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Settings settings = Settings.getInstance();
		serverName.setText(settings.getServerName());
		databaseName.setText(settings.getDatabaseName());
		username.setText(settings.getUsername());
		password.setText(settings.getPassword());
		wsEndpoint.setText(settings.getWsEndpoint());
	}
	
	public void updateSettings(ActionEvent actionEvent) {
		Settings settings = Settings.getInstance();
		settings.updateSetting(Settings.LIVA_DATABASE_SERVER_NAME, serverName.getText());
		settings.updateSetting(Settings.LIVA_DATABASE_NAME, databaseName.getText());
		settings.updateSetting(Settings.LIVA_DATABASE_USERNAME, username.getText());
		settings.updateSetting(Settings.LIVA_DATABASE_PASSWORD, password.getText());
		settings.updateSetting(Settings.LIVA_WS_ENDPOINT, wsEndpoint.getText());
	}
}
