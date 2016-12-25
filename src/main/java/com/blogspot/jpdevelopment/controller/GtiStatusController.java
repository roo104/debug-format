/**
 * Copyright Schantz A/S, all rights reserved
 */
package com.blogspot.jpdevelopment.controller;

import com.blogspot.jpdevelopment.gti.*;
import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class GtiStatusController {
	
	@FXML
	private TextField gtiIntr;
	@FXML
	private ChoiceBox<GtiStatus> newStatus;
	@FXML
	private DatePicker date;
	@FXML
	private ProgressBar gtiUpdateProgressBar;
	@FXML
	private TextField serverName;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	public void changeStatus(ActionEvent actionEvent) throws Exception {
		Platform.runLater(() -> {
			try {
				if (validInvocation()) {
					gtiUpdateProgressBar.setVisible(true);
					gtiUpdateProgressBar.setProgress(0.5D);
					GtiChangeStatus gtiChangeStatus = new GtiChangeStatus();
					gtiChangeStatus.changeStatus(gtiIntr.getText(), newStatus.getValue().getValue(), date.getValue(), serverName.getText(), username.getText(), password.getText());
					gtiUpdateProgressBar.setVisible(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	private boolean validInvocation() {
		boolean validInvocation = true;
		
		StringBuilder sb = new StringBuilder();
		if (gtiIntr.getText().isEmpty()) {
			validInvocation = false;
			sb.append("- Du skal indtaste et GTI interessentnummer\n");
		}
		if (newStatus.getValue() == null) {
			validInvocation = false;
			sb.append("- Du skal vælge en status\n");
		}
		if (date.getValue() == null) {
			validInvocation = false;
			sb.append("- Du skal vælge en dato");
		}
		
		if (!validInvocation) {
			Alert dialog = new Alert(Alert.AlertType.WARNING);
			dialog.setHeaderText("Manglende informationer");
			dialog.setContentText(sb.toString());
			dialog.show();
		}
		
		return validInvocation;
	}
}
